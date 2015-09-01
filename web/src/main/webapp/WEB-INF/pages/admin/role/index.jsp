<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="user">
<jsp:attribute name="nav">
		<my:user-nav tab="role"></my:user-nav>
	</jsp:attribute>
	<jsp:attribute name="script">
	<script id="template" type="text/html">
		{{each result as value i}}
			<tr id="{{value.id }}">
                 <td>{{value.name }}</td>
                 <td>{{value.code }}</td>
                 <td>{{value.type }}</td>
                 <td>
                     {{if value.type=='MENU'}}<a href="<c:url value='/admin/role/menu/{{value.id }}/edit'/>">修改</a>{{/if}}
                     {{if value.type=='PERM'}}<a href="<c:url value='/admin/role/perm/{{value.id }}/edit'/>">修改</a>{{/if}}|
                     {{if value.type=='MENU'}}<a href="<c:url value='/admin/role/menu/{{value.id }}'/>">查看</a>{{/if}}
                     {{if value.type=='PERM'}}<a href="<c:url value='/admin/role/perm/{{value.id }}'/>">查看</a>{{/if}}|
                     <a onclick="del('<c:url value="/admin/role"/>','{{value.id }}')">删除</a>
                 </td>
            </tr>
		{{/each}}
		</script>
		<script>
			$(function(){
				ajax('<c:url value="/admin/role/getlist"/>',null,"get",showList);
			});

			function showList(data){
				var html=template("template",data.data);
				$("tbody").html("");
				$("tbody").append(html);
				//初始化分页
				pagination(data.data.totalPages,data.data.size,'<c:url value="/admin/role/getlist"/>',
						null,showList);
			}
		</script>
	</jsp:attribute>
	<jsp:body>
	<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			      添加<span class="caret"></span></button>
		   <ul class="dropdown-menu" role="menu">
		      <li><a href="<c:url value="/admin/role/menu/add"/>">菜单角色</a></li>
		      <li><a href="<c:url value="/admin/role/perm/add"/>">权限角色</a></li>
		   </ul>
	    </div>

		<table class="table table-bordered text-center mgt-2">
            <thead>
                <tr>
                    <th>角色名</th>
                    <th>角色代码</th>
                    <th>角色类别</th>
                    <th>操作</th>
                </tr>
            </thead>                        
            <tbody>
            	
            </tbody>
        </table>
		<ul id="pagination"></ul>
	</jsp:body>
</my:admin>