package com.jk.mapper;

import com.jk.model.t_goods_one;
import com.jk.model.NavBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MerchantMapper {

    List<NavBean> findTreeList(Integer pid);


    int findMerchantCount();
    List<t_goods_one> findMerchantPage(@Param("start") int start, @Param("rows") Integer rows);

    List<t_goods_one> findMerchantPageAll();

    //回显
    t_goods_one findMarchantById(Integer id);
   //删除
    void delOne(Integer id);

    /*//修改上下架
    void updateStatus(@Param("id") Integer id,@Param("updown") Integer updown);*/

   //新增
    void saveMerchant(t_goods_one tgoodsone);
    //修改
    void updateMerchant(t_goods_one tgoodsone);

    //增加金币
    void addgold();

    //折线图
    List<Map<String, Object>> findshopline();

    //柱状图
    List<Map<String, Object>> findsystem();

    void deleteTemplate(@Param("ids")Integer[] ids);


}
