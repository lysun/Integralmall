<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="integral">
	<jsp:attribute name="nav">
		<my:integral-nav tab="merchandise"></my:integral-nav>
	</jsp:attribute>
	<jsp:body>
		<form role="form" class="form-horizontal" method="post">
           <div class="form-group">
               <label for="seq" class="col-sm-2 control-label">编号:</label>
               <div class="col-sm-10">
                    <p class="form-control">${t.seq }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="classify" class="col-sm-2 control-label">商品分类:</label>
               <div class="col-sm-10">
                    <p class="form-control">${t.classifyDto.name }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="brand" class="col-sm-2 control-label">商品品牌:</label>
               <div class="col-sm-10">
                    <p class="form-control">${t.brandDto.name }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="name" class="col-sm-2 control-label">商品名称:</label>
               <div class="col-sm-10">
                    <p class="form-control">${t.name }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="integralCount" class="col-sm-2 control-label">所需积分:</label>
               <div class="col-sm-10">
                   <p class="form-control">${t.integralCount }</p>
               </div>
           </div>
            <c:if test="${t.isActual eq '1' }">
           <div class="form-group">
               <label for="price" class="col-sm-2 control-label">价格:</label>
               <div class="col-sm-10">
               		<p id="price" class="form-control">${t.price }</p>
               </div>
           </div>
           </c:if>
           <div class="form-group">
               <label for="stock" class="col-sm-2 control-label">库存:</label>
               <div class="col-sm-10">
                   <p class="form-control">${t.stock }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="original" class="col-sm-2 control-label">渠道专享:</label>
               <div class="col-sm-10">
                   <p class="form-control">${t.original }</p>
               </div>
           </div>
           
           <div class="form-group">
               <label for="isShelve" class="col-sm-2 control-label">是否下架:</label>
               <div class="col-sm-10">
               		<p class="form-control">
               		<c:if test="${t.isShelve eq '1'}">否</c:if>
               	   	<c:if test="${t.isShelve eq '0'}">是</c:if>
               	   </p>
               </div>
           </div>
           
           <div class="form-group">
               <label for="mediaFile" class="col-sm-2 control-label">主图片:</label>
               <div class="col-sm-10">
            	   	<div class="col-sm-3">
               	   		<img src="${t.mainPicDto.url }" width="200" height="200"> 
               	   	</div>
               </div>
           </div>
           <div class="form-group">
               <label for="mediaFile" class="col-sm-2 control-label">图片:</label>
               <div class="col-sm-10">
            	   	<c:forEach items="${t.mediaDtos}" var="media">
            	   	<div class="col-sm-3">
            	   		<img src="${media.url }" width="200" height="200">
            	   	</div>
            	   	</c:forEach>	
               </div>
           </div>
           <div class="form-group">
               <label for="remark" class="col-sm-2 control-label">简介:</label>
               <div class="col-sm-10">
                   <textarea rows="10" cols="170" name="remark" readonly="readonly">${t.remark }</textarea>
               </div>
           </div>
       </form>
	</jsp:body>
</my:admin>