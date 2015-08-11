package com.doublev2v.integralmall.controller.admin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.foundation.media.MediaService;
import com.doublev2v.integralmall.util.ImageUtil;

/**
 * 在本地用此方式请求静态图片，在正式服务器上用nginx映射图片
 * @author Administrator
 *
 */
@RestController
public class FileController {
	
	@Autowired
	private MediaService mediaService;
	
	/**
	 * 获取图片
	 * @param fileName
	 * @param ext
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/image/{fileName}.{ext}",method=RequestMethod.GET)
	public void downLoad(@PathVariable String fileName,@PathVariable String ext, HttpServletResponse response) throws Exception {
		MediaContent media=mediaService.getMediaByFileName(fileName+"."+ext);
		String filePath=ImageUtil.getImageRealUrl(media);
		File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        response.reset();//Clears any data that exists in the buffer 
        URL u = new URL(f.toURI().toString());
        response.setContentType(u.openConnection().getContentType());//获取文件具体的类型
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) != -1)
            out.write(buf, 0, len);
        br.close();
        out.close();
	}
}
