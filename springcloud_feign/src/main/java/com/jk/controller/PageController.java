package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {


    @RequestMapping("toreg")
    public String toreg(){
        return "reg";
    }
    @RequestMapping("tolong")
    public String tolong(){
        return "login";
    }
    @RequestMapping("tomain")
    public String tomain(){
        return "main";
    }
    @RequestMapping("toshang")
    public String toshang(){
        return "addShang";
    }
    @RequestMapping("toaddOne")
    public String toaddOne(){
        return "aadaad";
    }
    @RequestMapping("toupdate")
    public String update(){
        return "update";
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
