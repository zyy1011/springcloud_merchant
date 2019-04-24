package com.jk.service;

import com.jk.model.MerchantBean;
import com.jk.model.NavBean;
import com.jk.model.TreeBean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MerchantService {

    @GetMapping("findTreeList")
    @ResponseBody
    List<NavBean> findTreeList();

    @GetMapping("findMerchantPage")
    @ResponseBody
    HashMap<String, Object> findMerchantPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @GetMapping("findMarchantById/{id}")
    @ResponseBody
    MerchantBean findMarchantById(@PathVariable("id") Integer id);

    @DeleteMapping("delOne/{id}")
    @ResponseBody
    void delOne(@PathVariable("id") Integer id);

    @GetMapping("updateStatus/{id}")
    @ResponseBody
    void updateStatus(@PathVariable("id") Integer id);

    @PostMapping("saveMerchant")
    @ResponseBody
    void saveMerchant(@RequestBody MerchantBean merchantBean);

    @PutMapping("updateMerchant")
    @ResponseBody
    void updateMerchant(@RequestBody MerchantBean merchantBean);

    @PutMapping("updateShang")
    @ResponseBody
    void updateShang(@RequestParam("ids")  Integer[] ids);

    @PutMapping("updateXai")
    @ResponseBody
    void updateXai(@RequestParam("ids") Integer[] ids);

    @GetMapping("addgold")
    @ResponseBody
    void addgold();

    @GetMapping("findshopline")
    @ResponseBody
    List<Map<String, Object>> findshopline();

    @GetMapping("findsystem")
    @ResponseBody
    List<Map<String, Object>> findsystem();

     //删除 模板
    @DeleteMapping("deleteTemplate")
    @ResponseBody
    void deleteBrand(@RequestParam("ids") Integer[] ids);



}
