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
			var lon=$("#longitude").val();
			var lat=$("#latitude").val();
			var point=new BMap.Point(lon,lat);
			map.centerAndZoom(point, 14);
			var marker = new BMap.Marker(point); //创建标注
			map.clearOverlays();//清除所有覆盖物(标注)
			map.addOverlay(marker);
			map.enableScrollWheelZoom();//启动鼠标滚轮操作
			//添加控件
			var opts={type:BMAP_NAVIGATION_CONTROL_ZOOM};//设置左侧调节栏的样式
			map.addControl(new BMap.NavigationControl(opts));//左侧调节栏
			map.addControl(new BMap.ScaleControl());//测量尺
			var marker=null;
			//单击获取点击的经纬度
			map.addEventListener("click",function(e){
				var lng=e.point.lng;
				var lat=e.point.lat;
				$("#longitude").val(lng);
				$("#latitude").val(lat);
				$("#point").text(lng + "," + lat);
				var point=new BMap.Point(lng,lat);
				if(marker==null){
					marker = new BMap.Marker(point); //创建标注
				}
				marker.setPosition(point);
				map.addOverlay(marker);
				map.panTo(point);
			});
		}
		//添加script标签
		function loadScript() {
			var script = document.createElement("script");
			script.src = "http://api.map.baidu.com/api?v=1.4&callback=initialize";
			document.body.appendChild(script);
		}
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

		function addMainpic(source) {  
	        var file = source.files[0];  
	        if(window.FileReader) {  
	            var fr = new FileReader();  
	            fr.onloadend = function(e) {  
	                document.getElementById("mainImage").src = e.target.result;  
					
	            };  
	            fr.readAsDataURL(file);  
	        }  
	    } 
		
		function addImage(input){
			 var file = input.files[0];
			 $div=$("<div class='col-sm-3'></div>");
			 $input=$(input);
			 $input.css("display","none");
			 $img=$("<img width='200' height='200'></img>");
			 $a=$("<a class='btn btn-link'>删除</a> ");
			 $a.click(function(){
				 $(this).parent().remove();
			 });
			 $div.append($input);
			 $div.append($img);
			 $div.append($a);
			 if(window.FileReader) {  
	             var fr = new FileReader();
	             fr.readAsDataURL(file); 
	             fr.onloadend = function(e) {  
	             	$img.attr("src", e.target.result);  
	             }; 
	               
	         }  
			 $("#showImage").append($div);
			 $("#upload_media").append('<input name="mediaFiles" type="file" onchange="addImage(this)" >');
		}

		function deleteMedia(id,mediaid,obj){
			var statu = confirm("确认删除?");
	        if(statu){
	        	$.ajax({
					url:"<c:url value='/admin/merchandise/delMedia'/>",
					data:{id:id,mediaid:mediaid},
					type:"get",
					dataType:"json",
					success:function(data){
						if(data.errcode=="0"){
							window.location.reload(); 
						}
					}
				});	
	        }
			
		}

		function validate(){
			if($("#classifyId").val()=="0"){
				alert('请选择商品分类!');
	        	return false;
			}
			if($("#brandId").val()=="0"){
				alert('请选择商品品牌!');
	        	return false;
			}
			if($("#name").val()==""){
				alert('商品名称不能为空!');
	        	return false;
			}
			if($("#integralCount").val()==""){
				alert('所需积分不能为空!');
	        	return false;
			}
			if($("#stock").val()==""){
				alert('商品库存不能为空!');
	        	return false;
			}
			if($("#mainImage").attr("src")==""){
				alert('请上传主图!');
	        	return false;
	        }
	        if($("#showImage").html().trim()==""){
	        	alert('请至少上传一张图片!');
	        	return false;
		    }
	        if($("#shopName").val()==""){
				alert('商户名称不能为空!');
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
			var expiryTime=$("#expiryTime").val();
			if(expiryTime.length!=0){    
		        var reg = /^\d{4}-\d{2}-\d{2}$/;     
		        var r = expiryTime.match(reg);     
		        if(r==null){
		        	alert('对不起，您输入的有效期格式不正确!例如:格式为2001-01-01');
	            	return false;
			    }    
		    }
	        return true;
		}
		</script>
	</jsp:attribute>
	<jsp:body>
		<form action="./" role="form" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return validate()">
           <div class="form-group">
               <label for="seq" class="col-sm-2 control-label">编号:</label>
               <div class="col-sm-10">
                   <input type="tel" class="form-control" name="seq" value="${t.seq }">
               </div>
           </div>
           <div class="form-group">
               <label for="classifyId" class="col-sm-2 control-label">商品分类:</label>
               <div class="col-sm-10">
                   <select id="classifyId" name="classifyId" class="form-control">
               			<option value="0">请选择...</option>
               			<c:forEach items="${classifies }" var="classify">
               			<option value="${classify.id }" <c:if test="${classify.id eq t.classifyDto.id}">selected</c:if>>${classify.name }</option>
               			</c:forEach>
               		</select>
               </div>
           </div>
           <div class="form-group">
               <label for="brandId" class="col-sm-2 control-label">商品品牌:</label>
               <div class="col-sm-10">
                   <select id="brandId" name="brandId" class="form-control">
               			<option value="0">请选择...</option>
               			<c:forEach items="${brands }" var="brand">
               			<option value="${brand.id }" <c:if test="${brand.id eq t.brandDto.id}">selected</c:if>>${brand.name }</option>
               			</c:forEach>
               		</select>
               </div>
           </div>
           <div class="form-group">
               <label for="name" class="col-sm-2 control-label">商品名称:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="name" value="${t.name }">*
               </div>
           </div>
           <div class="form-group">
               <label for="integralCount" class="col-sm-2 control-label">所需积分:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="integralCount" value="${t.integralCount }">*
               </div>
           </div>
           <div class="form-group">
               <label for="stock" class="col-sm-2 control-label">库存:</label>
               <div class="col-sm-10">
                   <input type="tel" class="form-control" name="stock" value="${t.stock }">*
               </div>
           </div>
           <div class="form-group">
               <label for="original" class="col-sm-2 control-label">渠道专享:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="original" value="${t.original }">
               </div>
           </div>
           <div class="form-group">
               <label for="mainPic" class="col-sm-2 control-label">主图片:</label>
               <div class="col-sm-10">
                   <a id="upload_mainpic" href="javascript:;" class="file">上传<input name='mainpicFile' type="file" onchange="addMainpic(this)" ></a><br>
                   <img id="mainImage" src="${t.mainPicDto.url }" width="200" height="200">
               </div>
           </div>
           <div class="form-group">
               <label for="mediaFile" class="col-sm-2 control-label">图片:</label>
               <div class="col-sm-10">
               	   <a id="upload_media" href="javascript:;" class="file">上传<input name='mediaFiles' type="file" onchange="addImage(this)" ></a> 
               	   <div id="showImage">
               	   		<c:forEach items="${t.mediaDtos}" var="media">
               	   		<div class="col-sm-3">
               	   			<img src="${media.url }" width="200" height="200">
               	   			<a class="btn btn-link" onclick="deleteMedia('${t.id}','${media.id}',this)">删除</a> 
               	   		</div>
               	   		</c:forEach>	
               		</div>
               </div>
           </div>
           <div class="form-group">
               <label for="expiryTime" class="col-sm-2 control-label">有效期:</label>
               <div class="col-sm-10">
                   <input id="expiryTime" class="form-control" name="expiryTime" 
                   value="<c:if test="${t.isActual eq '0' }">${t.expiryTime}</c:if>" placeholder="例如:格式为2001-01-01">
               </div>
           </div>
           <div class="form-group">
               <label for="name" class="col-sm-2 control-label">商户名称:</label>
               <div class="col-sm-10">
                   <input id="shopName" class="form-control" name="shopName" value="<c:if test="${t.isActual eq '0' }">${t.shopName }</c:if>">
               </div>
           </div>
           <div class="form-group">
               <label for="address" class="col-sm-2 control-label">地址:</label>
               <div class="col-sm-10">
                   <input id="address" class="form-control" name="address" placeholder="请输入商品的地址" 
                   value="<c:if test="${t.isActual eq '0' }">${t.address }</c:if>">
               </div>
           </div>
           <div class="form-group">
               <label for="point" class="col-sm-2 control-label">位置:</label>
               <div class="col-sm-10">
               	   <input id="longitude" type="hidden" class="form-control" name="longitude" value="${t.longitude}">
                   <input id="latitude" type="hidden" class="form-control" name="latitude" value="${t.latitude}">
                   <p id="point" class="form-control">${t.longitude},${t.latitude}</p><span>点击地图选择具体位置</span>
                   <div id="map" style="width:100%;height:600px"></div>
               </div>
           </div>
           <div class="form-group">
               <label for="remark" class="col-sm-2 control-label">详情介绍:</label>
               <div class="col-sm-10">
                   <textarea rows="10" cols="170" name="remark">${t.remark }</textarea>
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