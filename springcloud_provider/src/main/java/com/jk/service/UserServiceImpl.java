/**
 * Copyright (C), 2019, 金科教育
 * FileName: UserServiceImpl
 * Author:   ls
 * Date:     2019/4/17 16:54
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.UserMapper;
import com.jk.model.Role;
import com.jk.model.Shang;
import com.jk.model.UserBean;
import com.jk.model.caipinBean;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.Md5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    @Autowired
    HttpServletRequest request;


    @Override
    @ResponseBody
    public List<Role> findRolePage() {
        return usermapper.findRolePage();
    }

    @Override
    @ResponseBody
    public Boolean saveUser(@RequestBody UserBean userBean) {
        Integer count = usermapper.getUserInfoAccount(userBean.getName());
        if(count==0){
            userBean.setPassword(Md5Util.getMd516(userBean.getPassword()));
            usermapper.saveUser(userBean);
            String roleid =  userBean.getRoleid();
            String[] split = roleid.split(",");
            usermapper.saveUserRole(userBean.getId(),split);

            return true;
        }
        return false;
    }


    @Override
    @ResponseBody
    public HashMap<String, Object> login(@RequestBody UserBean userBean) {

        HashMap<String, Object> hashMap = new HashMap<>();
        HttpSession session = request.getSession();

        //获取账号
        UserBean userInfo = usermapper.UserAccount(userBean.getName());
        if(userInfo == null){
            hashMap.put("code",2);
            hashMap.put("msg","账号密码错误");
            return hashMap;
        }
        //是否一致
        String password = userBean.getPassword();
        String md516 = Md5Util.getMd516(password);
        if(!userInfo.getPassword().equals(md516)){
            hashMap.put("code",3);
            hashMap.put("msg","账号密码错误");
            return hashMap;
        }
        //将用户信息传入
        session.setAttribute("axy_"+session.getId(), userInfo);
        hashMap.put("code",0);
        hashMap.put("msg","成功");
        return hashMap;

    }

    @GetMapping("queryUser")
    @ResponseBody
    @Override
    public HashMap<String, Object> findMoviePage(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = usermapper.findUserCount();
        //分页查询
        int start = (page - 1) * rows;
        List<Shang> list = usermapper.findUserList(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    @ResponseBody
    public void saveMovie(Shang shang) {
        String s = new Date().toLocaleString();
        String substring = s.substring(0, s.indexOf(" "));
        shang.setExpirationdate(substring);
        usermapper.saveMovie(shang);
    }

    @Override
    @ResponseBody
    public void deleteOne(Integer id) {
        usermapper.deleteOne(id);
    }

    @Override
    @ResponseBody
    public void deletecaipin(Integer id) {
        usermapper.deletecaipin(id);
    }



    @Override
    @ResponseBody
    public Shang findMovieById(Integer id) {
        return usermapper.findMovieById(id);
    }

    @Override
    @ResponseBody
    public caipinBean findCaPinById(Integer id) {
        return usermapper.findCaPinById(id);
    }





    @Override
    @ResponseBody
    public void updateMovie(Shang shang) {
        usermapper.updateMovie(shang);
    }


    @Override
    @ResponseBody
    public void updateCaiPin(caipinBean caipin) {
        usermapper.updateCaiPin(caipin);
    }


    @Override
    @ResponseBody
    public void deleteCaiPin(Integer[] ids) {
        usermapper.deleteCaiPin(ids);
    }


   @Override
   @ResponseBody
   public void deleteBrand(Integer[] ids) {
       usermapper.deleteTemplate(ids);
    }

    @Override
    public String sendMsg(String message) {
        String url = "http://api.qingyunke.com/api.php";
        HashMap<String, Object> params = new HashMap<>();
        params.put("key", "free");
        params.put("msg", message);
        String returnStr = HttpClientUtil.get(url, params);
        JSONObject parseObject = JSON.parseObject(returnStr);
        int result = parseObject.getIntValue("result");
        if(result==0){//成功返回0 如果等于0  就是成功
            //将信息内容转成字符串对象
            String content = parseObject.getString("content");
            return content;
        }
        return "接口调用失败";
    }

    @Override
    @ResponseBody
    public HashMap<String, Object> queryCaipin(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = usermapper.queryCaipinCount();
        //分页查询
        int start = (page - 1) * rows;
        List<caipinBean> list = usermapper.queryCaipin(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    @ResponseBody
    public void saveCaiPin(caipinBean caipin) {
        usermapper.saveCaiPin(caipin);
    }










}
