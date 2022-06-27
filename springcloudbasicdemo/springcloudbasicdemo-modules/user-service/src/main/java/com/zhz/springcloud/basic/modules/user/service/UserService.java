package com.zhz.springcloud.basic.modules.user.service;

import com.zhz.api.domain.User;
import com.zhz.api.model.LoginUser;
import org.springframework.stereotype.Service;

/**
 * @author : hzhao
 * @date : 2022/06/27 13:54
 */
@Service
public class UserService {

    public User selectUserByUserName(String userName){
        User user=new User();
        user.setId(1);
        user.setUsername("zhz");
        user.setNickName("海");
        user.setPassword("xxxxxxxx");
        user.setTelephone("123334");
        user.setEmail("xxx@gmailc.om");
        user.setLocation("西安市雁塔区");
        return user;
    }
    public boolean registerUser(LoginUser user){
     return true;
    }
}
