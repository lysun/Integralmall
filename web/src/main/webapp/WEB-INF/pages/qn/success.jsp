<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>时尚女性服装调查问卷</title>
    <style>
        body {
            background-image: url(<c:url value="/resources/img/bg.png"/>);
            background-repeat: no-repeat;
            background-size: cover;
            font-size: 13px;
            color: white;
        }       
    </style>
</head>
<body>
    <div style="margin-top:15em">
    <h3 style="text-align:center">感谢您参与问卷调查，<br>代金券300元可在个人中心查收</h3>
    <img src="<c:url value='/resources/img/coupons.jpg'/>" style="display:block;width:100%;height:auto;">
    </div>
</body>
</html>