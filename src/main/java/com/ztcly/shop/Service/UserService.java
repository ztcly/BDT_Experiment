package com.ztcly.shop.Service;
import com.ztcly.shop.model.Users;


public interface UserService {
    public int register(String username,String password);
    public int login(String username,String password);
    public String getID(String username);
    public Users getUser(String userid);



}
