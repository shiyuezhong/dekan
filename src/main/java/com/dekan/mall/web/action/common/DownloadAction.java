package com.dekan.mall.web.action.common;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dekan.mall.common.util.StringEncode;
import com.dekan.mall.common.util.Struts2Utils;
import com.dekan.mall.web.action.core.BaseAction;

/****
 * 类名称：DownloadAction
 * 类描述：文件下载的Action
 * 创建人：shiyz   
 * 创建时间：2013-6-17 上午10:00:02   
 */

@Namespace("/common")
@Results({@Result(name = "download", type = "stream", params = {
		"contentType", "application/octet-stream",
		"inputName", "inputStream", "contentDisposition",
		"attachment;filename=\"${downloadFileName}\"", "bufferSize",
		"4096" })})
public class DownloadAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String attachname;
	private String fileName;// 初始的通过param指定的文件名属性
	
	
	public String execute() throws Exception {
		if(StringUtils.isNotBlank(attachname)){
			attachname=StringEncode.toUTF8(attachname);
			setFileName(attachname);
		}
		return "download";
	}

	public InputStream getInputStream() throws Exception {
			String root = ServletActionContext.getServletContext().getRealPath("/download");
			File file=new File(root);
			if (!file.exists()) {
				file.mkdirs();
			}
	     //String filepath=root+File.separator+attachname;
		 //return new FileInputStream(new File(filepath));
			String fileNames = java.net.URLDecoder.decode(fileName.trim(),"UTF-8");
		    String strRemoteFileUrl = fileNames;//取得远程文件路径 
	        InputStream in  = getDownloadFile(strRemoteFileUrl);//调用Service层方法取得远程服务器文件流 
	        return in;    
				    
		
	}

	public String getDownloadFileName() {
		return fileName;
	}

	public void setFileName(String fileName) throws UnsupportedEncodingException {
		String agent = Struts2Utils.getRequest().getHeader("User-agent");
		//如果浏览器是IE浏览器，就得进行编码转换
		if(agent.contains("MSIE")){
			this.fileName = URLEncoder.encode(fileName, "UTF-8");
		}else{
			this.fileName = new String(fileName.getBytes(),"ISO-8859-1");  
		}
	}

	
	
	public InputStream getDownloadFile(String strRemoteFileUrl) { 
        HttpClient client = new HttpClient();  
        GetMethod httpGet = new GetMethod(strRemoteFileUrl); 
        InputStream in  = null; 
        try { 
            client.executeMethod(httpGet); 
            in  = httpGet.getResponseBodyAsStream(); 
        } catch (HttpException e) { 
        } catch (IOException e) { 
        }   
        return in;   
    }
	
	public String getAttachname() {
		return attachname;
	}

	public void setAttachname(String attachname) {
		this.attachname = attachname;
	}


}