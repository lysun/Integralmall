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
    <form class="form-horizontal" role="form" action="result" method="post">
       <div class="form-group">
          <label class="control-label col-sm-2" for="account">手机号码：</label>
            <div class="col-sm-10">
            <input type="tel" class="form-control" id="account" name=account
             placeholder="请输入手机号码" required>
            </div>
       </div>
       <div class="form-group mgt-1">
          <label class="control-label col-sm-2" for="type">优惠类型：</label>
           <div class="col-sm-10">
          <select name="type" class="form-control">
              <option value="代金券">代金券</option>
              <option value="折扣">折扣</option>
          </select>
           </div>
       </div>
       <div class="form-group mgt-1">
          <div class="col-sm-offset-2 col-sm-10">
             <button type="submit" class="btn btn-default">查看</button>
          </div>
       </div>
    </form>
    </div>
</body>
</html>