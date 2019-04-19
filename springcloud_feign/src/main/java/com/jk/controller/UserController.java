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

import com.jk.model.Role;
import com.jk.model.Shang;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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


    //新增
    @PostMapping("saveUser")
    @ResponseBody
    public void saveMovie(@RequestBody Shang shang){
        userService.saveMovie(shang);
    }

    @DeleteMapping("deleteOne/{id}")
    @ResponseBody
    public void deleteOne(@PathVariable("id") Integer id){
        userService.deleteOne(id);
    }


    @GetMapping("findMovieById/{id}")
    @ResponseBody
    public Shang findMovieById(@PathVariable("id") Integer id){
        return userService.findMovieById(id);
    }

    @PutMapping("updateMovie")
    @ResponseBody
    public void updateMovie(@RequestBody Shang shang){
        userService.updateMovie(shang);
    }

    //删除品牌
    @DeleteMapping("deleteBrand/{ids}")
    @ResponseBody
    public void deleteBrand(@PathVariable Integer[] ids){
        userService.deleteBrand(ids);
    }



}
