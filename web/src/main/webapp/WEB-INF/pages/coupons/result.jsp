<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>优惠券查询</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <style>
        .mgt-1 {
            margin-top: 1em;
        }
    </style>
</head>
<body>
    <div class="container" style="margin-top:10%">
    <form class="form-horizontal" role="form" action="use" method="post">
       <div class="form-group">
          <label class="control-label col-sm-2" for="account">手机号码：</label>
            <div class="col-sm-10">
            <input type="tel" class="form-control" name="account" value="${account }"
             readonly>
            </div>
       </div>
       <div class="form-group mgt-1">
          <label class="control-label col-sm-2" for="type">优惠类型：</label>
           <div class="col-sm-10">
              <input type="hidden" name="type" value="${type }">
              <p class="form-control">${type }</p>
           </div>
       </div>
        <div class="form-group mgt-1">
          <label class="control-label col-sm-2" for="type">状态：</label>
           <div class="col-sm-10">
              <p class="form-control"><c:if test="${hasUsed }">已使用</c:if><c:if test="${!hasUsed }">未使用</c:if></p>
           </div>
       </div>
       <c:if test="${!hasUsed }">
       <div class="form-group mgt-1">
          <div class="col-sm-offset-2 col-sm-10">
             <button type="submit" class="btn btn-default">使用</button>
          </div>
       </div>
       </c:if>
    </form>
    </div>
</body>
</html>