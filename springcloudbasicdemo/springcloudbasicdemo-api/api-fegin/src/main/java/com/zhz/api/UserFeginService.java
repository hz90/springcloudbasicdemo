package com.zhz.api;

import com.zhz.api.factory.UserFeginServiceFallbackFactory;
import com.zhz.api.model.LoginUser;
import com.zhz.api.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hzhao
 * @date : 2022/06/27 14:16
 */
@FeignClient(contextId = "userFeginService", value = "user-service", fallbackFactory = UserFeginServiceFallbackFactory.class)
public interface UserFeginService {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    @GetMapping("/user/info/{username}")
    public Result<LoginUser> getUserInfo(@PathVariable("username") String username, @RequestHeader("from-source") String source);
    /**
     * 注册用户信息
     *
     * @return 结果
     */
    @PostMapping("/user/register")
    public Result<Boolean> registerUserInfo(@RequestBody LoginUser loginUser, @RequestHeader("from-source") String source);

}
