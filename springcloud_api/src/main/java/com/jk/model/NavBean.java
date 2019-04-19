package com.jk.model;

import java.util.List;

public class NavBean {

    private Integer id;
    private String text;
    private Integer pid;
    private List<NavBean> nodes;
    private String href;
    private Boolean selectable;//节点是否可以被选中

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<NavBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<NavBean> nodes) {
        this.nodes = nodes;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    @Override
    public String toString() {
        return "NavBean{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pid=" + pid +
                ", nodes=" + nodes +
                ", href='" + href + '\'' +
                ", selectable=" + selectable +
                '}';
    }
}
