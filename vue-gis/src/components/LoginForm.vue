<template>
    <el-form
        ref="loginForm"
        :model="loginUser"
        :rules="rules"
        label-width="100px"
        class="loginForm sign-in-form"
    >
        <el-form-item label="用户名" prop="name">
            <el-input v-model="loginUser.name" placeholder="请输入用户名..."></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input v-model="loginUser.password" type="password" placeholder="Enter Password..."></el-input>
        </el-form-item>

        <el-form-item>
            <el-button @click="handleLogin('loginForm')" type="primary" class="submit-btn">提交</el-button>
        </el-form-item>
    </el-form>
</template>

<script setup lang="ts">
import {ref, getCurrentInstance} from "vue";
import axios from "axios";
import {useRouter} from 'vue-router'
import {useStore} from 'vuex'
import {ElMessage} from 'element-plus'

defineProps({
    loginUser: {
        type: Object,
        required: true,
    },
    rules: {
        type: Object,
        required: true,
    },
});


// @ts-ignore
const {ctx} = getCurrentInstance();
const router = useRouter()
const store = useStore()
// 触发登录方法
const handleLogin = (formName: string) => {
    ctx.$refs[formName].validate((valid: boolean) => {
        if (valid) {
            axios.post('/api/users/login', {
                userName: ctx.loginUser.name,
                password: ctx.loginUser.password,
            }).then((res: any) => {
                console.log(res);
                ElMessage({
                    message: '登录成功',
                    type: 'success',
                })
                let payload = {
                    userName: res.data.data.userName,
                    realName: res.data.data.realName,
                    phoneNumber: res.data.data.phoneNumber,
                    type: res.data.data.type,
                    address: res.data.data.address,
                    affiliation: res.data.data.affiliation
                }
                console.log(payload)
                store.commit('changeUser', payload)
                console.log(store.state)
                router.push('/')
            });
        } else {
            console.log("error submit!!");
            return false;
        }
    });
};

</script>


<style scoped>
/* form */
.loginForm {
    margin-top: 20px;
    background-color: #fff;
    padding: 20px 40px 20px 20px;
    border-radius: 5px;
    box-shadow: 0px 5px 10px #cccc;
}

.submit-btn {
    width: 100%;
}

.tiparea {
    text-align: right;
    font-size: 12px;
    color: #333;
}

.tiparea p a {
    color: #409eff;
}
</style>
