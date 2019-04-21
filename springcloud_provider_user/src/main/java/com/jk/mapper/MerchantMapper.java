package com.jk.mapper;

import com.jk.model.MerchantBean;
import com.jk.model.NavBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantMapper {

    List<NavBean> findTreeList(Integer pid);


    int findMerchantCount();
    List<MerchantBean> findMerchantPage(@Param("start") int start, @Param("rows") Integer rows);

    //回显
    MerchantBean findMarchantById(Integer id);
   //删除
    void delOne(Integer id);

    /*//修改上下架
    void updateStatus(@Param("id") Integer id,@Param("updown") Integer updown);*/

   //新增
    void saveMerchant(MerchantBean merchantBean);
    //修改
    void updateMerchant(MerchantBean merchantBean);

    void deleteTemplate(@Param("ids")Integer[] ids);
}
