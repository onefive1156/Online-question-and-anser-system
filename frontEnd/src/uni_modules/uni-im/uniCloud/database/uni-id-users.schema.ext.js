// schema扩展相关文档请参阅：https://uniapp.dcloud.net.cn/uniCloud/jql-schema-ext.html
const db = uniCloud.database();
const dbCmd = db.command
module.exports = {
	trigger: {
		async afterReadAsSecondaryCollection(e) {
			await afterReadAction(e, true)
		},
		async afterRead(e) {
			await afterReadAction(e)
		}
	}
}

async function afterReadAction({
	field,
	result,
	userInfo: currentUserInfo
} = {}, isGetTemp = false) {
	if (result && field && field.includes("nickname")) {
		//uni-im 处理查询nickname，但值为空的情况
		let {
			data
		} = result
		// 为联查 且为副表时的字段
		if (isGetTemp && typeof(data[0]) == "object" && 'friend_uid' in data[0]) {
			data = data.map(item => item.friend_uid[0])
		}

		// console.log('data',data);
		if (!Array.isArray(data)) {
			data = [data]
		}
		// 记录没有nickname的用户id
		let user_ids = [],
			usersInfo = {};
		data.forEach(item => {
			if (item && !item.nickname) {
				user_ids.push(item._id)
			}
		})
		if (user_ids.length) {
			console.info('注意：uni-im项目用户数据依赖nickname。有' + user_ids.length +
				`个用户数据 nickname 的值为空，已多执行一次数据库查询：将此用户的“用户名”或“邮箱”或“手机号”脱敏后，作为nickname输出。请引导用户完善nickname，减少查库次数`)
			let res = await db.collection('uni-id-users')
				.where({
					_id: dbCmd.in(user_ids)
				})
				.field({
					username: true,
					email: true,
					mobile: true
				})
				.get()
			usersInfo = res.data.reduce((sum, current) => {
				sum[current._id] = current
				return sum
			}, {})
		}

		let isUniImAdmin = currentUserInfo.role.includes('uni-im-admin') || currentUserInfo.role.includes('admin')

		data.forEach(item => {
			if (!item.nickname) {
				let userInfo = usersInfo[item._id]
				// 管理员不更改
				if (!isUniImAdmin) {
					item.nickname = hideUsernameStr(userInfo.username) || hideEmailStr(userInfo.email) ||
						hideMobileStr(userInfo.mobile)
				}
			}

			// 特殊处理某个用户xxx
			if (item._id == "xxx") {
				item.nickname = "xxx"
				item.avatar_file = {
					url: "xxx"
				}
			}

		})

		function hideUsernameStr(username) {
			if (username == undefined) {
				return false
			}
			let length = username.length
			let n = parseInt(length / 2.5) * 2
			return username.substr(0, length - n) + '**' + username.substr(-1 * n / 2)
		}

		function hideEmailStr(email) {
			if (email == undefined) {
				return false
			}
			const content = email.split("@")
			return content[0].substr(0, content[0].length - 2) + '**' + content[1]
		}

		function hideMobileStr(mobile) {
			if (mobile == undefined) {
				return false
			}
			return mobile.substr(0, 3) + '****' + mobile.substr(-1 * 4)
		}
	}
}