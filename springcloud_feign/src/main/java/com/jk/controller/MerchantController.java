package com.jk.controller;

import com.jk.model.t_goods_one;
import com.jk.model.NavBean;
import com.jk.service.MerchantServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("merchant")
public class MerchantController {

    @Autowired
    private MerchantServiceFeign merchantService;

    @Autowired
    private RedisTemplate redisTemplate;

    //递归树
    @GetMapping("findTreeList")
    @ResponseBody
    public List<NavBean> findTreeList(){
        return merchantService.findTreeList();
    }
    //查询商品表
    @GetMapping("findMerchantPage")
    @ResponseBody
    public HashMap<String, Object> findMerchantPage(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows){
        return merchantService.findMerchantPage(page,rows);
    }
   //回显
    @GetMapping("findMarchantById/{id}")
    @ResponseBody
    public t_goods_one findMarchantById(@PathVariable("id") Integer id){
        t_goods_one mer = merchantService.findMarchantById(id);
        return mer;
    }
    //删除
    @DeleteMapping("delOne/{id}")
    @ResponseBody
    public void deleteMarketOrder(@PathVariable("id") Integer id){
        deleteRedis();
        merchantService.delOne(id);
    }


    //上下架
    @GetMapping("updateStatus/{id}")
    @ResponseBody
    public void updateStatus(@PathVariable("id") Integer id){
        deleteRedis();
        System.out.println("adsa-------------------------"+id);
        merchantService.updateStatus(id);
    }

    @PostMapping("saveMerchant")
    @ResponseBody
    public void saveMerchant(@RequestBody t_goods_one tgoodsone){
        deleteRedis();
        System.out.println(tgoodsone);
        merchantService.saveMerchant(tgoodsone);
    }


    @PutMapping("updateMerchant")
    @ResponseBody
    public void updateMerchant(@RequestBody t_goods_one tgoodsone){
        deleteRedis();
        System.out.println(tgoodsone);
        merchantService.updateMerchant(tgoodsone);
    }


    //删除redis缓存
    @RequestMapping("deleteRedis")
    @ResponseBody
    public void deleteRedis(){
        redisTemplate.delete("merList");
    }

    //批量删除
    @DeleteMapping("deleteBrand/{ids}")
    @ResponseBody
    public void deleteBrand(@PathVariable Integer[] ids){
        deleteRedis();
        merchantService.deleteBrand(ids);
    }


    @GetMapping("addgold")
    @ResponseBody
    public void addgold(){
        merchantService.addgold();
    }


    //折线图
    @GetMapping("findshopline")
    @ResponseBody
    public List<Map<String, Object>> findshopline(){
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> queryUserList = merchantService.findshopline();
        for (Map<String, Object> map : queryUserList) {
            Map<String,Object> map1 =new HashMap<String,Object>();
            Integer  object = Integer.parseInt(map.get("类型").toString()) ;
            if(object==1){
                map1.put("name", "美食");
            }
            if(object==2){
                map1.put("name", "小吃");
            }
            if(object==3){
                map1.put("name", "快产便当");
            }
            if(object==4){
                map1.put("name", "特色菜系");
            }
            if(object==5){
                map1.put("name", "异国料理");
            }
            if(object==6){
                map1.put("name", "甜品饮品");
            }
            if(object==7){
                map1.put("name", "果蔬生鲜");
            }
            if(object==8){
                map1.put("name", "商店超市");
            }
            if(object==9){
                map1.put("name", "鲜花绿植");
            }
            if(object==10){
                map1.put("name", "医药健康");
            }
            if(object==11){
                map1.put("name", "早餐");
            }
            if(object==12){
                map1.put("name", "午餐");
            }
            if(object==13){
                map1.put("name", "下午茶");
            }
            if(object==14){
                map1.put("name", "晚餐");
            }
            map1.put("y", map.get("总个数"));
            map1.put("sliced", true);
            map1.put("selected", true);
            list.add(map1);
        }
        return list;
    }

    //饼状图
    @GetMapping("findsystem")
    @ResponseBody
    public List<Map<String, Object>> findsystem(){
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> queryUserList = merchantService.findsystem();
        for (Map<String, Object> map : queryUserList) {
            Map<String,Object> map1 =new HashMap<String,Object>();
            map1.put("name", map.get("日期"));
            map1.put("y", map.get("总个数"));
            map1.put("sliced", true);
            map1.put("selected", true);
            list.add(map1);
        }
        return list;
    }
}
