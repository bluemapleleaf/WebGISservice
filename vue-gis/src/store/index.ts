import {createStore} from 'vuex'

// 创建一个新的 store 实例
export const store = createStore({
    state() {
        return {
            userName: "",
            realName: "",
            phoneNumber: "",
            type: 1,
            address: "",
            affiliation: ""
        }
    },
    mutations: {
        changeUser(state, payload) {
            // @ts-ignore
            state.userName = payload.userName
            // @ts-ignore
            state.realName = payload.realName
            // @ts-ignore
            state.phoneNumber = payload.phoneNumber
            // @ts-ignore
            state.type = payload.type
            // @ts-ignore
            state.address = payload.address
            // @ts-ignore
            state.affiliation = payload.affiliation
            console.log(state)
        }
    }
})