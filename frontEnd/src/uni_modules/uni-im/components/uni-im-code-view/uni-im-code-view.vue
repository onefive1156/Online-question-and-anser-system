<template>
	<view class="code-view">
		<rich-text :class="{'narrow':showFullBtn}" v-if="nodes.length" space="nbsp" :nodes="nodes" class="text-box"></rich-text>
		<view v-if="showFullBtn" class="showFullBtn" @click="showFull">
			<text class="tip">- 展开</text>
			<uni-im-icons color="#ccc" code="e6a8" size="30" class="icon"></uni-im-icons> 
		</view>
	</view>
</template>

<script>
	import hljs from 'highlight.js';
	
	import parseHtml from '@/uni_modules/uni-im/components/uni-im-msg/html-parser.js';
	
	export default {
		data() {
			return {
				htmlString:"",
				nodes:[],
			}
		},
		props: {
			showFullBtn:{
				type:Boolean,
				default:true
			},
			code: {
				type: String,
				default(){
					return `
						// demo
						if(this.msg.body == this.htmlString){
							return 123
						}
						try{
							let nodes =  parseHtml(this.htmlString)
							nodes.map(item=>{
								// console.log('item',item);
								if(item.attrs && item.attrs.class){
									item.attrs.class += " msg-text"
								}else{
									item.attrs = {class:"msg-text"}
								}
								return item
							})
							return nodes
						}catch(e){
							//TODO handle the exception
							console.error(e);
							return ""
						}
					`
				}
			},
		},
		mounted() {
			//非全屏模式截取3行
			let code = this.code
			
			if(this.showFullBtn && code.split("\n").length > 3){
				code = code.split("\n").slice(0,3).join("\n")
			}
			
			let res = hljs.highlightAuto(code)
			this.htmlString = res.value
			// console.log('this.htmlString',JSON.stringify(this.htmlString));
			// #ifdef APP-NVUE
				// //添加空格
				this.htmlString = this.htmlString.replace(/\t/g,'<text class="nbsp">__</text>')
				this.htmlString = this.htmlString.replace(/\n/g,'<p>')
				this.htmlString = this.htmlString.replace(/&#x27;/g,'\'')
			// #endif

			
			// #ifndef APP-NVUE
			this.htmlString = `<pre><code>${this.htmlString}</code></pre>`
			// #endif
			
			this.nodes = parseHtml(this.htmlString)
			// console.log(JSON.stringify(this.nodes));
		},
		methods:{
			showFull(){
				uni.navigateTo({
					url:'/uni_modules/uni-im/pages/common/uni-im-code-pages/uni-im-code-pages?code=' + encodeURIComponent(this.code),
					animationType:'slide-in-bottom',
					animationDuration:300
				})
			}
		}
	}
</script>

<style lang="scss">
	/* #ifndef APP-NVUE */
	@import './default.css';
	/* #endif */
	
	.text-box{
		background-color: #fffae5 !important;
		/* background-color: #21231c; */
		width: 500rpx;
		color: #1e7800;
		font-size: 14px;
		border-radius: 10px;
	}
	.code-view{
		position: relative;
		background-color: #fffae5 !important;
		border: solid 10px #fffae5;
		
		/* #ifndef APP-NVUE */
		word-break: break-all;
		tab-size: 2;
		user-select: text;
		cursor: text !important;
		overflow: auto;
		/* #endif */
	}
	.showFullBtn{
		width: 500rpx;
		margin-top: 3px;
		flex-direction: row;
		justify-content: center;
		align-items: center;
	}
	
	.tip{
		color: #ccc;
		font-size: 12px;
		margin-right: -8px;
	}
	
	.nbsp{
		color: #fffae5;
		width: 2px;
	}
	
	.hljs-built_in{
		color: #293dc3;
	}
	.hljs-string{
		color: #008b7e;
	}
	
	.hljs-name,
	.hljs-title {
		color: #f0c674
	}
	
	.hljs-comment,
	.hljs-meta{
		color: #9aabab;
	}
	
	.hljs-deletion,
	.hljs-link,
	.hljs-literal,
	.hljs-number,
	.hljs-symbol {
		color: #c66
	}
	
	.hljs-addition,
	.hljs-doctag,
	.hljs-regexp,
	.hljs-selector-attr,
	.hljs-selector-pseudo,
	.hljs-string {
		color: #b5bd68
	}
	
	.hljs-attribute,
	.hljs-code,
	.hljs-selector-id {
		color: #b294bb
	}
	
	.hljs-bullet,
	.hljs-keyword,
	.hljs-selector-tag,
	.hljs-tag {
		color: #81a2be
	}
	
	.hljs-subst,
	.hljs-template-tag,
	.hljs-template-variable,
	.hljs-variable {
		color: #8abeb7
	}
	
	.hljs-built_in,
	.hljs-quote,
	.hljs-section,
	.hljs-selector-class,
	.hljs-type {
		color: #de935f
	}
	
	.hljs-emphasis {
		font-style: italic
	}
	
	.hljs-strong {
		font-weight: 700
	}
	
	.hljs-keyword{
		color: #8ba400;
	}
	
	.narrow{
		// height: 15px;
		/* #ifndef APP-NVUE */
		overflow: hidden;
		/* #endif */
	}
</style>
