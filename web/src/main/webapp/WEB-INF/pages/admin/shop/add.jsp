<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="shop" subtab="shop">
	<jsp:attribute name="script">
		<script>
		$(function(){
			//给图片添加事件
			$(document).on("change","input[name='mainpicFile']",function(){
				if(validateImage(this)){
	            	showImage(document.getElementById("mainImage"),this.files[0]);
	            }
			});
		});

		function validate(){
			if($("#shopName").val()==""){
				alert('商户名称不能为空!');
	        	return false;
			}
			if(typeof($("#mainImage").attr("src"))=="undefined"){
				alert('请上传主图!');
	        	return false;
	        }else if(!validateImageFiveToThree($("#mainImage").get(0))){//验证图片宽高比例
				return false;
		    }
		    return true;
		}
		</script>
	</jsp:attribute>
	<jsp:body>
		<form action="./" role="form" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return validate()">
            <div class="form-group">
               <label for="num" class="col-sm-2 control-label">商户编号:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="num" placeholder="please input shopName">
               </div>
           </div>
           <div class="form-group">
               <label for="shopName" class="col-sm-2 control-label">商户名称:</label>
               <div class="col-sm-10">
                   <input id="shopName" class="form-control" name="shopName" placeholder="please input shopName">
               </div>
           </div>
           <div class="form-group">
               <label for="classifyId" class="col-sm-2 control-label">商户类别:</label>
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
               <textarea name="description" style="resize:none;height:150px;width:100%;"></textarea>
               </div>
           </div>
           <div class="form-group">
               <label for="mainPic" class="col-sm-2 control-label">首页图片:</label>
               <div class="col-sm-10">
                   <a id="upload_mainpic" href="javascript:;" class="file">上传<input name='mainpicFile' type="file" ></a><br>
                   <img id="mainImage" height='200'>
               </div>
           </div>
           <div class="form-group">
               <label for="integral" class="col-sm-2 control-label">可分配积分:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="integral" placeholder="please input integral">
               </div>
           </div>
           <div class="form-group">
               <label for="tagIds" class="col-sm-2 control-label">商家标签:</label>
               <div class="col-sm-10">
                  <input class="form-control" name="tagName" placeholder="标签之间用空格隔开">
               </div>
           </div>
            
           <div class="form-group">
			   <div class="col-sm-offset-2 col-sm-10">
			      <button id="submit" class="btn btn-default">保存</button>
			   </div>
			</div>
       </form>
	</jsp:body>
</my:admin>