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
		<form action="./" role="form" class="form-horizontal" method="post" enctype="multipart/form-data" enctype="multipart/form-data">
          <div class="form-group">
               <label for="name" class="col-sm-2 control-label">标签名称:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="name" value="${t.name }" placeholder="please input name">
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