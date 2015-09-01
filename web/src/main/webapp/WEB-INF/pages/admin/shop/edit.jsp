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
	    function deleteBranch(branchId){
		    ajax("<c:url value='/admin/shop/${t.id}/branch/"+branchId+"'/>",null,"delete",function(data){
		    	if(data.errcode=="0"){
	        		$("#"+branchId).remove();
	        	}else{
	        		alert("删除失败");
	        	}
			    });

		    }
		</script>
	</jsp:attribute>
	<jsp:body>
		<form action="./" role="form" class="form-horizontal" method="post" enctype="multipart/form-data" enctype="multipart/form-data">
          <div class="form-group">
               <label for="num" class="col-sm-2 control-label">商户编号:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="num" value="${t.num }" placeholder="please input shopName">
               </div>
           </div>
           <div class="form-group">
               <label for="shopName" class="col-sm-2 control-label">商家名称:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="shopName" value="${t.shopName }" placeholder="please input shopName">
               </div>
           </div>
           <div class="form-group">
               <label for="classifyId" class="col-sm-2 control-label">商家分类:</label>
               <div class="col-sm-10">
                   <select id="classifyId" name="classifyId" class="form-control">
               			<option value="0">请选择...</option>
               			<c:forEach items="${classifies }" var="classify">
               			<option value="${classify.id }" <c:if test="${classify.id eq t.classifyDto.id}">selected</c:if>>${classify.name }</option>
               			</c:forEach>
               		</select>
               </div>
           </div>
           <div class="form-group">
               <label for="description" class="col-sm-2 control-label">简介:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="description" value="${t.description }" placeholder="please input description">
               </div>
           </div>
           <div class="form-group">
               <label for="mainPic" class="col-sm-2 control-label">首页图片:</label>
               <div class="col-sm-10">
                   <a id="upload_mainpic" href="javascript:;" class="file">上传<input name='mainpicFile' type="file" onchange="addMainpic(this)" ></a><br>
                   <img id="mainImage" width="200" height="200" src="${t.mainPicDto.url}">
               </div>
           </div>
           <div class="form-group">
               <label for="integral" class="col-sm-2 control-label">可分配积分:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="integral" value="${t.integral }"  placeholder="please input integral">
               </div>
           </div>
           <div class="form-group">
               <label for="classifyId" class="col-sm-2 control-label">商家标签:</label>
               <div class="col-sm-10">
               <input class="form-control" name="tagName" placeholder="标签之间用空格隔开"
               value='<c:forEach items="${t.tags}" var="tag">${tag.name } </c:forEach>' />
               </div>
           </div>
           <div class="form-group">
               <label for="classifyId" class="col-sm-2 control-label">分店信息:</label>
               <div class="col-sm-10">
                <c:forEach items="${t.branchs }" var="branch">
		           <div id="${branch.id }" class="panel panel-default">
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
						 <button type="button" class="btn btn-default btn-xs"
						      onclick="window.location.href='<c:url value="/admin/shop/${t.id }/branch/${branch.id}/edit"/>'">编辑</button>
						 <button type="button" class="btn btn-default btn-xs"
						      onclick="deleteBranch('${branch.id}')" >删除</button>
					   </div>
					</div>
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