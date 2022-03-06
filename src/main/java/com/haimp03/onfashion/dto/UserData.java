package com.haimp03.onfashion.dto;

import javax.validation.constraints.NotEmpty;

public class UserData {
    public Long user_id;

    @NotEmpty(message = "Full Name Cannot Be Empty")
    public String fullname;
    
    @NotEmpty(message = "Username Cannot Be Empty")
    public String username;

    @NotEmpty(message = "Password Cannot Be Empty")
    public String password;

    public UserData() {
    }

    public UserData(Long user_id, String fullname, String username, 
            String password) {
        this.user_id = user_id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    
}
