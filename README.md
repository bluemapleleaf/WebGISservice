# 地理信息网络服务构建
## 系统描述
系统描述

### 技术栈

#### 后端

- 数据库：mysql
- 持久化层：mybatis，mybatis-plus
- mvc框架：springmvc
- 应用层容器：springboot

#### 前端

- js框架：vue

## 分层架构
- API文档说明：（待补）

- 后端

    后端基于MVC架构，分为`Controller`层，`Service`层，`Dao`层经典三层架构。

    - `Controller`层

        采取Restful风格，`Controller`层均使用`@RestController`注解，前后端交互使用JSON格式数据，定义的数据格式详见springboot项目文件夹下的源代码里的common文件夹下的`Result.java`,统一格式为`Result`类的类型格式。

    - `Service`层

        利用mybatis-plus，继承其提供的服务类，省去基本的单表的增删改查操作，获得封装好的函数。

    - `Dao`层

        数据库使用mysql进行存储，并利用mybatis-plus进行架构，省去基本的单表的数据库操作

- 前端

    前端利用vue



## 使用方法

### 后端运行

- 配置`mysql`数据库

    `mysql`版本要求：8.0以上

    运行springboot项目文件夹下的resource目录（src/main/resources）下的`webservice.sql`文件导入数据库。

- 修改项目配置文件

    - 修改resource目录下的`application.yml`中的`datasource`配置中的`url`,`username`,`password`:

        ```yml
        spring:
          datasource:
            driver-class-name: com.mysql.cj.jdbc.Driver
            url: your database url (jdbc:mysql://localhost:3306/webservice?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC)
            username: your username
            password: your password
        ```

    - ……

- 运行主函数

    主函数位于`src`目录下`java`源代码里的`DemoApplication.java`文件中的`DemoApplication`类里

## 开发日志

开发日志

