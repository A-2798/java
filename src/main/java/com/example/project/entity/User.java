package com.example.project.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class User {
    private Integer id;
    private String name;
    private String email;
    private String address;

    // 时间格式常量提取
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @JsonFormat(pattern = DATE_TIME_FORMAT, timezone = "GMT+8")
    @DateTimeFormat(pattern = DATE_TIME_FORMAT)
    @JsonIgnore  // 忽略前端传递的createTime
    @TableField(fill = FieldFill.INSERT)  // 显式指定数据库字段名
    private LocalDateTime createTime;

    @JsonFormat(pattern = DATE_TIME_FORMAT, timezone = "GMT+8")
    @DateTimeFormat(pattern = DATE_TIME_FORMAT)
    @JsonIgnore  // 忽略前端传递的createTime
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}