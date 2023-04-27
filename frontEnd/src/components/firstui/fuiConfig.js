/*
  组件属性全局配置文件。优先级：全局配置文件props < 直接设置组件props
  目前支持配置的组件：fui-button、fui-icon、fui-text、fui-input、fui-form-item
*/

const fuiConfig = {
    //组件名称，小驼峰命名
    //如fui-button写成fuiButton
    fuiButton: {
        //组件props，详细描述请查看各组件文档
        height: '96rpx',
        size: 32,
        radius: '16rpx',
    },
    fuiIcon: {
        size: 64,
        unit: 'rpx'
    },
    fuiText: {
        size: 32,
        unit: 'rpx'
    },
    fuiInput: {
        labelSize: 32,
        size: 32
    },
    fuiFormItem: {
        labelSize: 32,
        labelWidth: 160,
        labelRight: 30,
        //V1.9.0+
        labelAlign: 'left',
        //V1.9.0+
        asteriskPosition: 'left'
    }
}

export default fuiConfig
