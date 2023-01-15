package com.ztcly.shop.Controller;


import com.ztcly.shop.model.Error;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NotFoundException implements ErrorController {

    //@Override
    public String getErrorPath() {
        return "/errorcon";
    }

    @RequestMapping(value = {"/errorcon"})
    @ResponseBody
    public Object error(Model model) {
        System.out.println("[NotFoundException]");
        Error error = new Error();
        error.setErrortitle("错误：404");
        error.setErrorinfo("404 Not Found");
        error.setNextpage("goodindexpage");
        error.setNextpagetitle("返回主页");
        model.addAttribute("error",error);
        return "error";
    }
}
