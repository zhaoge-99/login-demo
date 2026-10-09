package com.duanyifan.logindemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果类
 * 所有接口都返回这个格式，前端方便处理
 */
@Data //lombok注解:自动生成get、set、toString方法
@NoArgsConstructor //自动生成无参构造方法
@AllArgsConstructor //自动生成全参构造方法
public class Result {
    private Integer code; //状态码:200成功，500失败
    private String msg; //提示信息
    private Object data; //返回的数据

    //成功静态方法(带数据)
    public static Result success(Object data) {
        return new Result(200, "操作成功", data);
    }

    //成功静态方法(不带数据)
    public static Result success() {
        return new Result(200, "操作成功", null);
    }

    //失败静态方法
    public static Result error(String msg) {
        return new Result(500, msg, null);
    }

}
