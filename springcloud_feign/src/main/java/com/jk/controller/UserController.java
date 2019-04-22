/**
 * Copyright (C), 2019, 金科教育
 * FileName: UserController
 * Author:   ls
 * Date:     2019/4/17 16:43
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.jk.model.Role;
import com.jk.model.Shang;
import com.jk.model.UserBean;
import com.jk.model.caipinBean;
import com.jk.service.UserService;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author ls
 * @create 2019/4/17
 * @since 1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findRolePage")
    @ResponseBody
    public List<Role> findRolePage(){
        return userService.findRolePage();
    }


   @PostMapping("reg")
    @ResponseBody
    public Boolean reg(@RequestBody UserBean userBean){
        try {
            return   userService.saveUser(userBean);
        } catch (Exception e) {
            e.printStackTrace();
            return   false;
        }
    }
    @PostMapping  ("login")
    @ResponseBody
    public HashMap<String, Object> login(@RequestBody UserBean userBean){
        return userService.login(userBean);
    }


    //查询用户表
    @GetMapping("queryUser")
    @ResponseBody
    public HashMap<String,Object> findMoviePage(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows){
        return userService.findMoviePage(page,rows);
    }
    //查询用户表
    @GetMapping("queryCaipin")
    @ResponseBody
    public HashMap<String,Object> queryCaipin(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows){
        return userService.queryCaipin(page,rows);
    }


    //新增
    @PostMapping("saveUser")
    @ResponseBody
    public void saveMovie(@RequestBody Shang shang){
        userService.saveMovie(shang);
    }
    //新增菜品
    @PostMapping("saveCaiPin")
    @ResponseBody
    public void saveCaiPin(@RequestBody caipinBean caipin){
        userService.saveCaiPin(caipin);
    }

    @DeleteMapping("deleteOne/{id}")
    @ResponseBody
    public void deleteOne(@PathVariable("id") Integer id){
        userService.deleteOne(id);
    }
    @DeleteMapping("deletecaipin/{id}")
    @ResponseBody
    public void deletecaipin(@PathVariable("id") Integer id){
        userService.deletecaipin(id);
    }


    @GetMapping("findMovieById/{id}")
    @ResponseBody
    public Shang findMovieById(@PathVariable("id") Integer id){
        return userService.findMovieById(id);
    }

    @GetMapping("findCaPinById/{id}")
    @ResponseBody
    public caipinBean findCaPinById(@PathVariable("id") Integer id){
        return userService.findCaPinById(id);
    }

    @PutMapping("updateMovie")
    @ResponseBody
    public void updateMovie(@RequestBody Shang shang){
        userService.updateMovie(shang);
    }
    @PutMapping("updateCaiPin")
    @ResponseBody
    public void updateCaiPin(@RequestBody caipinBean caipin){
        userService.updateCaiPin(caipin);
    }

    //删除品牌
    @DeleteMapping("deleteBrand/{ids}")
    @ResponseBody
    public void deleteBrand(@PathVariable Integer[] ids){
        userService.deleteBrand(ids);
    }
    //删除
    @DeleteMapping("deleteCaiPin/{ids}")
    @ResponseBody
    public void deleteCaiPin(@PathVariable Integer[] ids){
        userService.deleteCaiPin(ids);
    }





    @RequestMapping("chatRobot")
    @ResponseBody
    private JsonNode chatRobot(String str) throws IOException {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("key", "free");
        params.put("appid", 0);
        params.put("msg", str);
        String string = HttpClientUtil.get("http://api.qingyunke.com/api.php?key=free&appid=0&msg=", params);
        JsonNode jsonToJsonNode = JsonUtil.jsonToJsonNode(string);
        JsonNode jsonNode = jsonToJsonNode.get("content");
        return jsonNode;
    }



}
