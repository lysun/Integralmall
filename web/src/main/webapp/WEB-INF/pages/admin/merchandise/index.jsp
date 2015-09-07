<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %> 
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="merchandise">
	<jsp:attribute name="nav">
		<my:merchandise-nav tab="shelve"></my:merchandise-nav>
	</jsp:attribute>
	<jsp:attribute name="script">
		<script id="template" type="text/html">
		{{each list as value i}}
			<tr id="{{value.id }}">
                 <td>{{value.seq }}</td>
                 <td>{{value.name }}</td>
                 <td>{{value.integralCount }}</td>
                 <td>{{value.stock }}</td>
                 <td>{{if value.classifyDto}}{{value.classifyDto.name }}{{/if}}</td>
                 <td>{{if value.brandDto}}{{value.brandDto.name }}{{/if}}</td>
                 <td>{{if value.type=='0'}}<a href="<c:url value='/admin/merchandise/coupon/{{value.id }}'/>">查看</a>{{/if}}{{if value.type=='1'}}<a href="<c:url value='/admin/merchandise/gift/{{value.id }}'/>">查看</a>{{/if}}|
                     {{if value.type=='0'}}<a href="<c:url value='/admin/merchandise/coupon/{{value.id }}/edit'/>">修改</a>{{/if}}{{if value.type=='1'}}<a href="<c:url value='/admin/merchandise/gift/{{value.id }}/edit'/>">修改</a>{{/if}}|
                 <a onclick="unshelve('{{value.id }}')">下架</a></td>
            </tr>
		{{/each}}
		</script>
		<script>
		var params="";
		$(function(){
			//初始化页面请求列表数据
			ajax('<c:url value="/admin/merchandise/getlistdata"/>',null,"get",showList);
	        $("#search").keypress(function(event){
	        	if(event.keyCode == "13"){//输入框回车事件
	        		$("#orderByUpdateTime").attr("class","btn btn-default");
					$("#orderByStock").attr("class","btn btn-default");
					$("#orderByIntegral").attr("class","btn btn-default");
					params="search="+$("#search").val();
					ajax('<c:url value="/admin/merchandise/getlistdata"/>',params,"get",showList);
		        }
		    });
			$("#doSearch").click(function(){
				$("#orderByUpdateTime").attr("class","btn btn-default");
				$("#orderByStock").attr("class","btn btn-default");
				$("#orderByIntegral").attr("class","btn btn-default");
				params="search="+$("#search").val();
				ajax('<c:url value="/admin/merchandise/getlistdata"/>',params,"get",showList);
			});
			//排序
			$("#orderByUpdateTime").click(function(){
				if($("#orderByUpdateTime").attr("class")=="btn btn-default"){
					$("#orderByUpdateTime").attr("class","btn btn-info");
					$("#orderByStock").attr("class","btn btn-default");
					$("#orderByIntegral").attr("class","btn btn-default");
					params="search="+$("#search").val()+"&orderBy=updateTime"+"&seq=DESC";
					ajax('<c:url value="/admin/merchandise/getlistdata"/>',params,"get",showList);
				}else{
					$("#orderByUpdateTime").attr("class","btn btn-default");
				}
			});
			$("#orderByStock").click(function(){
				if($("#orderByStock").attr("class")=="btn btn-default"){
					$("#orderByStock").attr("class","btn btn-info");
					$("#orderByUpdateTime").attr("class","btn btn-default");
					$("#orderByIntegral").attr("class","btn btn-default");
					params="search="+$("#search").val()+"&orderBy=stock"+"&seq=DESC";
					ajax('<c:url value="/admin/merchandise/getlistdata"/>',params,"get",showList);
					pagination('${page.totalPages }','${page.size }','<c:url value="/admin/merchandise/getlistdata"/>',
							params,showList);
				}else{
					$("#orderByStock").attr("class","btn btn-default");
				}
			});
			$("#orderByIntegral").click(function(){
				if($("#orderByIntegral").attr("class")=="btn btn-default"){
					$("#orderByIntegral").attr("class","btn btn-info");
					$("#orderByStock").attr("class","btn btn-default");
					$("#orderByUpdateTime").attr("class","btn btn-default");
					params="search="+$("#search").val()+"&orderBy=integralCount"+"&seq=DESC";
					ajax('<c:url value="/admin/merchandise/getlistdata"/>',params,"get",showList);
				}else{
					$("#orderByIntegral").attr("class","btn btn-default");
				}
			});
		});
		function showList(data){
			var html=template("template",data.data);
			$("tbody").html("");
			$("tbody").append(html);
			//初始化分页
			pagination(data.data.totalPages,data.data.size,'<c:url value="/admin/merchandise/getlistdata"/>',
					params,showList);
		}
		//将商品下架
		function unshelve(id) {
			bootbox.confirm("确定下架吗？",
					function(result){
				if(!result)return;
				$.ajax({
			        url:"<c:url value='/admin/merchandise/unshelve/"+id+"'/>",
			        type:"PUT",
			        success:function() {
			            $("#"+id).remove();
			        },
			        error:function() {
			            alert("下架失败！");
			        }
			    });
			});    
		}
		</script>
	</jsp:attribute>
	<jsp:body>
		<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			      添加<span class="caret"></span></button>
		   <ul class="dropdown-menu" role="menu">
		      <li><a href="<c:url value="/admin/merchandise/coupon/add"/>">优惠券</a></li>
		      <li><a href="<c:url value="/admin/merchandise/gift/add"/>">实物商品</a></li>
		   </ul>
	    </div>
		<button id="orderByUpdateTime" class="btn btn-default">按照更新时间</button>
		<button id="orderByStock" class="btn btn-default">按照商品库存倒序</button>
		<button id="orderByIntegral" class="btn btn-default">按照所需积分</button>
		<input id="search" name="search" placeholder="请输入商品名称"/><button id="doSearch" class="btn btn-default">查询</button>
		<table class="table table-bordered text-center mgt-2">
            <thead>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>所需积分</th>
                    <th>库存</th>
                    <th>商品分类</th>
                    <th>商品品牌</th>
                    <th>操作</th>
                </tr>
            </thead>                        
            <tbody>
            	
            </tbody>
        </table>
		<ul id="pagination"></ul>
	</jsp:body>
</my:admin>