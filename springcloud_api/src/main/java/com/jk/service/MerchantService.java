package com.jk.service;

import com.jk.model.MerchantBean;
import com.jk.model.NavBean;
import com.jk.model.TreeBean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
}
