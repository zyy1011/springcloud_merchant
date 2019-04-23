package com.jk.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.MerchantMapper;
import com.jk.model.MerchantBean;
import com.jk.model.NavBean;
import com.jk.utils.HttpClientUtil;

import org.springframework.beans.factory.annotation.Autowired;
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


    //左侧导航树

    @GetMapping("findTreeList")
    @ResponseBody
    @Override
    public List<NavBean> findTreeList() {
        int pid=0;
        List<NavBean> list = treeNodes(pid);
        return list;
    }

    private List<NavBean> treeNodes(int pid) {
        List<NavBean> list = merchantMapper.findTreeList(pid);
        for (NavBean navBean : list) {
            Integer id = navBean.getId();
            List<NavBean> nodes = treeNodes(id);
            if(nodes.size()<=0) {
                //无子节点
                navBean.setSelectable(true);
            }else {
                navBean.setSelectable(false);
                navBean.setNodes(nodes);
            }
        }
        return list;
    }
    //查询
    @Override
    @ResponseBody
    public HashMap<String, Object> findMerchantPage(@RequestParam("page")Integer page, @RequestParam("rows") Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = merchantMapper.findMerchantCount();
        //分页查询
        int start = (page-1)*rows;
        List<MerchantBean> list = merchantMapper.findMerchantPage(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    @ResponseBody
    public MerchantBean findMarchantById(@PathVariable("id") Integer id) {
        return merchantMapper.findMarchantById(id);
    }

    @Override
    @ResponseBody
    public void delOne(Integer id) {
        merchantMapper.delOne(id);
    }

    @Override
    public void updateStatus(Integer id) {
        MerchantBean marchantById = merchantMapper.findMarchantById(id);

        if (marchantById.getUpdown()==1){
            marchantById.setUpdown(2);
            System.out.println("第一接参数"+marchantById.getUpdown());

        }else {
            marchantById.setUpdown(1);
            System.out.println("第二接参数"+marchantById.getUpdown());
        }
        System.out.println("最后接参数"+marchantById.getUpdown());
        merchantMapper.updateMerchant(marchantById);
    }


    @Override
    @ResponseBody
    public void saveMerchant(MerchantBean merchantBean) {
        Random r = new Random();

        int upCase = r.nextInt(26)+65;//得到65-90的随机数

        int downCase = r.nextInt(26)+97;//得到97-122的随机数

        String up =String.valueOf((char)upCase);//得到A-Z

        String down =String.valueOf((char)downCase);//得到a-z
        merchantBean.setReferencenumber("国药准字"+up+upCase);
        merchantMapper.saveMerchant(merchantBean);
        System.out.println("-----------------------"+merchantBean);
    }

    @Override
    @ResponseBody
    public void updateMerchant(MerchantBean merchantBean) {
        merchantMapper.updateMerchant(merchantBean);
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


}
