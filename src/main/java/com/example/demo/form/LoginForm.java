package com.example.demo.form;

import com.example.demo.entitys.user.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

    @NotNull
    @Size(min=6, max=32)
    private String username;

    @NotNull
    @Size(min=8, max=16)
    private String password;

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

    public User buildUserByUsername() {
        User user = new User();
        user.setUsername(this.getUsername());
        return user;
    }

}
