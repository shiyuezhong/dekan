package com.dekan.mall.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dekan.mall.jws.beans.ImageState;
import com.dekan.mall.jws.constant.ImageConstants;
/**
 * @ClassName ImageUtils
 * @Description TODO【图片上传的工具类】
 * @Author Shiyz
 * @Date 2013-10-23 下午2:15:42
 */
public class ImageUtils {

	/*****
	 * 将上传的名字重新生成新名称 防止中文乱码
	 * @return
	 */
	public static String getFileName(String fileName){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date  = new Date();
		return dateFormat.format(date)+fileName.substring(fileName.lastIndexOf("."), fileName.length());
	}
	
	/*****
	 * 生成商品图片规格
	 * @return
	 */
	public static List<ImageState> findProductImgStates(){
		List<ImageState> states = new ArrayList<ImageState>(); 
		//添加生成图片规格的对象
	    ImageState imageState = new ImageState();
	    imageState.setHight(300);
	    imageState.setPreName(ImageConstants.UPLOAD_PRODUCT_INFO_);
	    imageState.setWidth(200);
	    states.add(imageState);
		return states;
	}
	/*****
	 * 生成商品配置图片规格
	 * @return
	 */
	public static List<ImageState> findProductConfigImgStates(){
		List<ImageState> states = new ArrayList<ImageState>(); 
		//添加生成图片规格的对象
	    ImageState imageState = new ImageState();
	    imageState.setHight(300);
	    imageState.setPreName(ImageConstants.UPLOAD_PRODUCTCONFIG_INFO_);
	    imageState.setWidth(200);
	    states.add(imageState);
		return states;
	}
	/*****
	 * 生成货架商品图片规格
	 * @return
	 */
	public static List<ImageState> findProductShelvesImgStates(){
		List<ImageState> states = new ArrayList<ImageState>(); 
		//添加生成图片规格的对象
	    ImageState imageState = new ImageState();
	    imageState.setHight(300);
	    imageState.setPreName(ImageConstants.UPLOAD_PRODUCTSHELVES_INFO_);
	    imageState.setWidth(200);
	    states.add(imageState);
		return states;
	}
	/*****
	 * 生成编辑器图片规格
	 * @return
	 */
	public static List<ImageState> findCkeditContentStates(){
		List<ImageState> states = new ArrayList<ImageState>(); 
		//添加生成图片规格的对象
	    ImageState imageState = new ImageState();
	    imageState.setHight(300);
	    imageState.setPreName(ImageConstants.UPLOAD_CKEDIT_MESSAGE_);
	    imageState.setWidth(200);
	    states.add(imageState);
		return states;
	}
	
	/******
	 * 根据路径名称获取文件流
	 * @param imagePath
	 * @return
	 */
    public static File getFile(String imagePath){
       String root = ServletActionContext.getServletContext().getRealPath("/upload");
	   String path =root +"/"+ imagePath;
       File file = new File(path);
       return file;
    }
    
    /****
     * 删除本地缓存图片
     * @param imagePath
     */
    public static void DeleteFile(String imagePath){
    	 File file = new File(imagePath);
    	 file.delete();
    }
    
	 
}
