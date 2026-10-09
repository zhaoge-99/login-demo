package com.duanyifan.logindemo.controller;

import com.duanyifan.logindemo.common.Result;
import com.duanyifan.logindemo.entity.User;
import com.duanyifan.logindemo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户接口层
 * 接收前端请求，调用Service，返回结果
 */
@RestController // 标记为Controller,返回json数据
@RequestMapping("/user") //接口前端，所有接口都以/user开头
public class UserController {
    @Autowired //自动注入Service
    private UserService userService;

    /**
     * 注册接口
     * 请求方式:post
     * 请求地址:http://localhost:8081/user/register
     * 参数:username,password(表单格式提交)
     */
    @PostMapping("/register")
    public Result register(User user) {
        String msg = userService.register(user);
        if (msg.equals("注册成功")) {
            return Result.success(msg);
        } else {
            return Result.error(msg);
        }
    }

    /**
     * 登录接口
     * 请求方式:post
     * 请求地址:http://localhost:8081/user/login
     * 参数:username,password(表单格式提交）
     */
    @PostMapping("/login")
    public Result login(String username, String password) {
        String msg = userService.login(username, password);
        if (msg.equals("登录成功")) {
            return Result.success(msg);

        } else {
            return Result.error(msg);
        }
    }

}


