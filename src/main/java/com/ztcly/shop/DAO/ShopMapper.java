package com.ztcly.shop.DAO;

import com.ztcly.shop.model.Shop;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopMapper {
    int deleteByPrimaryKey(String id);

    int insert(Shop record);

    int insertSelective(Shop record);
    String selectByOwner(String userid);
    Shop selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}