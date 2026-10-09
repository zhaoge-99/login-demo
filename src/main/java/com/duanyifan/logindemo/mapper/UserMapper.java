package com.duanyifan.logindemo.mapper;

import com.duanyifan.logindemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户Mapper接口
 * 负责和数据库交互,SQL直接写在注解里
 */
@Mapper //告诉MyBatis这是一个Mapper接口,自动生成实现类
public interface UserMapper {
    /**
     * 根据用户名查询用户
     * 登录、注册、查重都用这个
     */
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    /**
     * 新增用户(注册)
     * 注意:密码是加密后存进去的
     */
    @Insert("insert into user (username,password) values (#{username},#{password})")
    int insertUser(User user);
}
