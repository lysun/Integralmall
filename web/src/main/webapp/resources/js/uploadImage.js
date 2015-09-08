/**验证上传的文件是否是图片*/
function  validateImage(source){
	//判断图片格式
	var filepath = $(source).val();
    var extStart = filepath.lastIndexOf(".");
    var ext = filepath.substring(extStart, filepath.length).toUpperCase();
    if (ext != ".BMP" && ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG"){
    	alert("图片限于bmp,png,gif,jpeg,jpg格式");
    	return false;
    }
    //判断图片大小
    var file_size = source.files[0].size;
    if(file_size==-1){ 
    	alert("图片格式错误或已损坏，请重新选择");
    	return false;
    }
    if (file_size > 400 * 1024) {
    	alert("图片大小不能大于400KB");
    	return false;
    }
    return true;
}
/**
 * 展示图片
 * @param ImgObj image标签对象
 * @param source input file对象
 */
function showImage(ImgObj,source) {  
    var file = source.files[0];  
    if(window.FileReader) {  
        var fr = new FileReader();  
        fr.readAsDataURL(file);  
        fr.onloadend = function(e) {  
        	ImgObj.src = e.target.result;  
			
        };  
        
    }  
}
/**针对1:1的图:允许有1/20的误差*/
function validateImageOneToOne(ImgObj){
	var img_width=ImgObj.width;
	var img_height=ImgObj.height;
	if(Math.abs(img_width-img_height)>10){
		alert("请上传宽高比例1:1的主图");
    	return false;
    }
	return true;
}
/**针对5:3的图:允许有1/20的误差*/
function validateImageFiveToThree(ImgObj){
	var img_width=ImgObj.width;
	var img_height=ImgObj.height;
	if(img_width/img_height<19/12||img_width/img_height>100/57){
		alert("请上传宽高比例5:3的图片");
    	return false;
    }
	return true;
}
