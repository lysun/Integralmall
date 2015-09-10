<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="shop">
<jsp:attribute name="nav">
		<my:shop-nav tab="shop"></my:shop-nav>
	</jsp:attribute>
	<jsp:attribute name="script">
		<script>
		$(function(){
			loadScript();
			//input事件监听
			if(/msie/i.test(navigator.userAgent)) {//ie浏览器
				document.getElementById('address').onpropertychange=handle;
			}else{//非ie浏览器，比如Firefox 
				//firefox下检测状态改变只能用oninput,且需要用addEventListener来注册事件。 
				document.getElementById('address').addEventListener("input",handle,false); 
			}
			
		});
		//地址输入框的内容发生改变时发生的事件
		function handle(){
			var input=document.getElementById('address').value;
			//根据输入的内容进行搜索，搜索的结果有标注和批注信息
			var local = new BMap.LocalSearch(map, {renderOptions:{map: map}});
			local.search(input);
		}


		function validate(){
			if($("#name").val()==""){
				alert('分店名称不能为空!');
		        return false;
			}
			if($("#address").val()==""){
				alert('地址不能为空!');
		        return false;
			}
			if($("#point").html().trim()==""||$("#longitude").val()==""||$("#latitude").val()==""){
				alert('请选择位置');
		        return false;
			}
		}
		</script>
	</jsp:attribute>
<jsp:body>
		<form action="./" role="form" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return validate()">
           <div class="form-group">
               <label for="num" class="col-sm-2 control-label">分店编号:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="num"  placeholder="please input shopName">
               </div>
           </div>
           <div class="form-group">
               <label for="shopName" class="col-sm-2 control-label">分店名称:</label>
               <div class="col-sm-10">
                   <input id="name" class="form-control" name="name"  placeholder="please input name">
               </div>
           </div>
                      <div class="form-group">
               <label for="contact" class="col-sm-2 control-label">联系人:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="contact"   placeholder="please input contact">
               </div>
           </div>
           <div class="form-group">
               <label for="tel" class="col-sm-2 control-label">联系电话:</label>
               <div class="col-sm-10">
                  <input class="form-control" name="tel"  placeholder="please input tel">
               </div>
           </div>
           <div class="form-group">
               <label for="address" class="col-sm-2 control-label">地址:</label>
               <div class="col-sm-10">
                   <input id="address" class="form-control" name="address" placeholder="请输入商品的地址">
               </div>
           </div>
           <div class="form-group">
               <label for="description" class="col-sm-2 control-label">位置:</label>
               <div class="col-sm-10">
                   <input id="longitude" type="hidden" class="form-control" name="longitude">
                   <input id="latitude" type="hidden" class="form-control" name="latitude">
                   <p id="point" class="form-control"></p><span>点击地图选择具体位置</span>
                   <div id="map" style="width:100%;height:600px"></div>
               </div>
           </div>
           <div class="form-group">
			   <div class="col-sm-offset-2 col-sm-10">
			      <button id="submit" class="btn btn-default">保存</button>
			   </div>
			</div>
       </form>
  </jsp:body>
</my:admin>