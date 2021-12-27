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
const {ctx} = getCurrentInstance();

const handleRegister = (formName: string) => {
    ctx.$refs[formName].validate((valid: boolean) => {
        if (valid) {
            axios.post('/api/users/register', {
                params: {
                    userName: ctx.registerUser.name,
                    password: ctx.registerUser.password,
                    phoneNumber: ctx.registerUser.phone,
                    address: ctx.registerUser.address,
                    type: ctx.registerUser.role,
                },
            }).then((res: any) => {
                console.log(res);
            });
        } else {
            console.log("error submit!!");
            return false;
        }
    });
};
</script>
<style scoped>
</style>
