package com.jk.model;

public class UserBean {

    /** 主键id */
    private Integer id ;
    /** 商家名称 */
    private String name ;
    /** 商家年龄 */
    private Integer age ;
    /** 商家身份证号 */
    private String cid ;
    /** 密码 */
    private String password ;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cid='" + cid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
