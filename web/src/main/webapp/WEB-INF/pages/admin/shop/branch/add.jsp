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
		loadScript();

		</script>
	</jsp:attribute>
<jsp:body>
		<form action="./" role="form" class="form-horizontal" method="post" enctype="multipart/form-data">
           <div class="form-group">
               <label for="num" class="col-sm-2 control-label">分店编号:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="num"  placeholder="please input shopName">
               </div>
           </div>
           <div class="form-group">
               <label for="shopName" class="col-sm-2 control-label">分店名称:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="name"  placeholder="please input name">
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