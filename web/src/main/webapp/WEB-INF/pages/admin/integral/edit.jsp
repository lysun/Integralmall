<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="integral" subtab="integral">
<jsp:body>
		<form action="./" role="form" class="form-horizontal" method="post">
          <div class="form-group">
               <label for="name" class="col-sm-2 control-label">用户账户:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="user.account" value="${t.user.account }" readonly="readonly">
               </div>
           </div>
           <div class="form-group">
               <label for="code" class="col-sm-2 control-label">积分:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="totalcount" value="${t.totalcount }" placeholder="please input totalcount">
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