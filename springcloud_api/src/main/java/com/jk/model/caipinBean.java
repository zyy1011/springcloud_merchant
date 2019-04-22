/**
 * Copyright (C), 2019, 金科教育
 * FileName: caipinBean
 * Author:   ls
 * Date:     2019/4/22 18:33
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
 * @create 2019/4/22
 * @since 1.0.0
 */
public class caipinBean {

    private  Integer id;
    private  String  name;
    private  Integer number;
    private  Double price;
    private  Integer pid;
    private  String  info;
    private  String  area;
    private Integer  type;
    private  String  status;
    private  String  image;



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "caipinBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", pid=" + pid +
                ", info='" + info + '\'' +
                ", area='" + area + '\'' +
                ", type=" + type +
                ", status='" + status + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
