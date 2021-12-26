import matplotlib.pyplot as plt

import random
import numpy as np
import pymysql
import time
import random

#连接数据库
connent = pymysql.connect(host='localhost', user='root', passwd='Wang1212', db='webservice')

def repair():

    apply_id = []
    apply_id.append(int(np.random.uniform(89, 168)))
    apply_id1 = int(apply_id[0])
    repair_id = []
    repair_id.append(int(np.random.uniform(169,248)))
    repair_id1 = int(repair_id[0])

    list3 = ['水','电','木']
    title = random.sample(list3,1)


    longtitude = []
    longtitude.append(np.random.uniform(114.366207, 114.376843))
    longtitude1 = float(longtitude[0])
    latitude = []
    latitude.append(np.random.uniform(30.538832, 30.549407))
    latitude1 = float(latitude[0])
    # 随机返回只有一个值的list

    list4 = ['武汉大学信息学部学生宿舍7舍', '武汉大学信息学部学生宿舍8舍', '武汉大学信息学部学生宿舍9舍',
             '武汉大学文理学部学生宿舍10舍', '武汉大学文理学部学生宿舍11舍', '武汉大学文理学部学生宿舍12舍',
             '武汉大学工学部学生宿舍15舍', '武汉大学工学部学生宿舍7舍', '武汉大学工学部学生宿舍8舍',
             '武汉大学医学部学生宿舍1舍', '武汉大学医学部学生宿舍2舍', '武汉大学医学部学生宿舍3舍']
    place = random.sample(list4, 1)

    a1 = (2018, 1, 1, 0, 0, 0, 0, 0, 0)  # 设置开始日期时间元组（1976-01-01 00：00：00）
    a2 = (2021, 12, 31, 23, 59, 59, 0, 0, 0)  # 设置结束日期时间元组（1990-12-31 23：59：59）

    start = time.mktime(a1)  # 生成开始时间戳
    end = time.mktime(a2)  # 生成结束时间戳
    t1 = random.randint(start, end)  # 在开始和结束时间戳中随机取出一个
    date_touple = time.localtime(t1)  # 将时间戳生成时间元组
    apply_date = time.strftime("%Y-%m-%d %H:%M:%S", date_touple)  # 将时间元组转成格式化字符串（1976-05-21）

    state = random.randint(0,1)
    if title[0] == "水":
        list = ['水龙头阀芯更换', '水龙头整体更换', '水龙头漏水',
                '阀门漏水', '阀门更换',
                '上水管漏水','下水管漏水','上下水管接口漏水','上下水管更换',
                '便池维修，更换','冲水阀维修更换',
                '水池更换、维修、固定',
                '地漏杜塞','管道堵塞',
                '水箱维修更换']
        content = random.sample(list, 1)
        if state == 1:
            t2 = random.randint(t1, end)  # 在开始和结束时间戳中随机取出一个
            date_touple1 = time.localtime(t2)  # 将时间戳生成时间元组
            finish_date = time.strftime("%Y-%m-%d %H:%M:%S", date_touple1)  # 将时间元组转成格式化字符串（1976-05-21）
            type1 = state
            cursor = connent.cursor()
            sql = "insert into repair(repair_id,apply_id,title,content,latitude,longitude,place,apply_date,finish_date,repair_type,state) values(%d,%d,'%s','%s',%f,%f,'%s','%s','%s',%d,%d)"
            cursor.execute(sql % (
            repair_id1, apply_id1, str(title[0]), str(content[0]), latitude1, longtitude1, str(place[0]), apply_date, finish_date,
            type1, state))
            connent.commit()  # 提交任务，数据才会写入数据库
        else:
            type1 = state
            cursor = connent.cursor()
            sql = "insert into repair(apply_id,title,content,latitude,longitude,place,apply_date,repair_type,state) values(%d,'%s','%s',%f,%f,'%s','%s',%d,%d)"
            cursor.execute(sql % (
            apply_id1,  str(title[0]), str(content[0]), latitude1, longtitude1, str(place[0]), apply_date, type1, state))
            connent.commit()  # 提交任务，数据才会写入数据库

    elif title[0] =='电':
        list2 = ['开关维修', '插座更换',
                 '灯管更换', '镇流器更换', '线路铺设',
                 '线路故障排除', '风扇维修更换',
                 '其他']
        content = random.sample(list2, 1)
        if state == 1:
            t2 = random.randint(t1, end)  # 在开始和结束时间戳中随机取出一个
            date_touple1 = time.localtime(t2)  # 将时间戳生成时间元组
            finish_date = time.strftime("%Y-%m-%d %H:%M:%S", date_touple1)  # 将时间元组转成格式化字符串（1976-05-21）
            type1 = state
            cursor = connent.cursor()
            sql = "insert into repair(repair_id,apply_id,title,content,latitude,longitude,place,apply_date,finish_date,repair_type,state) values(%d,%d,'%s','%s',%f,%f,'%s','%s','%s',%d,%d)"
            cursor.execute(sql % (
                repair_id1, apply_id1,  str(title[0]), str(content[0]), latitude1, longtitude1, str(place[0]), apply_date,
                finish_date,
                type1, state))
            connent.commit()  # 提交任务，数据才会写入数据库
        else:
            type1 = state
            cursor = connent.cursor()
            sql = "insert into repair(apply_id,title,content,latitude,longitude,place,apply_date,repair_type,state) values(%d,'%s','%s',%f,%f,'%s','%s',%d,%d)"
            cursor.execute(sql % (
                apply_id1,  str(title[0]), str(content[0]), latitude1, longtitude1, str(place[0]), apply_date, type1, state))
            connent.commit()  # 提交任务，数据才会写入数据库

    elif title[0] =='木':
        list2 = ['门锁维修和更换', '门窗加固',
                 '抽屉桌椅更换', '柜子拉手更换维修', '门窗固定',
                 '衣架安装', '玻璃破损维修',
                 '其他']
        content = random.sample(list2, 1)
        if state == 1:
            t2 = random.randint(t1, end)  # 在开始和结束时间戳中随机取出一个
            date_touple1 = time.localtime(t2)  # 将时间戳生成时间元组
            finish_date = time.strftime("%Y-%m-%d %H:%M:%S", date_touple1)  # 将时间元组转成格式化字符串（1976-05-21）
            type1 = state
            cursor = connent.cursor()
            sql = "insert into repair(repair_id,apply_id,title,content,latitude,longitude,place,apply_date,finish_date,repair_type,state) values(%d,%d,'%s','%s',%f,%f,'%s','%s','%s',%d,%d)"
            cursor.execute(sql % (
                repair_id1, apply_id1,  str(title[0]), str(content[0]), latitude1, longtitude1, str(place[0]), apply_date,
                finish_date,
                type1, state))
            connent.commit()  # 提交任务，数据才会写入数据库
        else:
            type1 = state
            cursor = connent.cursor()
            sql = "insert into repair(apply_id,title,content,latitude,longitude,place,apply_date,repair_type,state) values(%d,'%s','%s',%f,%f,'%s','%s',%d,%d)"
            cursor.execute(sql % (
                apply_id1,  str(title[0]), str(content[0]), latitude1, longtitude1, str(place[0]), apply_date, type1, state))
            connent.commit()  # 提交任务，数据才会写入数据库





