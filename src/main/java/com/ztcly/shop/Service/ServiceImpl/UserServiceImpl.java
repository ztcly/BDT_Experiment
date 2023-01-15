package com.ztcly.shop.Service.ServiceImpl;
import com.ztcly.shop.DAO.UsersMapper;
import com.ztcly.shop.Service.UserService;
import com.ztcly.shop.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import com.ztcly.shop.Util.teaUtil;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usermapper;

    @Override
    public int register(String username,String password){
        if(usermapper.selectByName(username)==null){
            Users newuser = new Users();
            newuser.setId(UUID.randomUUID().toString());
            newuser.setName(username);
            newuser.setPassword(teaUtil.encryptByTea(password));
            newuser.setAddress("等待填写");
            newuser.setPermission(0);
            newuser.setImage("defaultUserImg");
            usermapper.insert(newuser);
            return 0;
        }
        else{
            return 1;//账号已经存在
        }
    }

    @Override
    public String getID(String username){
      String id = usermapper.selectByName(username);
      return id;
    }

    @Override
    public Users getUser(String userid) {
        return usermapper.selectByPrimaryKey(userid);
    }

    @Override
    public int login(String username, String password) {
        String userid =usermapper.selectByName(username);
        System.out.println("[userService]接收数据:"+username+"  "+password);
        if(userid==null){
            return 1;//账号不存在
        }else{
            Users user = usermapper.selectByPrimaryKey(userid);
            System.out.println("[userService]解密:"+teaUtil.decryptByTea(user.getPassword()));
            if(password.equals(teaUtil.decryptByTea(user.getPassword()))){
                return 0;
            }else{
                return 2;
            }
        }

    }


}
