<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no" />
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
        .error {
        	color:pink;
        }
    </style>
</head>
<body>
    <h2 style="text-align:center">时尚女性服装调查问卷</h2>
    <p>您好，欢迎您加尚活一族，您只需要两分钟填写以下问题，即可获得吉芬专柜代金券￥300，谢谢您的参与！</p>
    <form method="post" id="form">
    	<input type="hidden" name="userId" value="${userId }">
        <div>
        <label>1.您的姓名:</label><input name="name" type="text" required="required">
        </div>
        
        <div class="itv">
        <label class="cr">2.您的年龄:</label>
        <c:forEach items="${items.age }" var="age">
        	<label><input required name="age" type="radio" value="${age }" />${age }</label>
        </c:forEach>
        <label for="age" class="error"></label>
        </div>
        
        <div class="itv">
        <label class="cr">3.您的职业:</label>
        <c:forEach items="${items.occupation}" var="occupation">
        	<label><input required name="occupation" type="radio" value="${occupation }" />${occupation }</label>
        </c:forEach>
        <label for="occupation" class="error"></label>
        </div>
        
        <div class="itv">
        <label class="cr">4.您喜欢的颜色:</label>
        <c:forEach items="${items.color}" var="color" varStatus="status">
        	<label><input <c:if test="${status.first }">required</c:if> name="color" type="checkbox" value="${color }" />${color }</label>
        </c:forEach>
        <label for="color" class="error"></label>
        </div>
        
        <div class="itv">
        <label class="cr">5.您平时的尺码:</label>
        <c:forEach items="${items.size}" var="size">
        	<label><input required name="size" type="radio" value="${size }" />${size }</label>
        </c:forEach>
        <label for="size" class="error"></label>
        </div>
        
        <div class="itv">
        <label class="cr">6.您喜欢的上衣:</label>
        <c:forEach items="${items.shirt}" var="shirt" varStatus="status">
        	<label><input <c:if test="${status.first }">required</c:if> name="shirt" type="checkbox" value="${shirt }" />${shirt }</label>
        </c:forEach>
        <label for="shirt" class="error"></label>
        </div>
        
        <div class="itv">
        <label class="cr">7.您喜欢的裙装:</label>
        <c:forEach items="${items.skirt}" var="skirt" varStatus="status">
        	<label><input <c:if test="${status.first }">required</c:if> name="skirt" type="checkbox" value="${skirt }" />${skirt }</label>
        </c:forEach>
        <label for="skirt" class="error"></label>
        </div>
        
        <div class="itv">
        <label class="cr">8.您喜欢的裤装:</label>
        <c:forEach items="${items.pants}" var="pants" varStatus="status">
        	<label><input <c:if test="${status.first }">required</c:if> name="pants" type="checkbox" value="${pants }" />${pants }</label>
        </c:forEach>
        <label for="pants" class="error"></label>
        </div>
        
        <div class="itv">
        <label class="cr">9.您喜欢的风格:</label>
        <c:forEach items="${items.style}" var="style" varStatus="status">
        	<label><input <c:if test="${status.first }">required</c:if> name="style" type="checkbox" value="${style }" />${style }</label>
        </c:forEach>
        <label for="style" class="error"></label>
        </div>
        
        <div class="itv">
        <label class="cr wbn">10.您比较能接受的服装价格，比如一件普通的女士外套？:</label>
        <c:forEach items="${items.price}" var="price">
        	<label><input required name="price" type="radio" value="${price }" />${price }</label>
        </c:forEach>
        <label for="price" class="error"></label>
        </div>
        <button class="center mgt-1" type="submit"><h3>同意并提交√</h3></button>
    </form>
    <script src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-validate/1.14.0/jquery.validate.min.js"></script>
    <script>
        jQuery.extend(jQuery.validator.messages, {
            required: "必选字段",
            remote: "请修正该字段",
            email: "请输入正确格式的电子邮件",
            url: "请输入合法的网址",
            date: "请输入合法的日期",
            dateISO: "请输入合法的日期 (ISO).",
            number: "请输入合法的数字",
            digits: "只能输入整数",
            creditcard: "请输入合法的信用卡号",
            equalTo: "请再次输入相同的值",
            accept: "请输入拥有合法后缀名的字符串",
            maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
            minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
            rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
            range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
            max: jQuery.validator.format("请输入一个最大为{0} 的值"),
            min: jQuery.validator.format("请输入一个最小为{0} 的值")
        });
        $("#form").validate();
    </script>
</body>
</html>