def lost_and_found():
    apply_id = []
    apply_id.append(int(np.random.uniform(89, 168)))
    apply_id1 = int(apply_id[0])
    finish_id = []
    finish_id.append(int(np.random.uniform(169, 248)))
    finish_id1 = int(finish_id[0])

    lost = ['丢失','捡到']
    title = random.sample(lost,1)
    list = ['一卡通', '钱包', '书本',
            '钥匙', '手机',
            '其他']
    content = random.sample(list, 1)

    longtitude = []
    longtitude.append(np.random.uniform(114.366207, 114.376843))
    longtitude1 = float(longtitude[0])
    latitude = []
    latitude.append(np.random.uniform(30.538832, 30.549407))
    latitude1 = float(latitude[0])
    # 随机返回只有一个值的list

    list2 = ['武汉大学信息学部',
             '武汉大学文理学部',
             '武汉大学工学部',
             '武汉大学医学部']
    place = random.sample(list2, 1)

    a1 = (2018, 1, 1, 0, 0, 0, 0, 0, 0)  # 设置开始日期时间元组（1976-01-01 00：00：00）
    a2 = (2021, 12, 31, 23, 59, 59, 0, 0, 0)  # 设置结束日期时间元组（1990-12-31 23：59：59）

    start = time.mktime(a1)  # 生成开始时间戳
    end = time.mktime(a2)  # 生成结束时间戳
    t1 = random.randint(start, end)  # 在开始和结束时间戳中随机取出一个
    date_touple = time.localtime(t1)  # 将时间戳生成时间元组
    apply_date = time.strftime("%Y-%m-%d %H:%M:%S", date_touple)  # 将时间元组转成格式化字符串（1976-05-21）
    if title[0] == "丢失":
        state = 0
        type1 = state
        cursor = connent.cursor()
        sql = "insert into lost_and_found(apply_id,title,content,latitude,longitude,place,apply_date,state,type) values(%d,'%s','%s',%f,%f,'%s','%s',%d,%d)"
        cursor.execute(sql % (apply_id1,  str(title[0]), str(content[0]), latitude1, longtitude1, str(place[0]), apply_date,type1, state))
        connent.commit()  # 提交任务，数据才会写入数据库
    else:
        t2 = random.randint(t1, end)  # 在开始和结束时间戳中随机取出一个
        date_touple1 = time.localtime(t2)  # 将时间戳生成时间元组
        finish_date = time.strftime("%Y-%m-%d %H:%M:%S", date_touple1)  # 将时间元组转成格式化字符串（1976-05-21）
        state = 1
        type1 = state
        cursor = connent.cursor()
        sql = "insert into lost_and_found(apply_id,finish_id,title,content,latitude,longitude,place,apply_date,finish_date,state,type) values(%d,%d,'%s','%s',%f,%f,'%s','%s','%s',%d,%d)"
        cursor.execute(sql % (
            apply_id1, finish_id1, str(title[0]), str(content[0]), latitude1, longtitude1, str(place[0]), apply_date,
            finish_date, type1, state))
        connent.commit()  # 提交任务，数据才会写入数据库

