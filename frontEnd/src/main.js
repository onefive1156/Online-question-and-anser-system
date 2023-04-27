import {
	createSSRApp
} from "vue"
import App from "./App.vue"
import fuiConfig from "./components/firstui/fuiConfig"
uni.$fui = fuiConfig
export function createApp() {
	const app = createSSRApp(App)
	return {
		app,
	};
}
