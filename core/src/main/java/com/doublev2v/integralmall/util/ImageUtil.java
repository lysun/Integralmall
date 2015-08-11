package com.doublev2v.integralmall.util;

import com.doublev2v.foundation.media.MediaContent;

public class ImageUtil {

	/**
	 * 获取图片的访问地址
	 * @param media
	 * @return
	 */
	public static String getImageVisitUrl(MediaContent media){
		return media.getServerAddress()+"/image/"+media.getFileName();
	}
	/**
	 * 获取图片的物理地址(磁盘路径)
	 * @param media
	 * @return
	 */
	public static String getImageRealUrl(MediaContent media){
		return Constant.BASE_PATH+media.getPath();//文件路径为基本路径+文件path
	}
}
