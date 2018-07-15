<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div align="center">
	<form action="film.action?op=insertFilminfo" method="post">
		<span>电影名称：</span><input type="text" name="filmname"><br><br>	
		<span>电影类型：</span>
		<select name="typeid" id="typeid">
		</select>
		<br><br>
		<span>主演：</span><input type="text" name="actor"><br><br>
		<span>导演：</span><input type="text" name="director"><br><br>
		<span>价格：</span><input type="text" name="ticketprice"><br><br>
		<input type="submit" value="添加电影">
	</form>
</div>
<%@include file="bottom.jsp" %>