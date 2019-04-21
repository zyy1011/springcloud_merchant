package com.jk.mapper;

import com.jk.model.Role;
import com.jk.model.Shang;
import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserMapper {

    List<Role> findRolePage();


    Integer getUserInfoAccount(String name);

    void saveUser(@RequestBody  UserBean userBean);

    void saveUserRole(@Param("userid")Integer id,@Param("split")String[] split);

    UserBean UserAccount(String name);

    int findUserCount();

    List<Shang> findUserList(@Param("start")int start,@Param("rows") Integer rows);

    void saveMovie(Shang shang);

    void deleteOne(Integer id);

    Shang findMovieById(Integer id);

    void updateMovie(Shang shang);

    //删除模板
    void deleteTemplate(@Param("ids") Integer[] ids);
    
}
