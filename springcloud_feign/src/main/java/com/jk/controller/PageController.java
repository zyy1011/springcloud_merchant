package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("toreg")
    public String toreg() {
        return "reg";
    }

    @RequestMapping("tolong")
    public String tolong() {
        return "login";
    }

    @RequestMapping("tomain")
    public String tomain() {
        return "main";
    }

    @RequestMapping("toshang")
    public String toshang() {
        return "addShang";
    }

    @RequestMapping("toaddOne")
    public String toaddOne() {
        return "aadaad";
    }

    @RequestMapping("toupdate")
    public String update() {
        return "update";
    }

    @RequestMapping("toMerchant")
    public String toMerchant() {
        return "merchantsList";
    }

    @RequestMapping("toadd")
    public String toadd() {
        return "add";
    }

    @RequestMapping("toUpdateMerchant")
    public String toUpdateMerchant() {
        return "updateMerchart";
    }

    @RequestMapping("toenter")
    public String toenter() {
        return "enter";
    }

    @RequestMapping("toaddEnter")
    public String toaddEnter() {
        return "addEnter";
    }

    @RequestMapping("tosuccess")
    public String tosuccess() {
        return "success";
    }

    @RequestMapping("toaddmenu")
    public String toaddmenu() {
        return "addmenu";
    }

    @RequestMapping("torobot")
    public String torobot() {
        return "robot";
    }

    @RequestMapping("toleague")
    public String toleague() {
        return "league";
    }


    @RequestMapping("toDistribution")
    public String toDistribution() {
        return "Distribution";
    }

    @RequestMapping("toDistribution2")
    public String toDistribution2() {
        return "Distribution2";
    }

    @RequestMapping("toDistribution3")
    public String toDistribution3() {
        return "Distribution3";
    }

    @RequestMapping("togold")
    public String togild() {
        return "gold";
    }

}
