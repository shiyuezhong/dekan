package com.dekan.mall.web.action.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.dekan.mall.util.ImageCut;
import com.dekan.mall.web.action.core.BaseAction;

/**
 * @ClassName ImageAction
 * @Description TODO【图片处理Action】
 * @Author shiyz
 * @Date 2016-08-04 下午5:02:58
 */
@Namespace("/common")
public class ImageAction extends BaseAction{
	private static final long serialVersionUID = -1147038520895883557L;

	private String imageIdshow;//隐藏域，用于提交图片名称
	private String imgSrc;//图片显示的路径（不包含ip和项目名）
	private String oldImgPath;//图片原始路径
	private String imageSrcshow;//图片显示的id
	
	@Action("image")
	public String image(){
		if(imgSrc.toString().indexOf("9000")>0){
			int index = imgSrc.indexOf("9000");
			String imgSrco = imgSrc.substring(index+5, imgSrc.length());
			oldImgPath = getImgRealUrl() + imgSrco;
		}else{
			oldImgPath = getImgTempUrl() + imgSrc;
		}
	    return "image";	
	}

	@Action("imagejcrop")
	public String loadimage(){
	    return "imagejcrop";	
	}
	
	@Action("saveimage")
	public String saveimage(){
	        // 用户经过剪辑后的图片的大小  
	        Integer x = Integer.parseInt(request.getParameter("imageX"));  
	        Integer y = Integer.parseInt(request.getParameter("imageY"));  
	        Integer w = Integer.parseInt(request.getParameter("imageW"));  
	        Integer h = Integer.parseInt(request.getParameter("imageH"));  
	          
	        //获取原显示图片路径  
	        String oldImgPath = request.getParameter("oldImgPath");  
	        //图片后缀  
	        //String imgFileExt = request.getParameter("imgFileExt");  
	        //String imgRoot =  request.getParameter("imgRoot");  
	          
	        //Integer width = 1;//Integer.parseInt(request.getParameter("width"));  
	        // Integer height = 2;//Integer.parseInt(request.getParameter("height"));  
	          
	        //WEB应用程序根路径  
	        String webAppPath = getServletContext().getRealPath("/");  
	          
	        /**图片名称:以当前日期*/  
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
	        String imgFileId = formatter.format(new Date());  
	        String imgName =  "upload/";            
	        //组装图片真实名称  
	        String createImgPath = webAppPath + imgName;  
	          
	        //System.out.println("原图片路径: " + oldImgPath + ",新图片路径: " + createImgPath);  
	          
	        //进行剪切图片操作  
	        ImageCut.abscut(oldImgPath, createImgPath,imgFileId, x,y,w, h);  
	          
	         
	         Map<String, String> jsonMap = new HashMap<String, String>();
	 	   //jsonMap.put("message", "成功");
	 	     jsonMap.put("imageId", imgFileId+".png");
	 	     jsonMap.put("imageIdshow", imageIdshow);
	 	     jsonMap.put("imageSrcshow", imageSrcshow);
	 		 return ajax(jsonMap);
	}

	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getOldImgPath() {
		return oldImgPath;
	}
	public void setOldImgPath(String oldImgPath) {
		this.oldImgPath = oldImgPath;
	}
	public String getImageSrcshow() {
		return imageSrcshow;
	}
	public void setImageSrcshow(String imageSrcshow) {
		this.imageSrcshow = imageSrcshow;
	}
	public String getImageIdshow() {
		return imageIdshow;
	}
	public void setImageIdshow(String imageIdshow) {
		this.imageIdshow = imageIdshow;
	}
}
