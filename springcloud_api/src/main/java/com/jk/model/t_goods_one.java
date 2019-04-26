package com.jk.model;

import java.io.Serializable;

public class t_goods_one implements Serializable {

    private static final long serialVersionUID = -7522616904751136867L;
    /** 主键id */
    private Integer id ;
    /** 菜品名称 */
    private String name ;
    /** 菜品类型 */
    private String type ;
    /** 菜品图片 */
    private String image ;
    /** 菜品描述 */
    private String info ;
    /** 菜品库存 */
    private Integer counts ;
    /** 购买人数 */
    private Integer peoplebuy ;
    /*上下架*/
    private Integer updown;
    /*单价*/
    private Double price;
    /*配送费*/
    private String peisong;


    private Integer Startprice;
    private Integer Endprice;
    private Integer StartCounts;
    private Integer EndCounts;


    public Integer getStartCounts() {
        return StartCounts;
    }

    public void setStartCounts(Integer startCounts) {
        StartCounts = startCounts;
    }

    public Integer getEndCounts() {
        return EndCounts;
    }

    public void setEndCounts(Integer endCounts) {
        EndCounts = endCounts;
    }

    public Integer getStartprice() {
        return Startprice;
    }

    public void setStartprice(Integer startprice) {
        Startprice = startprice;
    }

    public Integer getEndprice() {
        return Endprice;
    }

    public void setEndprice(Integer endprice) {
        Endprice = endprice;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getPeoplebuy() {
        return peoplebuy;
    }

    public void setPeoplebuy(Integer peoplebuy) {
        this.peoplebuy = peoplebuy;
    }

    public Integer getUpdown() {
        return updown;
    }

    public void setUpdown(Integer updown) {
        this.updown = updown;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPeisong() {
        return peisong;
    }

    public void setPeisong(String peisong) {
        this.peisong = peisong;
    }

    @Override
    public String toString() {
        return "t_goods_one{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", info='" + info + '\'' +
                ", counts=" + counts +
                ", peoplebuy=" + peoplebuy +
                ", updown=" + updown +
                ", price=" + price +
                ", peisong='" + peisong + '\'' +
                ", Startprice=" + Startprice +
                ", Endprice=" + Endprice +
                ", StartCounts=" + StartCounts +
                ", EndCounts=" + EndCounts +
                '}';
    }
}
