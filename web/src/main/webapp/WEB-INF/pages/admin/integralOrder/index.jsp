<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="integralOrder" subtab="integralOrder">
	<jsp:attribute name="script">
		<script id="template" type="text/html">
		{{each list as value i}}
			<tr id="{{value.id }}">
				 <td>{{value.orderNo}}</td>
                 <td>{{value.user.account }}</td>
                 <td>{{value.orderDate }}</td>
                 <td>{{if value.status=="00"}}未使用{{/if}}
                     {{if value.status=="01"}}已使用{{/if}}
                     {{if value.status=="10"}}待发货{{/if}}
                     {{if value.status=="11"}}已发货{{/if}}
                     {{if value.status=="12"}}已收货{{/if}}
                     {{if value.status=="20"}}已取消{{/if}}
                 </td>
                 <td><a href="<c:url value='/admin/integralOrder/{{value.id }}'/>">查看</a>
            </tr>
		{{/each}}
		</script>
		<script>
		var params="";
		$(function(){
			//初始化页面请求列表数据
			ajax('<c:url value="/admin/integralOrder/getlistdata"/>',null,"get",showList);
			//给输入框绑定回车事件
			$(document).on('keypress',"#search,#startDate,#endDate",function(event){
				if(event.keyCode == "13"){
					params="search="+$("#search").val()+"&startDate="+$("#startDate").val()+"&endDate="+$("#endDate").val();
					ajax('<c:url value="/admin/integralOrder/getlistdata"/>',params,"get",showList);
		        }
	        });

		});
		function showList(data){
			var html=template("template",data.data);
			$("tbody").html("");
			$("tbody").append(html);
			pagination(data.data.totalPages,data.data.size ,'<c:url value="/admin/integralOrder/getlistdata"/>',
					params,showList);
		}
		</script>
	</jsp:attribute>
	<jsp:body>
		<input id="search" name="search" placeholder="请输入订单编号或用户名" title="按回车查询"/>
		<input id="startDate" name="startDate" placeholder="请输入开始日期" title="格式：yyyy-MM-dd或yyyy-MM-dd hh:mm:ss"/>~
		<input id="endDate" name="endDate" placeholder="请输入结束日期" title="格式：yyyy-MM-dd或yyyy-MM-dd hh:mm:ss"/>
		<table class="table table-bordered text-center mgt-2">
            <thead>
                <tr>
                	<th>订单编号</th>
                    <th>用户</th>
                    <th>订单日期</th>
                    <th>订单状态</th>
                    <th>操作</th>
                </tr>
            </thead>                        
            <tbody>
            	
            </tbody>
        </table>
		<ul id="pagination"></ul>
	</jsp:body>
</my:admin>