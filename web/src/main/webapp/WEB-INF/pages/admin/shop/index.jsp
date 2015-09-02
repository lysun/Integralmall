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
	<script id="template" type="text/html">
		{{each result as value i}}
			<tr id="{{value.id }}">
                 <td>{{value.num }}</td>
                 <td>{{value.shopName }}</td>
                 <td>0</td>
                 <td>0</td>
                 <td>{{value.integral }}</td>
                 <td><a href="<c:url value='/admin/shop/{{value.id }}/branch/add'/>">添加分店</a>|
                     <a href="<c:url value='/admin/shop/{{value.id }}/edit'/>">修改</a>|
                     <a href="<c:url value='/admin/shop/{{value.id }}'/>">查看</a>|
                     <a onclick="del('<c:url value="/admin/shop"/>','{{value.id }}')">删除</a>
                 </td>
            </tr>
		{{/each}}
		</script>
		<script>
			var params;
			$(function(){
				ajax('<c:url value="/admin/shop/getlistdata"/>',null,"get",showList);
				$("#search").keypress(function(event){
					if(event.keyCode==13){
						params="search="+$("#search").val();
						ajax('<c:url value="/admin/shop/getlistdata"/>',params,"get",showList);
					}
				});
				
			});

			function showList(data){
				var html=template("template",data.data);
				$("tbody").html("");
				$("tbody").append(html);
				//初始化分页
				pagination(data.data.totalPages,data.data.size,'<c:url value="/admin/shop/getlistdata"/>',
						params,showList);
			}
		</script>
	</jsp:attribute>
	<jsp:body>
	编号：<input id="search" value=""/>
	<button class="btn btn-default" onclick="window.location.href='<c:url value="/admin/shop/add"/>'">添加</button>
		<table class="table table-bordered text-center mgt-2">
            <thead>
                <tr>
                    <th>渠道编号</th>
                    <th>渠道名称</th>
                    <th>注册会员数</th>
                    <th>消费总额</th>
                    <th>可分配积分</th>
                    <th>操作</th>
                </tr>
            </thead>                        
            <tbody>
            	
            </tbody>
        </table>
		<ul id="pagination"></ul>
	</jsp:body>
</my:admin>