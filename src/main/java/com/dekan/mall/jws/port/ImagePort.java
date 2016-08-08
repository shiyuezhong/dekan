package com.dekan.mall.jws.port;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.activation.DataHandler;
import javax.jws.WebService;

import com.dekan.mall.jws.beans.ImageState;
import com.dekan.mall.jws.beans.WaterSetting;


/**
 * ImagePort.  
 * @Author Shiyz
 * @Date 2016-08-04 上午8:05:07
 */
@WebService(name="ImagePort",targetNamespace="http://service.jws.bora.com")
public interface ImagePort extends Serializable{

	/**
	 * 上传默认图片方法
	 * 如果选择上传水印,将合成默认水印,水印位置取默认水印位置
	 * @author joe.qiu
	 * @creationDate. 2010-11-25 下午06:12:26 
	 * @param folderType 文件夹分类配置键
	 * @param srcFileData 源文件数据
	 * @param destFileId 目标上传文件id
	 * @param destFileName 目标文件名称
	 * @param waterSetting 水印设置
	 * @return 处理结果
	 * @throws IOException
	 */
	public boolean uploadImage(String folderType, DataHandler srcFileData, Object destFileId, String destFileName, WaterSetting waterSetting) throws IOException;
	/**
	 * 上传默认网络图片方法
	 * 如果选择上传水印,将合成默认水印,水印位置取默认水印位置
	 * @author joe.qiu
	 * @creationDate. 2010-11-25 下午06:13:16 
	 * @param folderType 文件夹分类配置键
	 * @param srcURL 源文件URL
	 * @param destFileId 目标上传文件id
	 * @param destFileName 目标文件名称
	 * @param waterSetting 水印设置
	 * @return 处理结果
	 * @throws IOException
	 */
	public boolean uploadImageByUrl(String folderType, String srcURL, Object destFileId,
			String destFileName, com.dekan.mall.jws.beans.WaterSetting waterSetting) throws IOException;
	/**
	 * 上传默认规格图片方法
	 * 如果选择上传水印,将合成默认水印,水印位置取默认水印位置
	 * @author joe.qiu
	 * @creationDate. 2010-11-25 下午06:15:55 
	 * @param folderType 文件夹分类配置键
	 * @param state 图片规格bean
	 * @param srcFileData 源文件数据
	 * @param destFileId 目标上传文件id
	 * @param destFileName 目标文件名称
	 * @param waterSetting 水印设置
	 * @return 处理结果
	 * @throws IOException
	 */
	public boolean uploadStatedImage(String folderType, ImageState state, DataHandler srcFileData,
			Object destFileId, String destFileName, WaterSetting waterSetting) throws IOException;
	/**
	 * 上传默认规格图片方法
	 * 如果选择上传水印,将合成默认水印,水印位置取默认水印位置
	 * @author joe.qiu
	 * @creationDate. 2010-11-25 下午06:15:55 
	 * @param folderType 文件夹分类配置键
	 * @param state 图片规格bean
	 * @param srcFileData 源文件数据
	 * @param destFileId 目标上传文件id
	 * @param destFileName 目标文件名称
	 * @param waterSetting 水印设置
	 * @return 处理结果
	 * @throws IOException
	 */
	public boolean uploadStatedsImage(String folderType, List<ImageState> states, DataHandler srcFileData,
			Object destFileId, String destFileName, WaterSetting waterSetting) throws IOException;
	/**
	 * 上传默认网络规格图片方法
	 * 如果选择上传水印,将合成默认水印,水印位置取默认水印位置
	 * @author joe.qiu
	 * @creationDate. 2010-11-25 下午06:16:22  
	 * @param folderType 文件夹分类配置键
	 * @param state 图片规格bean
	 * @param srcURL 源文件URL
	 * @param destFileId 目标上传文件id
	 * @param destFileName 目标文件名称
	 * @param waterSetting 水印设置
	 * @return 处理结果
	 * @throws IOException
	 */
	public boolean uploadStatedImageByUrl(String folderType, ImageState state, String srcURL,
			Object destFileId, String destFileName, WaterSetting waterSetting) throws IOException;
	/**
	 * 获得图片的图像地址
	 * @author joe.qiu
	 * @creationDate. 2010-12-7 下午03:05:12 
	 * @param folderType 文件夹分类配置键
	 * @param srcFileId 源文件信息数据的id
	 * @param preName 前置文件名
	 * @param fileName 文件名
	 * @return 图像地址
	 * @throws IOException 
	 */
	public String getImageURL(String folderType, Object srcFileId, String preName, String fileName) throws IOException;
	/**
	 * 复制图片
	 * @author joe.qiu
	 * @creationDate. 2011-1-22 上午09:45:58 
	 * @param folderType 文件夹分类配置键
	 * @param srcFileId 源文件信息数据的id
	 * @param destFileId 目标文件信息数据的id
	 * @return 处理结果
	 * @throws IOException 
	 */
	public boolean copyImage(String folderType, Object srcFileId, Object destFileId) throws IOException;
	/**
	 * 删除全部图片
	 * @author joe.qiu
	 * @creationDate. 2010-12-4 下午12:06:14 
	 * @param folderType 文件夹分类配置键
	 * @param srcFileId 源文件信息数据的id
	 * @return 处理结果
	 * @throws IOException
	 */
	public boolean deleteAllImage(String folderType, Object srcFileId) throws IOException;
	/**
	 * 删除图片
	 * @author joe.qiu
	 * @creationDate. 2011-10-30 上午06:20:38 
	 * @param folderType 文件夹分类配置键
	 * @param srcFileId 源文件信息数据的id
	 * @param fileName 文件名
	 * @return 处理结果
	 * @throws IOException
	 */
	public boolean deleteImage(String folderType, Object srcFileId, String fileName) throws IOException;
}
