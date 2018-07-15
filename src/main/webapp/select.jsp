<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div align="center">
	<table border="1" cellpadding="0" cellspacing="0" bordercolor="blue" width="800px" height="auto" >
		<tr align="center">
			<th width="5%">编号</th>
			<th width="20%">电影名</th>
			<th width="10%">类型</th>
			<th width="40%">主演</th>
			<th width="20%">导演</th>
			<th width="5%">票价</th>
		</tr>
		<c:forEach items="${filminfo }" var="filminfo">
		<tr align="center">
			<td>${filminfo.filmid}</td>
			<td>${filminfo.filmname }</td>
			<td>${filminfo.filmtype.typename }</td>
			<td>${filminfo.actor }</td>
			<td>${filminfo.director }</td>
			<td>${filminfo.ticketprice }</td>
		</tr>
		</c:forEach>
	</table>
</div>
<%@include file="bottom.jsp" %>