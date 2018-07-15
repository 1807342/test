<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影院信息查询</title>
</head>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"film.action?op=findAlltype",
			dataType:"JSON",
			type:"POST",
			success:function(data){
				if(data.code==1){
					 $.each(data.obj,function(index,item){
						$("<option value='"+ item.typeid+"'>"+ item.typename+"</option>").appendTo($("#typeid"));
					}); 
				}
			}
		});
	})


</script>
<body>