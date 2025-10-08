package com.example.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.project.entity.User;
import com.example.project.service.IUserService;
import com.example.project.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //    用户列表
    @GetMapping("/list")
    public Result list() {
        return Result.success(userService.list());
    }

    //    添加用户
    @PostMapping
    public Result save(@RequestBody User user) {
        System.out.println("用户数据" + user);
        userService.save(user);
        return  Result.success("添加成功");
    }

    //    修改用户
    @PutMapping
    public Result update(@RequestBody User user) {
        System.out.println("用户数据" + user);
        userService.updateById(user);
        return  Result.success("修改成功");
    }

    //    删除用户
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        System.out.println("删除用户" + id);
        userService.removeById(id);
        return  Result.success("删除成功");
    }

    //    分页查询
    @GetMapping("/page")
    public Result page(@RequestParam Integer page, @RequestParam Integer size) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Page<User> pageResult = userService.page (new Page<>(page, size), queryWrapper);
        return Result.success(pageResult);
    }
}
