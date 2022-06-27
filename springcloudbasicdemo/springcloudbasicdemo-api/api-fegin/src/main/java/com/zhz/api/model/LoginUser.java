package com.zhz.api.model;

import com.zhz.api.domain.User;

import java.io.Serializable;

/**
 * description:
 *
 * @author hzhao
 * @version 1.0
 * @date 2022/06/27 13:58
 */
public class LoginUser implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private String telephone;
    private String email;
    private String location;
    private User LoginUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getLoginUser() {
        return LoginUser;
    }

    public void setLoginUser(User loginUser) {
        LoginUser = loginUser;
    }
}
