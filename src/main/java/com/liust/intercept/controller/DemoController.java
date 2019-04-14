package com.liust.intercept.controller;

import com.liust.intercept.annotations.AuthToken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: intercept
 * @description:
 * @author: liust
 * @create: 2019-04-14 18:22
 **/
@RestController
public class DemoController {
    @GetMapping("hello")
    public String hello(Integer id, String name, Integer age) {
        System.out.println("hello方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return "hi~ 我不需要用户权限";
    }
    @GetMapping("user")
    @AuthToken
    public String user(Integer id, String name, Integer age) {
        System.out.println("user方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return "hi~ 我需要登陆后才可以访问";
    }

    @GetMapping("admin")
    @AuthToken(roleName = { "admin", "Administrator" })
    public String admin(Integer id, String name, Integer age) {
        System.out.println("admin方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return "hi~ 我需要管理员身份才可以访问";
    }

}
