/**
 * Copyright (C), 2019, 金科教育
 * FileName: PageController
 * Author:   ls
 * Date:     2019/4/17 17:48
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author ls
 * @create 2019/4/17
 * @since 1.0.0
 */
@Controller
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
    @RequestMapping("toadd")
    public String toadd(){
        return "aadaad";
    }
    @RequestMapping("toupdate")
    public String update(){
        return "update";
    }


}
