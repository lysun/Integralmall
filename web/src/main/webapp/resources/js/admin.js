/**通用ajax方法*/
function ajax(url,params,type,showData){
	$.ajax({
		url:url,
		data:params,
		type:type,
		dataType:"json",
		success:function(data){
			showData(data);
		}
	});
}

/**通用删除方法*/
function del(url,id) {
	bootbox.confirm("确定要删除它吗？",
			function(result){
		if(!result)return;
		$.ajax({
	        url:url+"/"+id,
	        type:"DELETE",
	        dataType:"json",
	        success:function(data) {
	        	if(data.errcode=="0"){
	        		$("#"+id).remove();
	        	}else{
	        		alert(data.errmsg);
	        	}
	        },
	        error:function() {
	            alert("删除失败！");
	        }
	    });
	});    
}


/**通用列表页面分页*/
var url_params="";
function pagination(totalPages,size,url,params,callback) {
	url_params=params;
	size=size?size:12;
	var visiblePages=5;
	$('#pagination').twbsPagination({
        totalPages: totalPages,
        visiblePages: visiblePages,
        first:"首页",
        prev:"上一页",
        next:"下一页",
        last:"尾页",
        paginationClass:'pagination',
        onPageClick: function (event, page) {
            $.ajax({
				url:url,
				data:"page="+page+"&size="+size+"&"+url_params,
				type:"GET",
				dataType:"json",
				success:function(data){
					callback(data);
				}
			});
          }
    });
}
/**加载模态框html页面到指定位置并显示*/
function loadModal(obj,url){
	$(obj).load(url,null,function(){
		$('#myModal').modal('show');
	});
	
}

function changepassword(url){
	var new_password=$("#new_password").val();
	var confirm_password=$("#confirm_password").val();
	if(new_password!=confirm_password){
		alert("您两次输入的密码不一致");
		return;
	}
	ajax(url,{password:new_password},"POST",function(data){
		$('#myModal').modal('hide');
		if(data.errcode=="0"){
			alert("修改密码成功");
		}else{
			alert("修改密码失败");
		}
		
	});
}