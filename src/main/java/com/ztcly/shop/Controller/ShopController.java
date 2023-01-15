package com.ztcly.shop.Controller;
import javax.servlet.http.HttpSession;
import com.ztcly.shop.Service.ShopService;
import com.ztcly.shop.model.Error;
import com.ztcly.shop.model.Good;
import com.ztcly.shop.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
public class ShopController {
    @Autowired
    HttpSession session;
    @Autowired
    private ShopService shopService;

    @RequestMapping("/shop")
    public String shop(Model model)
    {
        String userid = (String)session.getAttribute("userid");
        if(userid==null){
            Error error = new Error();
            error.setErrortitle("无法管理商店（未登入）");
            error.setErrorinfo("请先进行登入");
            error.setNextpage("loginpage");
            error.setNextpagetitle("登入");
            model.addAttribute("error",error);
            return "error";
        }else {
            String shopid = shopService.getShopByOwner(userid);
            if (shopid == null) {
                return "createshop";
            } else {
                return "redirect:/manageshoppage";
            }
        }
    }
    @RequestMapping("/goodindexpage")
    public String Goodindex(Model model){
        List<Good> allgoodslist = shopService.getAllGoods();
        System.out.println("[ShopController]allgoodlist_isempty:"+allgoodslist.isEmpty());
        model.addAttribute("glist",allgoodslist);
        return "goodindex";
    }

    @RequestMapping("/deletegood")
    public String deletegood(String goodid){
        shopService.deleteGood(goodid);
        System.out.println("[ShopController]deletegood触发:"+goodid);
        return "redirect:/manageshoppage";
    }

    @RequestMapping("/manageshoppage")
    public String manageshop(Model model){
        String userid = (String)session.getAttribute("userid");
        if(userid==null){
            Error error = new Error();
            error.setErrortitle("无法管理商店（未登入）");
            error.setErrorinfo("请先进行登入");
            error.setNextpage("loginpage");
            error.setNextpagetitle("登入");
            model.addAttribute("error",error);
            return "error";
        }
        String shopid = shopService.getShopByOwner(userid);
        session.setAttribute("shopid",shopid);
        Shop shop = shopService.getShop("shopid");
        model.addAttribute("shop",shop);
        List<Good> goodList = shopService.getGoodsByShop(shopid);
        System.out.println("[ShopController]goodListIsEmpty:"+ goodList.isEmpty());
        session.setAttribute("goodlistisempty",goodList.isEmpty());
        model.addAttribute("goodlist",goodList);
        return "manageshop";
    }

    @RequestMapping("/createshop")
    public String createshop(String shopname, MultipartFile file, Model model){
        String userid = (String)session.getAttribute("userid");
        if(userid==null){
            Error error = new Error();
            error.setErrortitle("无法创建商店（未登入）");
            error.setErrorinfo("请先进行登入");
            error.setNextpage("loginpage");
            error.setNextpagetitle("登入");
            model.addAttribute("error",error);
            return "error";
        }else {
            String shopimage;
            if (file.isEmpty()) {
                shopimage = "default.png";
            } else {
                shopimage = file.getOriginalFilename();
                String filePath = "D:/jav/shop/src/main/resources/image/";
                File dest = new File(filePath + shopimage);
                if (!dest.exists()) {
                    dest.mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            shopService.createShop(shopname,userid,shopimage);
            return "redirect:/manageshoppage";
        }


    }
    @RequestMapping("/creategood")
    public String creategood(String goodname, MultipartFile file, Model model){
        String userid = (String)session.getAttribute("userid");

        if(userid==null){
            Error error = new Error();
            error.setErrortitle("无法创建商品（未登入）");
            error.setErrorinfo("请先进行登入");
            error.setNextpage("loginpage");
            error.setNextpagetitle("登入");
            model.addAttribute("error",error);
            return "error";
        }else {
            String shopid = shopService.getShopByOwner(userid);
            String goodimage;
            if (file.isEmpty()) {
                goodimage = "default.png";
            } else {
                goodimage = file.getOriginalFilename();
                String filePath = "D:/jav/shop/src/main/resources/image/";
                File dest = new File(filePath + goodimage);
                if (!dest.exists()) {
                    dest.mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //shopService.createShop(shopname,userid,shopimage);
            shopService.createGood(goodname,shopid,goodimage);
            return "redirect:manageshoppage";
        }


    }
}
