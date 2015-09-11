<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="integral" subtab="integral">
	<jsp:attribute name="script">
	<script id="template" type="text/html">
		{{each list as value i}}
			<tr id="{{value.id }}">
                 <td>{{value.user.account }}</td>
                 <td>{{value.totalcount }}</td>
                 <td><a href="<c:url value='/admin/integral/{{value.id }}/edit'/>">修改</a>|
                     <a href="<c:url value='/admin/integral/{{value.id }}'/>">查看</a>|
                     <a onclick="del('<c:url value="/admin/integral"/>','{{value.id }}')">删除</a>
                 </td>
            </tr>
		{{/each}}
		</script>
		<script>
		var params;
		$(function(){
			ajax('<c:url value="/admin/integral/getlistdata"/>',null,"get",showList);
			$("#search").keypress(function(event){
				if(event.keyCode==13){
					params="search="+$("#search").val();
					ajax('<c:url value="/admin/integral/getlistdata"/>',params,"get",showList);
				}
			});
			
		});
		function showList(data){
			var html=template("template",data.data);
			$("tbody").html("");
			$("tbody").append(html);
			//初始化分页
			pagination(data.data.totalPages,data.data.size,'<c:url value="/admin/integral/getlistdata"/>',
					params,showList);
		}
		</script>
	</jsp:attribute>
	<jsp:body>
	<button class="btn btn-default" onclick="window.location.href='<c:url value="/admin/integral/add"/>'">添加</button>
		账户：<input id="search" value=""/>
		<table class="table table-bordered text-center mgt-2">
            <thead>
                <tr>
                    <th>账户</th>
                    <th>积分</th>
                    <th>操作</th>
                </tr>
            </thead>                        
            <tbody>
            	
            </tbody>
        </table>
		<ul id="pagination"></ul>
	</jsp:body>
</my:admin>