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