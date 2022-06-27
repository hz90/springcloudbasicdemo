package com.zhz.springcloud.auth.service;

import com.zhz.api.UserFeginService;
import com.zhz.api.model.LoginUser;
import com.zhz.api.model.Result;
import com.zhz.springcloud.auth.form.LoginBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hzhao
 * @date : 2022/06/27 14:59
 */
@Service
public class AuthService {
    @Autowired
    UserFeginService userFeginService;
    public LoginUser login(String username, String password)
    {
        Result<LoginUser> userResult =userFeginService.getUserInfo(username,"inner");
        return userResult.getData();
    }
    public void register(LoginBody LoginBody)
    {
        LoginUser loginUser=new LoginUser();
        userFeginService.registerUserInfo(loginUser,"inner");
    }
}
