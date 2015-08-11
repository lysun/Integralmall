<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="integral">
	<jsp:attribute name="nav">
		<my:integral-nav tab="merchandise"></my:integral-nav>
	</jsp:attribute>
	<jsp:attribute name="script">
		<script>
		var map;
		function initialize() {
			map = new BMap.Map('map');
			if('${t.longitude}'!=""&&'${t.latitude}'!=""){
				var point=new BMap.Point('${t.longitude}','${t.latitude}');
				map.centerAndZoom(point, 14);
				var marker = new BMap.Marker(point); //创建标注
				map.clearOverlays();//清除所有覆盖物(标注)
				map.addOverlay(marker);
			}else{
				map.centerAndZoom("北京");
			}
			map.enableScrollWheelZoom();//启动鼠标滚轮操作
			//添加控件
			var opts={type:BMAP_NAVIGATION_CONTROL_ZOOM};//设置左侧调节栏的样式
			map.addControl(new BMap.NavigationControl(opts));//左侧调节栏
			map.addControl(new BMap.ScaleControl());//测量尺
			
		}
		//添加script标签
		function loadScript() {
			var script = document.createElement("script");
			script.src = "http://api.map.baidu.com/api?v=1.4&callback=initialize";
			document.body.appendChild(script);
		}
		window.onload = loadScript;

		$(function(){
			if('${t.isActual}'=='1'){
				$("#expiryTime").val("");
				$("#point").text("");
				$("#address").val("");
				$("#expiryTime").parent().parent().attr("style","display:none");
				$("#address").parent().parent().attr("style","display:none");
				$("#point").parent().parent().attr("style","display:none");
				$("#shopName").parent().parent().attr("style","display:none");
			}else{
				$("#price").parent().parent().attr("style","display:none");
			}
		});
		</script>
	
	</jsp:attribute>
	<jsp:body>
		<form role="form" class="form-horizontal" method="post">
           <div class="form-group">
               <label for="seq" class="col-sm-2 control-label">编号:</label>
               <div class="col-sm-10">
                    <p class="form-control">${t.seq }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="classify" class="col-sm-2 control-label">商品分类:</label>
               <div class="col-sm-10">
                    <p class="form-control">${t.classifyDto.name }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="brand" class="col-sm-2 control-label">商品品牌:</label>
               <div class="col-sm-10">
                    <p class="form-control">${t.brandDto.name }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="name" class="col-sm-2 control-label">商品名称:</label>
               <div class="col-sm-10">
                    <p class="form-control">${t.name }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="name" class="col-sm-2 control-label">商户名称:</label>
               <div class="col-sm-10">
                   <p id="shopName" class="form-control">${t.shopName }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="isActual" class="col-sm-2 control-label">是否实物商品:</label>
               <div class="col-sm-10">
               <p class="form-control">
               		<c:if test="${t.isActual eq '0'}">否</c:if>
               	   	<c:if test="${t.isActual eq '1'}">是</c:if>
               	   </p>
               </div>
           </div>
           <div class="form-group">
               <label for="integralCount" class="col-sm-2 control-label">所需积分:</label>
               <div class="col-sm-10">
                   <p class="form-control">${t.integralCount }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="price" class="col-sm-2 control-label">价格:</label>
               <div class="col-sm-10">
               		<p id="price" class="form-control">${t.price }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="stock" class="col-sm-2 control-label">库存:</label>
               <div class="col-sm-10">
                   <p class="form-control">${t.stock }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="original" class="col-sm-2 control-label">渠道专享:</label>
               <div class="col-sm-10">
                   <p class="form-control">${t.original }</p>
               </div>
           </div>
           
           <div class="form-group">
               <label for="isShelve" class="col-sm-2 control-label">是否下架:</label>
               <div class="col-sm-10">
               		<p class="form-control">
               		<c:if test="${t.isShelve eq '1'}">否</c:if>
               	   	<c:if test="${t.isShelve eq '0'}">是</c:if>
               	   </p>
               </div>
           </div>
           
           <div class="form-group">
               <label for="expiryTime" class="col-sm-2 control-label">有效期:</label>
               <div class="col-sm-10">
                  <p id="expiryTime" class="form-control">${t.expiryTime }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="mediaFile" class="col-sm-2 control-label">主图片:</label>
               <div class="col-sm-10">
            	   	<div class="col-sm-3">
               	   		<img src="${t.mainPicDto.url }" width="200" height="200"> 
               	   	</div>
               </div>
           </div>
           <div class="form-group">
               <label for="mediaFile" class="col-sm-2 control-label">图片:</label>
               <div class="col-sm-10">
            	   	<c:forEach items="${t.mediaDtos}" var="media">
            	   	<div class="col-sm-3">
            	   		<img src="${media.url }" width="200" height="200">
            	   	</div>
            	   	</c:forEach>	
               </div>
           </div>
           <div class="form-group">
               <label for="address" class="col-sm-2 control-label">地址:</label>
               <div class="col-sm-10">
                   <p id="address" class="form-control">${t.address }</p>
               </div>
           </div>
           <div class="form-group">
               <label for="point" class="col-sm-2 control-label">位置:</label>
               <div class="col-sm-10">
                   <p id="point" class="form-control">${t.longitude},${t.latitude}</p>
                   <div id="map" style="width:100%;height:600px"></div>
               </div>
           </div>
           <div class="form-group">
               <label for="remark" class="col-sm-2 control-label">简介:</label>
               <div class="col-sm-10">
                   <textarea rows="10" cols="170" name="remark" readonly="readonly">${t.remark }</textarea>
               </div>
           </div>
       </form>
	</jsp:body>
</my:admin>