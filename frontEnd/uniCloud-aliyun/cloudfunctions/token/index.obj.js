const uniID = require('uni-id-common')
module.exports = {
	_before() {
		const clientInfo = this.getClientInfo()
		this.uniID = uniID.createInstance({ // 创建uni-id实例，其上方法同uniID
			clientInfo
		})
	},
	refreshToken() {
		// ...
	// this.uniID.refreshToken()
	},
	async checkToken(event) {
		console.log(this.getClientInfo())
		const t = this.getClientInfo().uniIdToken
		const temp = await this.uniID.checkToken(t)
		return {
			status: temp.errCode
		}	// 后续使用uniIDIns调用相关接口
	}
	
}
