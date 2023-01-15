package com.ztcly.shop.DAO;

import com.ztcly.shop.model.Good;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodMapper {
    int deleteByPrimaryKey(String id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(String id);
    List<Good> selectByShopid(String shopid);
    List<Good> selectAllGoods();
    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}