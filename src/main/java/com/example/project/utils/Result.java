package com.example.project.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Result {
    private Integer code;
    private String msg;
    private Object data;

    //    无数据
    public static Result success() {
        return new Result(200, "操作成功", null);
    }

    //    有数据
    public static Result success(Object data) {
        return new Result(200, "操作成功", data);
    }

    //    自定义消息
    public static Result success(String msg) {
        return new Result(200, msg, null);
    }

    //    操作失败
    public static Result error() {
        return new Result(500, "操作失败", null);
    }
}
