package com.jk.service;

import com.jk.model.Role;
import com.jk.model.Shang;
import com.jk.model.UserBean;
import com.jk.model.caipinBean;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public interface UserService {
    @GetMapping("findRolePage")
    @ResponseBody
    List<Role> findRolePage();

    @PostMapping("reg")
    @ResponseBody
    Boolean saveUser(@RequestBody UserBean userBean);

    @PostMapping  ("login")
    @ResponseBody
    HashMap<String, Object> login(@RequestBody UserBean userBean);

    @GetMapping("queryUser")
    @ResponseBody
    HashMap<String,Object> findMoviePage(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows,@RequestParam("searchList")String searchList);

    @PostMapping("saveUser")
    @ResponseBody
    void saveMovie(@RequestBody Shang shang);


    @DeleteMapping("deleteOne/{id}")
    @ResponseBody
    void deleteOne(@PathVariable("id")Integer id);

    @GetMapping("findMovieById/{id}")
    @ResponseBody
    Shang findMovieById(@PathVariable("id")Integer id);

    @PutMapping("updateMovie")
    @ResponseBody
    void updateMovie(@RequestBody Shang shang);

    //删除 模板
    @DeleteMapping("deleteTemplate")
    @ResponseBody
    void deleteBrand(@RequestParam("ids") Integer[] ids);

    @GetMapping("sendMsg")
    @ResponseBody
    String sendMsg(String message);

    @GetMapping("queryCaipin")
    @ResponseBody
    HashMap<String, Object> queryCaipin(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows);

    @PostMapping("saveCaiPin")
    @ResponseBody
    void saveCaiPin(@RequestBody caipinBean caipin);

    @DeleteMapping("deletecaipin/{id}")
    @ResponseBody
    void deletecaipin(@PathVariable("id")Integer id);


    @DeleteMapping("deleteCaiPin")
    @ResponseBody
    void deleteCaiPin(@RequestParam("ids") Integer[] ids);

    @GetMapping("findCaPinById/{id}")
    @ResponseBody
    caipinBean findCaPinById(@PathVariable("id")Integer id);

    @PutMapping("updateCaiPin")
    @ResponseBody
    void updateCaiPin(@RequestBody caipinBean caipin);
}
