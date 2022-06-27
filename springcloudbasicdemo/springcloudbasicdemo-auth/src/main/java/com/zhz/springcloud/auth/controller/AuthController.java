package com.zhz.springcloud.auth.controller;

import com.zhz.api.model.LoginUser;
import com.zhz.api.model.Result;
import com.zhz.springcloud.auth.form.LoginBody;
import com.zhz.springcloud.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hzhao
 * @date : 2022/06/27 14:58
 */
@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("login")
    public Result<?> login(@RequestBody LoginBody form)
    {
        // 用户登录
        LoginUser userInfo = authService.login(form.getUsername(), form.getPassword());
        // 获取登录token
        return Result.ok(userInfo);
    }
    @PostMapping("register")
    public Result<?> register(@RequestBody LoginBody registerBody)
    {
        // 用户注册
        authService.register(registerBody);
        return Result.ok();
    }
}
