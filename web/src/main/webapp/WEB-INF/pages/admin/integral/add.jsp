<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="integral" subtab="integral">
	<jsp:attribute name="script">
		<script>
		function validate(){
			var account=$("#account").val();
			if(account==""){
				alert('账户不能为空!');
	        	return false;
			}
			if($("#totalcount").val()==""){
				alert('积分不能为空!');
	        	return false;
			}
			var flag=false;
			$.ajax({
				url:"<c:url value='/admin/integral/validateAccount'/>",
				data:{account:account},
				type:"get",
				dataType:"json",
				success:function(data){
					if(data.errcode!="0"){
						alert(data.errmsg);
						flag=false;
					}else{
						flag=true;
					}
				},
				async:false//同步等待验证结果
			});
		    return flag;
		}
		</script>
	</jsp:attribute>
	<jsp:body>
		<form action="./" role="form" class="form-horizontal" method="post" onsubmit="return validate()">
           <div class="form-group">
               <label for="name" class="col-sm-2 control-label">账户:</label>
               <div class="col-sm-10">
                   <input class="form-control" id="account" name="user.account">
               </div>
           </div>
           <div class="form-group">
               <label for="code" class="col-sm-2 control-label">积分:</label>
               <div class="col-sm-10">
                   <input class="form-control" id="totalcount" name="totalcount" placeholder="please input totalcount">
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