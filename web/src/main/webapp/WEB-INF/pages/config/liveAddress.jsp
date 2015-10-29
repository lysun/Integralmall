<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="user" subtab="perm">
	<jsp:attribute name="script">
	<script id="template" type="text/html">
		$("#live").ajaxForm({
			success:function(data) {
                alert("保存成功!");
            }
		});
	</script>
	</jsp:attribute>
	<jsp:body>
	<form id="live" class="form-horizontal" method="post">
		<div class="form-group">
          <label class="control-label col-sm-2" for="live">正式直播地址：</label>
            <div class="col-sm-10">
            <input type="url" class="form-control" name="live" value=${liveAddress } required>
            </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="backup">备用地址：</label>
            <div class="col-sm-10">
            <input type="url" class="form-control" name="backup" value=${backupAddress } required>
            </div>
        </div>
        <div class="form-group mgt-1">
          <div class="col-sm-offset-2 col-sm-10">
             <button type="submit" class="btn btn-default">保存</button>
          </div>
       </div>
	</form>
	</jsp:body>
</my:admin>