package com.example.project.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data; //使用这个插件可以不用谢getter和setter

@Data
@TableName("sys_user") //识别到数据库对应的表名字
public class User {
    private Integer id;
    private String name;
    private String email;
    private String address;
}
