/**
 * Copyright (C), 2019, 金科教育
 * FileName: Role
 * Author:   ls
 * Date:     2019/4/17 16:39
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author ls
 * @create 2019/4/17
 * @since 1.0.0
 */
public class Role {

    /** 主键id */
    private Integer id ;
    /** 角色名称 */
    private String name ;
    /** 角色描述 */
    private String roleinfo ;
    /** 创建角色时间 */
    private String roledate ;
    /** 角色权限 */
    private String power ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleinfo() {
        return roleinfo;
    }

    public void setRoleinfo(String roleinfo) {
        this.roleinfo = roleinfo;
    }

    public String getRoledate() {
        return roledate;
    }

    public void setRoledate(String roledate) {
        this.roledate = roledate;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleinfo='" + roleinfo + '\'' +
                ", roledate='" + roledate + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
