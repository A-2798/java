package com.example.project.exception;


import com.example.project.utils.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理 如数据库中已经有这条数据 但是又添加同一条数据
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DuplicateKeyException.class)
    public Result duplicateKeyException(){
        return Result.error("数据重复异常");
    }

    @ExceptionHandler(value = Exception.class)
    public Result exception(){
        return Result.error("系统繁忙，请稍后再试");
    }
}