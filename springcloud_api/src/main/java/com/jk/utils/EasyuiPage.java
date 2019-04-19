/** 
 * <pre>项目名称:t_car 
 * 文件名称:EasyuiPage.java 
 * 包名:com.jk.axy.utils 
 * 创建日期:2019年2月14日下午4:20:19 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.utils;

/** 
 * <pre>项目名称：t_car    
 * 类名称：EasyuiPage    
 * 类描述：    
 * 创建人：安晓艳
 * 创建时间：2019年2月14日 下午4:20:19    
 * 修改人：安晓艳
 * 修改时间：2019年2月14日 下午4:20:19    
 * 修改备注：       
 * @version </pre>    
 */
public class EasyuiPage {

	
	private Integer total;
	private Object  rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "EasyuiPage [total=" + total + ", rows=" + rows + "]";
	}
	
}
