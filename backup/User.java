package com.grouppdzs.shop.model;

public class User {
    private String userID;
    private String userName;
    private String password;
    private String address;
    private int permission;
    private String userImg;

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserID(){
        return userID;
    }
    public void setUserID(String id){
        this.userID = id;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String name){
        this.userName = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getPermission(){
        return permission;
    }
    public void setPermission(int permission){
        this.permission = permission;
    }
}
