<template>
    <el-form
        ref="registerForm"
        :model="registerUser"
        :rules="registerRules"
        label-width="100px"
        class="registerForm sign-up-form"
    >
        <el-form-item label="用户名" prop="name">
            <el-input v-model="registerUser.name" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="手机号码" prop="phone">
            <el-input v-model="registerUser.phoneNumber" placeholder="请输入手机号码"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="address">
            <el-input v-model="registerUser.address" placeholder="请输入地址"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input
                v-model="registerUser.password"
                type="password"
                placeholder="Enter Password..."
            ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="password2">
            <el-input
                v-model="registerUser.password2"
                type="password"
                placeholder="Enter Password..."
            ></el-input>
        </el-form-item>

        <el-form-item label="选择身份">
            <el-select v-model="registerUser.role" placeholder="请选择身份">
                <el-option label="用户" value="1"></el-option>
                <el-option label="维修者" value="2"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item>
            <el-button @click="handleRegister('registerForm')" type="primary" class="submit-btn">注册</el-button>
        </el-form-item>
    </el-form>
</template>

<script setup lang="ts">
import {ref, getCurrentInstance} from "vue";
import axios from 'axios' // 仅限在当前组件使用
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";
import {useStore} from "vuex";

defineProps({
    registerUser: {
        type: Object,
        required: true,
    },
    registerRules: {
        type: Object,
        required: true,
    },
});

// @ts-ignore
const {proxy} = getCurrentInstance();
const router = useRouter()
const store = useStore()
const handleRegister = (formName: string) => {
    proxy.$refs[formName].validate((valid: boolean) => {
        if (valid) {
            axios.post('/api/users/register', {
                userName: proxy.registerUser.name,
                realName: proxy.registerUser.name,
                password: proxy.registerUser.password,
                phoneNumber: proxy.registerUser.phoneNumber,
                address: proxy.registerUser.address,
                type: proxy.registerUser.role,
            }).then((res: any) => {
                console.log(res);
                ElMessage({
                    message: '注册成功',
                    type: 'success',
                })
                let payload = {
                    userName: proxy.registerUser.name,
                    realName: proxy.registerUser.name,
                    phoneNumber: proxy.registerUser.phoneNumber,
                    type: proxy.registerUser.role,
                    address: proxy.registerUser.address,
                    affiliation: "武汉大学"
                }
                store.commit('changeUser', payload)
                router.push('/')
            });
        } else {
            console.log("error submit!!");
            proxy.$message({
                message: '注册失败',
                type: 'error'
            })
            return false;
        }
    });
};
</script>
<style scoped>
</style>
