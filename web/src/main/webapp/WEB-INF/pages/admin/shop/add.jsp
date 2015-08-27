<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="shop">
<jsp:attribute name="nav">
		<my:shop-nav tab="shop"></my:shop-nav>
	</jsp:attribute>
	<jsp:attribute name="script">
		<script>
		function addMainpic(source) {  
	        var file = source.files[0];  
	        if(window.FileReader) {  
	            var fr = new FileReader();  
	            fr.onloadend = function(e) {  
	                document.getElementById("mainImage").src = e.target.result;  
					
	            };  
	            fr.readAsDataURL(file);  
	        }  
	    } 
		</script>
	</jsp:attribute>
	<jsp:body>
		<form action="./" role="form" class="form-horizontal" method="post" enctype="multipart/form-data">
           <div class="form-group">
               <label for="shopName" class="col-sm-2 control-label">商家名称:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="shopName" placeholder="please input shopName">
               </div>
           </div>
           <div class="form-group">
               <label for="classifyId" class="col-sm-2 control-label">商家分类:</label>
               <div class="col-sm-10">
                   <select id="classifyId" name="classifyId" class="form-control">
               			<option value="0">请选择...</option>
               			<c:forEach items="${classifies }" var="classify">
               			<option value="${classify.id }">${classify.name }</option>
               			</c:forEach>
               		</select>
               </div>
           </div>
           <div class="form-group">
               <label for="description" class="col-sm-2 control-label">简介:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="description" placeholder="please input description">
               </div>
           </div>
           <div class="form-group">
               <label for="mainPic" class="col-sm-2 control-label">首页图片:</label>
               <div class="col-sm-10">
                   <a id="upload_mainpic" href="javascript:;" class="file">上传<input name='mainpicFile' type="file" onchange="addMainpic(this)" ></a><br>
                   <img id="mainImage" width="200" height="200">
               </div>
           </div>
           <div class="form-group">
               <label for="tagIds" class="col-sm-2 control-label">商家标签:</label>
               <div class="col-sm-10">
                   <c:forEach items="${tags }" var="tag">
	               	<input type="checkbox" name="tagIds" value="${tag.id }"/>
	               	${tag.name }
	               </c:forEach>
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