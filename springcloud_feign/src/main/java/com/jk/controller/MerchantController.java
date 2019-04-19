package com.jk.controller;

import com.jk.model.MerchantBean;
import com.jk.model.NavBean;
import com.jk.model.TreeBean;
import com.jk.service.MerchantServiceFeign;
import com.jk.service.serviceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        HashMap<String, Object> map = new HashMap<>();
        //1、定义缓冲key
        String key="powertree";
        //2、从缓冲中查找是否有当前用户的权限树
        if (!redisTemplate.hasKey(key)) {
            System.out.println("-----------走数据库");
            //3、如果没有：a.从数据库查  b. 把数据缓冲到redis
            map=merchantService.findMerchantPage(page,rows);
            //b. 把数据缓冲到redis
            redisTemplate.opsForValue().set(key, map);
        }else {
            System.out.println("-----------走缓冲");
            //4、如果有：从缓冲中获取返回数据
            map = (HashMap<String, Object>) redisTemplate.opsForValue().get(key);
        }

        return map;
    }
   //回显
    @GetMapping("findMarchantById/{id}")
    @ResponseBody
    public MerchantBean findMarchantById(@PathVariable("id") Integer id){
        MerchantBean mer = merchantService.findMarchantById(id);
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
    public void saveMerchant(@RequestBody MerchantBean merchantBean){
        deleteRedis();
        merchantService.saveMerchant(merchantBean);
        System.out.println(merchantBean);
    }


    @PutMapping("updateMerchant")
    @ResponseBody
    public void updateMerchant(@RequestBody MerchantBean merchantBean){
        deleteRedis();
        merchantService.updateMerchant(merchantBean);
    }


    //删除redis缓存
    @RequestMapping("deleteRedis")
    @ResponseBody
    public void deleteRedis(){
        redisTemplate.delete("powertree");
    }

}
