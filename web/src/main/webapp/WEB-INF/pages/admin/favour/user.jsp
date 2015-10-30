<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="favour" subtab="user">
	<jsp:attribute name="script">
		<script id="template" type="text/html">
		{{each list as value i}}
			<tr id="{{value.id }}">
                 <td>{{value.telephone }}</td>
                 <td>{{value.count }}</td>
            </tr>
		{{/each}}
		</script>
		<script>
		
		var params="";
		$(function(){
			//初始化页面请求列表数据
			ajax('<c:url value="/admin/favour/user/getdata"/>',null,"get",showList);
			//给输入框绑定回车事件
			$(document).on('keypress',"#search",function(event){
				if(event.keyCode == "13"){
					params="search="+$("#search").val();
					ajax('<c:url value="/admin/favour/user/getdata"/>',params,"get",showList);
		        }
	        });

		});
		function showList(data){
			var html=template("template",data.data);
			$("tbody").html("");
			$("tbody").append(html);
			pagination(data.data.totalPages,data.data.size ,'<c:url value="/admin/favour/user/getdata"/>',
					params,showList);
		}
		</script>
	</jsp:attribute>
	<jsp:body>
		<input id="search" name="search" placeholder="请输入用户手机号" title="按回车查询"/>
		<table class="table table-bordered text-center mgt-2">
            <thead>
                <tr>
                	<th>用户</th>
                    <th>点赞数</th>
                </tr>
            </thead>                        
            <tbody>
            	
            </tbody>
        </table>
		<ul id="pagination"></ul>
	</jsp:body>
</my:admin>