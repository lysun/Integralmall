<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>  
<%@ attribute name="tab" %>
<%@ attribute name="nav" fragment="true" %>
<%@ attribute name="script" fragment="true" %>
<%@ attribute name="style" fragment="true" %>
<%@ attribute name="htmlClass" %>
<!DOCTYPE html>
<html <c:if test="${!empty htmlClass }">class="${htmlClass }"</c:if>>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>backend</title>
    <link href="<c:url value='/resources/css/app.css'/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/upload.css'/>" type="text/css" rel="stylesheet"/>
    <jsp:invoke fragment="style"></jsp:invoke>
</head>
<body>	
	<nav class="navbar navbar-default">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">后台管理</a>
        </div>
         <div style="margin-right:80px;">
	     <ul class="nav navbar-nav navbar-left">
	     	<shiro:hasPermission name="merchandise:*">
	   		<li <c:if test="${tab eq 'merchandise' }">class="active"</c:if>><a href="<c:url value='/admin/merchandise'/>">商品管理</a></li>
	   		</shiro:hasPermission>
	   		<shiro:hasPermission name="integralOrder:*">
    		<li <c:if test="${tab eq 'integralOrder' }">class="active"</c:if>><a href="<c:url value='/admin/integralOrder'/>">积分订单管理</a></li>
    		</shiro:hasPermission>
	   		<shiro:hasPermission name="user:*">
				<li <c:if test="${tab eq 'user' }">class="active"</c:if>><a href="<c:url value='/admin/user'/>">用户管理</a></li>
			</shiro:hasPermission>
		</ul>
	    <p class="navbar-text navbar-right"><a href="<c:url value='/logout'/>">退出</a></p>
	    <p class="navbar-text navbar-right"><shiro:principal/>,欢迎您</p>
	   </div>
    </nav>
    <div class="container-fluid">
        
        <div class="row">
            <div class="col-sm-2">
            	<jsp:invoke fragment="nav"/>                
            </div>
            <div class="col-sm-10">
            	<jsp:doBody/>
            </div>            
        </div>  
    </div>
    <script src="<c:url value='/resources/js/jquery-1.11.1.js'/>"></script>
    <script src="<c:url value='/resources/js/jquery.form.js'/>"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/js/bootbox.min.js'/>"></script>
    <script src="<c:url value='/resources/js/art-template.js'/>"></script>
    <script charset="utf-8" src="<c:url value='/resources/js/kindeditor.js'/>"></script>
    <script charset="utf-8" src="<c:url value='/resources/js/autoheight.js'/>"></script>
    <script charset="utf-8" src="<c:url value='/resources/js/lang/zh_CN.js'/>"></script>
	<script src="<c:url value='/resources/js/bootstrap-datepicker.min.js'/>"></script>
    <script src="<c:url value='/resources/js/jquery.twbsPagination.min.js'/>"></script>
    <script src="<c:url value='/resources/js/admin.js'/>"></script>
    <jsp:invoke fragment="script"></jsp:invoke>
</body>
</html>
