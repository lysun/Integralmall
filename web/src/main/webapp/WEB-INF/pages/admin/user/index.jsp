<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="user">
<jsp:attribute name="nav">
		<my:user-nav tab="user"></my:user-nav>
	</jsp:attribute>
	<jsp:attribute name="script">
	<script id="template" type="text/html">
		{{each list as value i}}
			<tr id="{{value.id }}">
                 <td>{{value.username }}</td>
                 <td><a href="<c:url value='/admin/user/{{value.id }}/edit'/>">修改</a>|
                     <a href="<c:url value='/admin/user/{{value.id }}'/>">查看</a>|
                     <a onclick="del('<c:url value="/admin/user"/>','{{value.id }}')">删除</a>
                 </td>
            </tr>
		{{/each}}
		</script>
		<script>
			$(function(){
				ajax('<c:url value="/admin/user/getlist"/>',null,"get",showList);
			});

			function showList(data){
				var html=template("template",data.data);
				$("tbody").html("");
				$("tbody").append(html);
				//初始化分页
				pagination(data.data.totalPages,data.data.size,'<c:url value="/admin/user/getlist"/>',
						null,showList);
			}
		</script>
	</jsp:attribute>
	<jsp:body>
	<button class="btn btn-default" onclick="window.location.href='<c:url value="/admin/user/add"/>'">添加</button>
		<table class="table table-bordered text-center mgt-2">
            <thead>
                <tr>
                    <th>用户名</th>
                    <th>操作</th>
                </tr>
            </thead>                        
            <tbody>
            	
            </tbody>
        </table>
		<ul id="pagination"></ul>
	</jsp:body>
</my:admin>