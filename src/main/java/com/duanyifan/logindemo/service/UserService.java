package com.duanyifan.logindemo.service;

import com.duanyifan.logindemo.entity.User;
import com.duanyifan.logindemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户业务层
 * 处理注册、登录的业务逻辑
 */
@Service //标记为Service组件，交给Spring管理
public class UserService {
    //BCrypt密码加密器，全局一个就行
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired //自动注入Mapper
    private UserMapper userMapper;

    /**
     * 注册业务逻辑
     * 1.检查用户名是否已存在
     * 2.对密码进行加密
     * 3.插入数据库
     */
    public String register(User user) {
        //1.查询用户名是否存在
        User existUser = userMapper.findByUsername(user.getUsername());
        if (existUser != null) {
            return "用户名已存在，请换一个";
        }
        //2.密码加密(明文-->密文,不可逆)
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        //3.插入数据库
        int row = userMapper.insertUser(user);
        if (row > 0) {
            return "注册成功";
        } else {
            return "注册失败，请重试";
        }
    }

    /**
     * 登录业务逻辑
     * 1.根据用户名查询用户
     * 2.比对密码
     */
    public String login(String username, String password) {
        //1.查询用户
        User user = userMapper.findByUsername(username);
        if (user == null) {
            return "用户名不存在";

        }
        //2.比对密码:BCrypt是单向加密，只能用matches方法比对
        boolean matches = passwordEncoder.matches(password, user.getPassword());
        if (matches) {
            return "登录成功";
        } else {
            return "密码错误";
        }


    }


}