def insert():

    userName = ''
    password = ''
    real_name = ''
    phone_number=''
    #8位用户名及6位密码
    userName = ''.join(random.sample("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",8))
    real_name = ''.join(random.sample("王石华云柏奚乐蓝双秋茹年爱阳佟郁夏冷颜空萧",3))
    password = ''.join(random.sample("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_.1234567890",6))

    list = ['139','138','137','136','135','134','159','158','157','150','151','152','188','187','182','183','184','178','130','131','132','156','155','186','185','176','133','153','189','180','181','177']
    str1 = '0123456789'
    phone_number = random.choice(list) + "".join(random.choice(str1) for i in range(8))

    type1 = 2

    list1 = ['信息学部', '文理学部', '工学部', '医学部']
    list2 = ['武汉大学信息学部学生宿舍7舍', '武汉大学信息学部学生宿舍8舍', '武汉大学信息学部学生宿舍9舍',
             '武汉大学文理学部学生宿舍10舍', '武汉大学文理学部学生宿舍11舍', '武汉大学文理学部学生宿舍12舍',
             '武汉大学工学部学生宿舍15舍', '武汉大学工学部学生宿舍7舍', '武汉大学工学部学生宿舍8舍',
             '武汉大学医学部学生宿舍1舍', '武汉大学医学部学生宿舍2舍', '武汉大学医学部学生宿舍3舍']
    affiliation = random.sample(list1, 1)
    address = random.sample(list2, 1)

    cursor = connent.cursor()
    sql="insert into user(user_name,password,real_name,phone_number,type,address,affiliation) values('%s','%s','%s','%s',%d,'%s','%s')"
    cursor.execute(sql%(userName,password,real_name,phone_number,type1,str(address[0]),str(affiliation[0])))
    connent.commit() #提交任务，数据才会写入数据库

