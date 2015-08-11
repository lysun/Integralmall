<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<body>  
    <h2>积分商城后台管理系统</h2>
    <form method="post" action="login">
    	用户名:<input name="username"><br>
  		密码:<input name="password"><br>
  		<input type="submit" value="登录">
  		<a href="<c:url value='/regist'/>">注册</a>
  		<%-- <a href="<c:url value='/admin/merchandise'/>">直接进入</a> --%>
  	</form>
</body> 
</html>
