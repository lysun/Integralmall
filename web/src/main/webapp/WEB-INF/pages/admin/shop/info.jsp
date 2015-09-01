<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="shop">
<jsp:attribute name="nav">
		<my:shop-nav tab="shop"></my:shop-nav>
	</jsp:attribute>
	<jsp:body>
		<form role="form" class="form-horizontal" method="post">
            <div class="form-group">
               <label for="num" class="col-sm-2 control-label">商户编号:</label>
               <div class="col-sm-10">
                  <p class="form-control">${t.num }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="shopName" class="col-sm-2 control-label">商家名称:</label>
               <div class="col-sm-10">
                  <p class="form-control">${t.shopName }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="classifyId" class="col-sm-2 control-label">商家分类:</label>
               <div class="col-sm-10">
               		<p class="form-control">${t.classifyDto.name}</p>
               </div>
           </div>
           <div class="form-group">
               <label for="description" class="col-sm-2 control-label">简介:</label>
               <div class="col-sm-10">
               		<p class="form-control">${t.description }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="mainPic" class="col-sm-2 control-label">首页图片:</label>
               <div class="col-sm-10">
                   <img id="mainImage" width="200" height="200" src="${t.mainPicDto.url }">
               </div>
           </div>
           <div class="form-group">
               <label for="integral" class="col-sm-2 control-label">可分配积分:</label>
               <div class="col-sm-10">
               <p class="form-control">${t.integral }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="classifyId" class="col-sm-2 control-label">商家标签:</label>
               <div class="col-sm-10">
                   <c:forEach items="${t.tags}" var="tag">
	               		${tag.name} 
	               	</c:forEach>
               </div>
           </div>
          <div class="form-group">
               <label for="classifyId" class="col-sm-2 control-label">分店信息:</label>
               <div class="col-sm-10">
                <c:forEach items="${t.branchs }" var="branch">
		           <div class="panel panel-default">
					   <div class="panel-body">
					   <table class="table table-condensed">
					   <caption>${branch.name }</caption>
					     <tr>
					         <td>分店编号：${branch.num }</td>
					         <td>分店位置：${branch.longitude },${branch.latitude }</td>
					     </tr>
					     <tr>
					         <td>联系人：${branch.contact }</td>
					         <td>联系电话：${branch.tel }</td>
					     </tr>
					    
					   </table>
						
					   </div>
					</div>
		           </c:forEach>
               </div>
           </div>
       </form>
	</jsp:body>
</my:admin>