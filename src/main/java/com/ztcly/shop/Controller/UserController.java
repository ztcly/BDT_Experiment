package com.ztcly.shop.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ztcly.shop.model.Error;
import com.ztcly.shop.Service.UserService;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/logincon")
    public String login(String username,String password,HttpSession session, Model model){
        System.out.println("login:"+username+"  "+password);
        int f = userService.login(username,password);
        Error error = new Error();
        if(f==0){
            String userid = userService.getID(username);
            System.out.println("login suc");
            session.setAttribute("username",username);
            session.setAttribute("userid",userid);
            return "redirect:/netdisk";
        }else if(f==1){
            error.setErrortitle("用户不存在");
            error.setErrorinfo("请检查用户名");
            error.setNextpage("loginpage");
            error.setNextpagetitle("返回登入");
            model.addAttribute("error",error);
            return "error";
        }else{
            error.setErrortitle("密码错误");
            error.setErrorinfo("用户名/密码错误");
            error.setNextpage("loginpage");
            error.setNextpagetitle("返回登入");
            model.addAttribute("error",error);
            return "error";
        }

    }
    @RequestMapping("/profilepage")
    public String toProfile(HttpSession session,Model model){
        String userid = (String)session.getAttribute("userid");
        if(userid==null){
            Error error = new Error();
            error.setErrortitle("无法查看资料（未登入）");
            error.setErrorinfo("请先进行登入");
            error.setNextpage("loginpage");
            error.setNextpagetitle("登入");
            model.addAttribute("error",error);
            return "error";
        }
        model.addAttribute("user",userService.getUser(userid));
        return "profile";
    }
    @RequestMapping("/registerpage")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/loginpage")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/registercon")
    public String register(String username,String password,HttpSession session, Model model) {
        System.out.println("reg:"+username + "  " + password);
        int f = userService.register(username, password);
        if (f == 0) {
            return "redirect:/loginpage";
        } else if (f == 1) {
            Error error = new Error();
            error.setErrortitle("无法注册");
            error.setErrorinfo("用户名已经存在");
            error.setNextpage("registerpage");
            error.setNextpagetitle("返回注册");
            model.addAttribute("error",error);
            return "error";
        }else{
            return "error";
        }
    }

}
