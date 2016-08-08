package com.dekan.mall.service.common.intf;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dekan.mall.jws.beans.ImageState;

@Service
public interface ImageService {

	/*********
	 * 上传图片至图片服务器
	 * @param ImageType         上传图片的归属类型（如:酒店图片,房型图片,活动图片等）
	 * @param destFileId        上传图片相关的ID
	 * @param file              上传的图片流
	 * @param fileContentType   上传图片的类型（jpg/png等）
	 * @param fileFileName      上传图片的名称
	 * @param imageList         图片服务器生成的图片的规格数目
	 * @return
	 */
	public String uploadImage(String ImageType , Integer destFileId, File file, String fileContentType, String fileFileName, List<ImageState> imageList); 
}
