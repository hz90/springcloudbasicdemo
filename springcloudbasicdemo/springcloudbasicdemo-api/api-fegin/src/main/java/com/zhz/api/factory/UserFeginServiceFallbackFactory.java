package com.zhz.api.factory;

import com.zhz.api.UserFeginService;
import com.zhz.api.model.LoginUser;
import com.zhz.api.model.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 用户服务降级处理
 * 
 * @author ruoyi
 */
@Component
public class UserFeginServiceFallbackFactory implements FallbackFactory<UserFeginService>
{
    private static final Logger log = LoggerFactory.getLogger(UserFeginServiceFallbackFactory.class);

    @Override
    public UserFeginService create(Throwable throwable)
    {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new UserFeginService()
        {
            @Override
            public Result<LoginUser> getUserInfo(String username, String source)
            {
                return Result.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public Result<Boolean> registerUserInfo(LoginUser loginUser, String source)
            {
                return Result.fail("注册用户失败:" + throwable.getMessage());
            }
        };
    }
}
