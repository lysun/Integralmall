<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="user">
<jsp:attribute name="nav">
		<my:user-nav tab="user"></my:user-nav>
	</jsp:attribute>
	<jsp:body>
		<form action="./" role="form" class="form-horizontal" method="post" enctype="multipart/form-data">
           <div class="form-group">
               <label for="username" class="col-sm-2 control-label">用户名:</label>
               <div class="col-sm-10">
                   <input value="${t.username }" type="tel" class="form-control" name="username" placeholder="please input username">
               </div>
           </div>
           <div class="form-group">
               <label for="password" class="col-sm-2 control-label">密码:</label>
               <div class="col-sm-10">
                   <input value="${t.password }" type="password" class="form-control" name="password" placeholder="please input password">
               </div>
           </div>
           <div class="form-group">
               <label for="password" class="col-sm-2 control-label">角色:</label>
               <div class="col-sm-10">
                   <select name="roleId" class="form-control">
                   <c:forEach items="${roles}" var="role">
                   <option value="${role.id }" <c:if test="${role.id eq t.userRole.id}">selected</c:if>>${role.name }</option>
                   </c:forEach>
                   </select>
               </div>
           </div>
           <div class="form-group">
			   <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">保存</button>
			   </div>
			</div>
       </form>
	</jsp:body>
</my:admin>