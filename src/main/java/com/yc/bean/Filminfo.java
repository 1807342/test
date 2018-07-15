package com.yc.bean;

import java.io.Serializable;

public class Filminfo implements Serializable {

	/**
	 *filmid int primary key auto_increment,
	typeid int ,
	filmname varchar(50),
	actor varchar(50),
	director varchar(50),
	ticketprice double 
	 */
	private static final long serialVersionUID = -2384026932564572749L;
	private Integer filmid;
	private String actor;
	private String director;
	private String filmname;
	private double ticketprice;
	private Integer typeid;
	private Filmtype filmtype;
	
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public Filmtype getFilmtype() {
		return filmtype;
	}
	public void setFilmtype(Filmtype filmtype) {
		this.filmtype = filmtype;
	}
	public Integer getFilmid() {
		return filmid;
	}
	public void setFilmid(Integer filmid) {
		this.filmid = filmid;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getFilmname() {
		return filmname;
	}
	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}
	public double getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
	@Override
	public String toString() {
		return "Filminfo [filmid=" + filmid + ", actor=" + actor + ", director=" + director + ", filmname=" + filmname
				+ ", ticketprice=" + ticketprice + ", filmtype=" + filmtype + "]";
	}
	
	
	
}