def announcement():
    list = ['关于武汉大学用水用电通知','关于节假日安排通知','关于交通通知','珞珈讲坛通知','关于工作总结通知']
    title = random.sample(list,1)
    if title[0] == "关于武汉大学用水用电通知":
        list2 = ['春季安全用电通知','春季安全用水通知','夏季安全用电通知','夏季安全用水通知',
                   '秋季安全用电通知','秋季安全用水通知','冬季季安全用电通知','冬季安全用水通知']
        content = random.sample(list2,1)
    elif title[0] == "关于节假日安排通知":
        list2 = ['关于寒假放假安排', '关于暑假放假安排', '关于国庆放假安排', '关于中秋放假安排']
        content = random.sample(list2, 1)
    elif title[0] == "关于交通通知":
        list2 = ['关于交通管制安排', '关于道路维修建设安排', '关于大循环安排']
        content = random.sample(list2, 1)
    elif title[0] == "珞珈讲坛通知":
        list2 = ['珞珈讲坛通知']
        content = random.sample(list2, 1)
    elif title[0] == "关于工作总结通知":
        list2 = ['关于第一学期工作总结','关于第二学期工作总结','关于第三学期工作总结']
        content = random.sample(list2, 1)

    list3 = ['待发布','已发布']
    comment = random.sample(list3,1)

    apply_id = []
    apply_id.append(int(np.random.uniform(89, 168)))
    apply_id1 = int(apply_id[0])

    a1 = (2018, 1, 1, 0, 0, 0, 0, 0, 0)  # 设置开始日期时间元组（1976-01-01 00：00：00）
    a2 = (2021, 12, 31, 23, 59, 59, 0, 0, 0)  # 设置结束日期时间元组（1990-12-31 23：59：59）

    start = time.mktime(a1)  # 生成开始时间戳
    end = time.mktime(a2)  # 生成结束时间戳
    t1 = random.randint(start, end)  # 在开始和结束时间戳中随机取出一个
    date_touple = time.localtime(t1)  # 将时间戳生成时间元组
    apply_date = time.strftime("%Y-%m-%d %H:%M:%S", date_touple)  # 将时间元组转成格式化字符串（1976-05-21）

    if comment[0] == "已发布":
        check_id = []
        check_id.append(int(np.random.uniform(169, 248)))
        check_id1 = int(check_id[0])

        t2 = random.randint(t1, end)  # 在开始和结束时间戳中随机取出一个
        date_touple1 = time.localtime(t2)  # 将时间戳生成时间元组
        publish_date = time.strftime("%Y-%m-%d %H:%M:%S", date_touple1)  # 将时间元组转成格式化字符串（1976-05-21）
        state = 1
        cursor = connent.cursor()
        sql = "insert into announcement(title,content,comment,apply_id,check_id,apply_date,publish_date,state) values('%s','%s','%s',%d,%d,'%s','%s',%d)"
        cursor.execute(sql % (
            str(title[0]), str(content[0]), str(comment[0]), apply_id1,check_id1,apply_date,publish_date,state))
        connent.commit()  # 提交任务，数据才会写入数据库
    else:
        state = 0
        cursor = connent.cursor()
        sql = "insert into announcement(title,content,comment,apply_id,apply_date,state) values('%s','%s','%s',%d,'%s',%d)"
        cursor.execute(sql % (
            str(title[0]), str(content[0]), str(comment[0]), apply_id1, apply_date, state))
        connent.commit()  # 提交任务，数据才会写入数据库

if __name__ == '__main__':
    for i in range(80):
        # 四个函数对应四个表
        insert()
        repair()
        announcement()
        lost_and_found()