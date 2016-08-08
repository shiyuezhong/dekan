package com.dekan.mall.service.common.impl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dekan.mall.jws.beans.ImageState;
import com.dekan.mall.jws.port.ImagePort;
import com.dekan.mall.service.common.intf.ImageService;

@Service("imageServiceImpl")
public class ImageServiceImpl implements ImageService{

	@Resource 
	private ImagePort imagePort;
	public static final List<String> IMG_TYPES=Arrays.asList("image/bmp","image/png","image/gif","image/jpg","image/jpeg","image/pjpeg","image/x-png");
	
	@Override
	public String uploadImage(String ImageType, Integer destFileId, File file,
			String fileContentType, String fileFileName,
			List<ImageState> imageList) {
		String picPath = null;
		try {
			if (file != null) {
				if (checkImage(fileContentType)) {
					imagePort.uploadStatedsImage(ImageType, imageList, new DataHandler(new FileDataSource(file)), destFileId, fileFileName, null);
					picPath=imagePort.getImageURL(ImageType, destFileId, null, fileFileName);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(StringUtils.isNotBlank(picPath)){
			picPath=picPath.replace(fileFileName, "");
		}
		return picPath;
	}
	public static boolean checkImage(String contentType){
		return IMG_TYPES.contains(contentType);
	}
}
