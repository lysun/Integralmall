<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="merchandise" subtab="shelve">
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
               <label for="classify" class="col-sm-2 control-label">总店:</label>
               <div class="col-sm-10">
                <c:forEach items="${shops }" var="shop">
               		<c:if test="${shop.id eq t.shopId}">
               		<p class="form-control">${shop.shopName }</p>
               		</c:if>
               	</c:forEach>
               </div>
           </div>
           <div class="form-group">
               <label for="classify" class="col-sm-2 control-label">分店:</label>
               <div class="col-sm-10">
               <p class="form-control">
                    <c:forEach items="${t.shopDtos}" var="shopDto">
                    ${shopDto.name };
                    </c:forEach>
               </p>
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
           <div class="form-group">
               <label for="price" class="col-sm-2 control-label">价格:</label>
               <div class="col-sm-10">
               		<p id="price" class="form-control">${t.price }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="brief" class="col-sm-2 control-label">活动内容:</label>
               <div class="col-sm-10">
                   <p id="brief" class="form-control">${t.brief }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="start" class="col-sm-2 control-label">开始日期:</label>
               <div class="col-sm-10">
                  <p id="start" class="form-control">${t.start }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="end" class="col-sm-2 control-label">结束日期:</label>
               <div class="col-sm-10">
                  <p id="end" class="form-control">${t.end }</p>
               </div>
           </div>
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
               <label for="type" class="col-sm-2 control-label">是否实物商品:</label>
               <div class="col-sm-10">
               		<p class="form-control">
               		<c:if test="${t.type eq '1'}">是</c:if>
               	   	<c:if test="${t.type eq '0'}">否</c:if>
               	   </p>
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
            	   <img src="${t.mainPicDto.url }" height="200" > 
               </div>
           </div>
           <div class="form-group">
               <label for="mediaFile" class="col-sm-2 control-label">图片:</label>
               <div class="col-sm-10">
            	   	<c:forEach items="${t.mediaDtos}" var="media">
            	    <div class="col-sm-4">
            	   		<img src="${media.url }" height="200" >
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