package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("tomain")
    public  String toMain(){
        return "main";
    }
    @RequestMapping("toMerchant")
    public  String toMerchant(){
        return "merchantsList";
    }

    @RequestMapping("toadd")
    public  String toadd(){
        return "add";
    }
    @RequestMapping("toUpdateMerchant")
    public  String toUpdateMerchant(){
        return "updateMerchart";
    }

}
