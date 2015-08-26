<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="shop">
<jsp:attribute name="nav">
		<my:shop-nav tab="tag"></my:shop-nav>
	</jsp:attribute>
	<jsp:body>
		<form role="form" class="form-horizontal" method="post">
           <div class="form-group">
               <label for="name" class="col-sm-2 control-label">标签名:</label>
               <div class="col-sm-10">
                   <p class="form-control">${t.name }</p>
               </div>
           </div>
           
       </form>
	</jsp:body>
</my:admin>