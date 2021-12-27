import {ref} from "vue";

interface RegisterUser {
    name: string;
    phoneNumber: string;
    address: string;
    password: string;
    password2: string;
    role: string;
}

export const registerUser = ref<RegisterUser>({
    name: "",
    phoneNumber: "",
    address: "",
    password: "",
    password2: "",
    role: "",
});

interface RegisterRules {
    name: ({
        message: string;
        required: boolean;
        trigger: string;
    } | {
        min: number;
        max: number;
        message: string;
        trigger: string;
    })[];
    phoneNumber: {
        type: string;
        message: string;
        required: boolean;
        trigger: string;
    }[];
    address: {
        type: string;
        message: string;
        required: boolean;
        trigger: string;
    }[];
    password: ({
        required: boolean;
        message: string;
        trigger: string;
    } | {
        min: number;
        max: number;
        message: string;
        trigger: string;
    })[];
    password2: ({
        required: boolean;
        message: string;
        trigger: string;

    } | {
        min: number;
        max: number;
        message: string;
        trigger: string;

    } | {
        validator: (rule: RegisterRules, value: string, callback: any) => void;
        trigger: string;
    })[];
}

const validatePass2 = (rule: RegisterRules, value: string, callback: any) => {
    if (value === "") {
        callback(new Error("请再次输入密码"));
    } else if (value !== registerUser.value.password) {
        callback(new Error("两次输入密码不一致!"));
    } else {
        callback();
    }
};

export const registerRules = ref<RegisterRules>({
    name: [
        {
            message: "用户名不能为空...",
            required: true,
            trigger: "blur",
        },
        {
            min: 2,
            max: 30,
            message: "长度在2到30个字符",
            trigger: "blur",
        },
    ],
    phoneNumber: [
        {
            type: "string",
            message: "请填写正确的手机号码",
            required: true,
            trigger: "blur",
        },
    ],
    address: [
        {
            type: "string",
            message: "请填写正确的地址",
            required: true,
            trigger: "blur",
        },
    ],
    password: [
        {
            required: true,
            message: "密码不能为空",
            trigger: "blur",
        },
        {
            min: 6,
            max: 30,
            message: "密码长度在6到30个字符",
            trigger: "blur",
        },
    ],
    password2: [
        {
            required: true,
            message: "再次输入密码不能为空",
            trigger: "blur",
        },
        {
            min: 6,
            max: 30,
            message: "密码长度在6到30个字符",
            trigger: "blur",
        },
        {validator: validatePass2, trigger: "blur"},
    ]

});
