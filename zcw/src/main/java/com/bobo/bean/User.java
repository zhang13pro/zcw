package com.bobo.bean;

/**
 * @Author: bobobo
 * @Date: 2019/8/8 9:15
 * @Version：1.0
 */
public class User {
    private int id;
    private String loginacct;
    private String userpswd;
    private String username;
    private String email;
    private String createtime;
    private String userType;

    public User(){}

    public User(String loginacct,String userpswd,String username,String email){
        this.loginacct = loginacct;
        this.email = email;
        this.username = username;
        this.userpswd = userpswd;
    }

    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLoginacct() {
        return loginacct;
    }
    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct;
    }
    public String getUserpswd() {
        return userpswd;
    }
    public void setUserpswd(String userpswd) {
        this.userpswd = userpswd;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCreatetime() {
        return createtime;
    }
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginacct='" + loginacct + '\'' +
                ", userpswd='" + userpswd + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createtime='" + createtime + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}