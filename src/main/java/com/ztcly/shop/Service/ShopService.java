package com.ztcly.shop.Service;

import com.ztcly.shop.model.Good;
import com.ztcly.shop.model.Shop;

import java.util.List;

public interface ShopService {
    public String getShopByOwner(String owner);
    public int createShop(String shopname,String ownerid,String shopimage);
    public Shop getShop(String shopid);
    public List<Good> getGoodsByShop(String shopid);
    public int createGood(String goodname,String shopid,String goodimage);
    public List<Good> getAllGoods();
    public int deleteGood(String id);
}
