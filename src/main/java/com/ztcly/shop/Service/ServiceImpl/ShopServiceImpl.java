package com.ztcly.shop.Service.ServiceImpl;
import com.ztcly.shop.DAO.GoodMapper;
import com.ztcly.shop.model.Good;
import com.ztcly.shop.model.Shop;
import com.ztcly.shop.Service.ShopService;
import com.ztcly.shop.DAO.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public String getShopByOwner(String owner) {
        return shopMapper.selectByOwner(owner);
    }

    @Override
    public int createShop(String shopname, String ownerid, String shopimage) {
        Shop shop = new Shop();
        shop.setId(UUID.randomUUID().toString());
        shop.setShopname(shopname);
        shop.setOwnerid(ownerid);
        shop.setShopimage(shopimage);
        shopMapper.insert(shop);
        return 0;
    }

    @Override
    public Shop getShop(String shopid) {
        Shop shop =shopMapper.selectByPrimaryKey("shopid");
        return shop;
    }

    @Override
    public List<Good> getGoodsByShop(String shopid) {
        List<Good> result = goodMapper.selectByShopid(shopid);
        System.out.println("[ShopServices]getGoodsByshop调用");
        return result;
    }

    @Override
    public int createGood(String goodname, String shopid, String goodimage) {
        Good good = new Good();
        good.setId(UUID.randomUUID().toString());
        good.setGoodname(goodname);
        good.setShopid(shopid);
        good.setGoodimage(goodimage);
        goodMapper.insert(good);
        return 0;
    }

    @Override
    public List<Good> getAllGoods() {
        List<Good> raw = goodMapper.selectAllGoods();
        List<Good> result=new ArrayList<Good>();
        System.out.println("[ShopServices]result"+raw);
        for(int i=0;i<raw.size();i++){
            Good g = raw.get(i);
            //raw.remove(g);
            String shopid = g.getShopid();
            Shop s = shopMapper.selectByPrimaryKey(shopid);
            g.setShopid(s.getShopname());
            System.out.println("[ShopServices]g"+g);
            if (g != null) {
                result.add(g);
            }

            //i--;

        }
        System.out.println("[ShopServices]result"+result);
        return result;
    }

    @Override
    public int deleteGood(String id) {
        return goodMapper.deleteByPrimaryKey(id);
    }
}
