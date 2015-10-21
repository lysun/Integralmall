<%@ page language="java" contentType="text/html; charset=UTF-8"
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
            padding-left: 5%;
            padding-right: 5%;
        }
        h3 {
            color: white;
        }
        button {
            border:none;
            background-color: transparent;
        }
        label {
            word-break: keep-all;
            display: inline-block;
            margin-top: 0.4em;
        }
        .wbn {
            word-break: normal;
        }
        .cr {
            display: block;
        }
        .itv {
            margin-top: 0.8em;
        }
        .center {
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
        .mgt-1 {
            margin-top: 1em;
        }
        .mgt-2 {
            margin-top: 2em;
        }        
    </style>
</head>
<body>
    <h2>时尚女性服装调查问卷</h2>
    <p>您好，欢迎您加尚活一族，您只需要两分钟填写以下问题，即可获得吉芬专柜代金券￥300，谢谢您的参与！</p>
    <form method="post">
    	<input type="hidden" name="userId" value="${userId }">
        <div>
        <label>1.您的姓名:</label><input name="name" type="text" required="required">
        </div>
        
        <div class="itv">
        <label class="cr">2.您的年龄:</label>
        <c:forEach items="${items.age }" var="age">
        	<label><input required="required" name="age" type="radio" value="${age }" />${age }</label>
        </c:forEach>
        </div>
        
        <div class="itv">
        <label class="cr">3.您的职业:</label>
        <c:forEach items="${items.occupation}" var="occupation">
        	<label><input name="occupation" type="checkbox" value="${occupation }" />${occupation }</label>
        </c:forEach>
        </div>
        
        <div class="itv">
        <label class="cr">4.您喜欢的颜色:</label>
        <c:forEach items="${items.color}" var="color">
        	<label><input name="color" type="checkbox" value="${color }" />${color }</label>
        </c:forEach>
        </div>
        
        <div class="itv">
        <label class="cr">5.您平时的尺码:</label>
        <c:forEach items="${items.size}" var="size">
        	<label><input required="required" name="size" type="radio" value="${size }" />${size }</label>
        </c:forEach>
        </div>
        
        <div class="itv">
        <label class="cr">6.您喜欢的上衣:</label>
        <c:forEach items="${items.shirt}" var="shirt">
        	<label><input name="shirt" type="checkbox" value="${shirt }" />${shirt }</label>
        </c:forEach>
        </div>
        
        <div class="itv">
        <label class="cr">7.您喜欢的裙装:</label>
        <c:forEach items="${items.skirt}" var="skirt">
        	<label><input name="skirt" type="checkbox" value="${skirt }" />${skirt }</label>
        </c:forEach>
        </div>
        
        <div class="itv">
        <label class="cr">8.您喜欢的裤装:</label>
        <c:forEach items="${items.pants}" var="pants">
        	<label><input name="pants" type="checkbox" value="${pants }" />${pants }</label>
        </c:forEach>
        </div>
        
        <div class="itv">
        <label class="cr">9.您喜欢的风格:</label>
        <c:forEach items="${items.style}" var="style">
        	<label><input name="style" type="checkbox" value="${style }" />${style }</label>
        </c:forEach>
        </div>
        
        <div class="itv">
        <label class="cr wbn">10.您比较能接受的服装价格，比如一件普通的女士外套？:</label>
        <c:forEach items="${items.price}" var="price">
        	<label><input required="required" name="price" type="radio" value="${price }" />${price }</label>
        </c:forEach>
        </div>
        <button class="center mgt-1" type="submit"><h3>同意并提交√</h3></button>
    </form>
</body>
</html>