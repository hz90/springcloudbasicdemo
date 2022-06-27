package com.zhz.springcloud.basic.modules.user.controller;

import com.zhz.api.domain.User;
import com.zhz.api.model.LoginUser;
import com.zhz.springcloud.basic.modules.user.domain.Result;
import com.zhz.springcloud.basic.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author : hzhao
 * @date : 2022/06/27 13:45
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/info/{username}")
    public Result<LoginUser> info(@PathVariable("username") String username)
    {
        User user = userService.selectUserByUserName(username);
        if (user==null)
        {
            return Result.fail("用户名或密码错误");
        }
//        // 角色集合
//        Set<String> roles = permissionService.getRolePermission(sysUser.getUserId());
//        // 权限集合
//        Set<String> permissions = permissionService.getMenuPermission(sysUser.getUserId());
        LoginUser loginUserVo = new LoginUser();
        loginUserVo.setLoginUser(user);
//        sysUserVo.setRoles(roles);
//        sysUserVo.setPermissions(permissions);
        return Result.ok(loginUserVo);
    }
    /**
     * 注册用户信息
     */
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody LoginUser loginUser)
    {

        return Result.ok(userService.registerUser(loginUser));
    }
}
