package com.shq.cfa.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuihuaqi
 * @create 2018-03-27 10:38
 * @desc 菜单 值对象
 **/
@Data
public class Menu implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String url;
	
	public Menu(String name, String url) {
		this.name = name;
		this.url = url;
	}
}
