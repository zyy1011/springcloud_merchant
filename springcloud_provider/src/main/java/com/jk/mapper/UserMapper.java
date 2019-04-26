package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserMapper {

    List<Role> findRolePage();


    Integer getUserInfoAccount(String name);

    void saveUser(@RequestBody  UserBean userBean);

    void saveUserRole(@Param("userid")Integer id,@Param("split")String[] split);

    UserBean UserAccount(String name);

    int findUserCount(@Param("shang") Shang shang);

    List<Shang> findUserList(@Param("start")int start,@Param("rows") Integer rows,@Param("shang") Shang shang);

    void saveMovie(Shang shang);

    void deleteOne(Integer id);

    Shang findMovieById(Integer id);

    void updateMovie(Shang shang);

    //删除模板
    void deleteTemplate(@Param("ids") Integer[] ids);

    int queryCaipinCount();

    List<caipinBean> queryCaipin(@Param("start")int start, @Param("rows") Integer rows);

    void saveCaiPin(@RequestBody caipinBean caipin);

    void deletecaipin(Integer id);

    void deleteCaiPin(@Param("ids") Integer[] ids);


    void updateCaiPin(caipinBean caipin);

    caipinBean findCaPinById(Integer id);

    List<AreaBean> findAreaId(Integer id);

//    String getAreaNameById(Integer area);
}
