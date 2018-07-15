package com.yc.bean;

import java.io.Serializable;

public class Filmtype implements Serializable {
	/*
	 * typeid int primary key auto_increment,
		typename varchar(50)
	 */
	private static final long serialVersionUID = 3069990178657207352L;

	private Integer typeid;
	private String  typename;
	
	public Filmtype() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Filmtype(Integer typeid, String typename) {
		super();
		this.typeid = typeid;
		this.typename = typename;
	}


	public Filmtype(String typename) {
		super();
		this.typename = typename;
	}


	public Filmtype(Integer typeid) {
		super();
		this.typeid = typeid;
	}


	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "Filmtype [typeid=" + typeid + ", typename=" + typename + "]";
	}
	
	
}
