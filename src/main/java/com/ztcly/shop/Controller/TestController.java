package com.ztcly.shop.Controller;
import org.springframework.web.bind.annotation.*;
@RestController
public class TestController {
    @RequestMapping("/test")
    public String Test(){
        return "test";
    }
}
