package com.doublev2v.foundation.utils;

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
	
}
