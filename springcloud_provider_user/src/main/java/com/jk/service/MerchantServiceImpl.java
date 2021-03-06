package com.jk.service;

import com.alibaba.fastjson.JSON;
import com.jk.mapper.MerchantMapper;
import com.jk.model.Shang;
import com.jk.model.t_goods_one;
import com.jk.model.NavBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    //左侧导航树

    @GetMapping("findTreeList")
    @ResponseBody
    @Override
    public List<NavBean> findTreeList() {
        int pid = 0;
        List<NavBean> list = treeNodes(pid);
        return list;
    }

    private List<NavBean> treeNodes(int pid) {
        List<NavBean> list = merchantMapper.findTreeList(pid);
        for (NavBean navBean : list) {
            Integer id = navBean.getId();
            List<NavBean> nodes = treeNodes(id);
            if (nodes.size() <= 0) {
                //无子节点
                navBean.setSelectable(true);
            } else {
                navBean.setSelectable(false);
                navBean.setNodes(nodes);
            }
        }
        return list;
    }

    //查询
    @Override
    @ResponseBody
    public HashMap<String, Object> findMerchantPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("searchList") String searchList) {
        HashMap<String, Object> hashMap = new HashMap<>();
        t_goods_one goods = JSON.parseObject(searchList, t_goods_one.class);

        List range = redisTemplate.opsForList().range("merList", (page - 1) * rows, page * rows - 1);

        if (("" != goods.getName()| null != goods.getName())||null != goods.getCounts()||null != goods.getPrice()){
            System.out.println("条查走数据库");
            //查询总条数
            int total = merchantMapper.findMerchantCount(goods);
            //分页查询
            int start = (page - 1) * rows;
            List<t_goods_one> list = merchantMapper.findMerchantPage(start, rows,goods);
            hashMap.put("total", total);
            hashMap.put("rows", list);
            return hashMap;
        }else if (range.isEmpty()) {
            System.out.println("走数据库");
            //查询总条数
            int total = merchantMapper.findMerchantCount(goods);
            //分页查询
            int start = (page - 1) * rows;
            List<t_goods_one> list = merchantMapper.findMerchantPage(start, rows,goods);
            List<t_goods_one> listAll = merchantMapper.findMerchantPageAll();
            redisTemplate.opsForList().rightPushAll("merList", listAll);
            hashMap.put("total", total);
            hashMap.put("rows", list);
            return hashMap;
        } else {
            System.out.println("走redis");
            int size = redisTemplate.opsForList().range("merList", 0, -1).size();
            hashMap.put("total", size);
            hashMap.put("rows", range);
            return hashMap;
        }
    }

    @Override
    @ResponseBody
    public t_goods_one findMarchantById(@PathVariable("id") Integer id) {
        return merchantMapper.findMarchantById(id);
    }

    @Override
    @ResponseBody
    public void delOne(Integer id) {
        merchantMapper.delOne(id);
    }

    @Override
    public void updateStatus(Integer id) {
        t_goods_one marchantById = merchantMapper.findMarchantById(id);

        if (marchantById.getUpdown() == 1) {
            marchantById.setUpdown(2);
            System.out.println("第一接参数" + marchantById.getUpdown());

        } else {
            marchantById.setUpdown(1);
            System.out.println("第二接参数" + marchantById.getUpdown());
        }
        System.out.println("最后接参数" + marchantById.getUpdown());
        merchantMapper.updateMerchant(marchantById);
    }


    @Override
    @ResponseBody
    public void saveMerchant(t_goods_one tgoodsone) {
        merchantMapper.saveMerchant(tgoodsone);
        System.out.println("-----------------------" + tgoodsone);
    }

    @Override
    @ResponseBody
    public void updateMerchant(t_goods_one tgoodsone) {
        merchantMapper.updateMerchant(tgoodsone);
    }

    @Override
    @ResponseBody
    public void updateShang(Integer[] ids) {
        merchantMapper.updateShang(ids);
    }

    @Override
    @ResponseBody
    public void updateXai(Integer[] ids) {
        merchantMapper.updateXai(ids);
    }

    @Override
    @ResponseBody
    public void addgold() {
        merchantMapper.addgold();
    }

    @Override
    public List<Map<String, Object>> findshopline() {
        return merchantMapper.findshopline();
    }

    @Override
    public List<Map<String, Object>> findsystem() {
        return merchantMapper.findsystem();
    }

    @Override
    @ResponseBody
    public void deleteBrand(Integer[] ids) {
        merchantMapper.deleteTemplate(ids);
    }


}
