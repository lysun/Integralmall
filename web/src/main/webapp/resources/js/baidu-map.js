//地图操作
	var map;
	var marker=null;//用于记录选择位置的标记
	//添加script标签
	function loadScript() {
		var script = document.createElement("script");
		script.src = "http://api.map.baidu.com/api?v=1.4&callback=initialize";
		document.body.appendChild(script);
	}
	
	function initialize() {
		map = new BMap.Map('map');
		map.centerAndZoom("北京");
		map.enableScrollWheelZoom();//启动鼠标滚轮操作
		//添加控件
		var opts={type:BMAP_NAVIGATION_CONTROL_ZOOM};//设置左侧调节栏的样式
		map.addControl(new BMap.NavigationControl(opts));//左侧调节栏
		map.addControl(new BMap.ScaleControl());//测量尺
		addMarker();
	}
	function addMarker(){
		var lon=$("#longitude").val();
		var lat=$("#latitude").val();
		if(lon!=""&&lat!=""){
			var point=new BMap.Point(lon,lat);
			marker = new BMap.Marker(point); //创建标注
			map.clearOverlays();//清除所有覆盖物(标注)
			map.addOverlay(marker);
		}
		addMapListener();
		
	}
	
	function addMapListener(){
		
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