package com.bawie.todaynews.bean;

/**
 * Created by Administrator on 2017/5/11.
 * time:
 * author:付智焱
 */

public class LoginBean {
    private String username;
    private String password;
    private String postkey;
    private int Ret_code;

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

    public String getPostkey() {
        return postkey;
    }

    public void setPostkey(String postkey) {
        this.postkey = postkey;
    }

    public int getRet_code() {
        return Ret_code;
    }

    public void setRet_code(int ret_code) {
        Ret_code = ret_code;
    }
}
