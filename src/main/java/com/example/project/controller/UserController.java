package com.example.project.controller;
import com.example.project.entity.User;
import com.example.project.service.IUserService;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //    用户列表
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    //    添加用户
    @PostMapping
    public String save(@RequestBody User user){
        System.out.println("用户数据" + user);
        userService.save(user);
        return "添加用户";
    }

    //    修改用户
    @PutMapping
    public String update(@RequestBody User user){
        System.out.println("用户数据" + user);
        userService.updateById(user);
        return "修改用户";
    }

    //    删除用户
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("删除用户" + id);
        userService.removeById(id);
        return "删除用户";
    }
}
