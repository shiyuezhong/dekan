package com.dekan.mall.common.util;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.dekan.mall.common.constant.SystemConstants;


/******
* @ClassName HttpClientUtils
* @Description TODO【HTTP请求接口的工具类】
* @Author jonny
* @Date 2013-9-11 下午4:38:57
 */
public class HttpClientUtils {

	/****
	* @Title readContentFromPost
	* @Description TODO【通过POST报文请求接口获取数据】
	* @param param      请求参数（报文）
	* @param urlPost    请求的Post路径
	* @return
	* @throws Exception 
	* @Return String 返回类型
	* @Throws
	*/
	 public static String readContentFromPost(String param,String urlPost) throws Exception {
		    HttpClient httpclient = new DefaultHttpClient();
		    HttpResponse response = null;
	        try {
	        	 // 创建Get方法实例    
	        	if(param == null){
	        		HttpGet httpgets = new HttpGet(urlPost);    
	        		response = httpclient.execute(httpgets);    
	        	}else{
	        		HttpPost httppost = new HttpPost(urlPost);
		            InputStreamEntity reqEntity = new InputStreamEntity(IOUtils.toInputStream(param,SystemConstants.HEADER_ENCODING), -1);  
		            reqEntity.setContentType("binary/octet-stream;charset=UTF-8");     
		            reqEntity.setContentEncoding(SystemConstants.HEADER_ENCODING);
		            httppost.setEntity(reqEntity);
		            response = httpclient.execute(httppost);
	        	}
	            HttpEntity resEntity = response.getEntity();
	            if (resEntity != null && response != null && response.getStatusLine().getStatusCode() == 200) {
	                String result = IOUtils.toString(resEntity.getContent(),SystemConstants.HEADER_ENCODING);
	                return result;
	            }
	        } catch (Exception e) {
				e.printStackTrace();
			} finally {
	            httpclient.getConnectionManager().shutdown();
	        }
	        return null;
	 }
	 
	 
	 /**
	 * @Title readContentFromGet
	 * @Description TODO【通过GET接口回去数据】
	 * @param getUrl
	 * @return
	 * @throws Exception 
	 * @Return String 返回类型
	 * @Throws
	  */
	 public static String readContentFromGet(String getUrl){  
		HttpClient client = new DefaultHttpClient();  
		String result = "";
        HttpGet get = new HttpGet(getUrl);  
        try {  
            HttpResponse res = client.execute(get);  
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {  
                 HttpEntity entity = res.getEntity();  
                 result = IOUtils.toString(entity.getContent(),SystemConstants.HEADER_ENCODING);
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
              
        } finally{  
            //关闭连接 ,释放资源  
            client.getConnectionManager().shutdown();  
        }  
        return result;
	 } 
	 
	 
	 public static void main(String[] args) throws Exception {
		/* String param = "para={\"s\": \"82b7f887977245bc9dea\",\"pid\": \"PD_0558_0061\"}";
		 String url = "http://192.168.1.115:8080/borMall/services/intfs/productdetails.ac";
		 String result = readContentFromPost(url,param);
		 System.out.println(result); */
		// ?id=[]&com=[]&nu=[]&valicode=[]&show=[0|1|2|3]&muti=[0|1]&order=[desc|asc]
/*		 String url ="http://api.kuaidi100.com/api" ;
		 StringBuffer sb = new StringBuffer();
		 sb.append("?id=");
		 sb.append("460a11bd622001ee"); //key
		 sb.append("&com=");
		 sb.append("shunfeng");   //快递公司
		 sb.append("&nu=");
		 sb.append("905774700220");   //快递单号
		 sb.append("&valicode=");
		 sb.append("");
		 sb.append("&show=");
		 sb.append("0"); //返回类型，0：返回json字符串，  1：返回xml对象，  2：返回html对象， 3：返回text文本。 
		 sb.append("&muti=");
		 sb.append("1");  //多行显示
		 sb.append("&order=");
		 sb.append("desc"); //排序
		 url = url + sb.toString();
		 System.out.println(url);
		 String result = readContentFromGet(url);
		 System.out.println(result);*/
		 
		/* String url ="http://www.kuaidi100.com/applyurl" ;
		 StringBuffer sb = new StringBuffer();
		 sb.append("?key=");
		 sb.append("460a11bd622001ee"); //key
		 sb.append("&com=");
		 sb.append("shunfeng");   //快递公司
		 sb.append("&nu=");
		 sb.append("905774700220");   //快递单号
		 url = url + sb.toString();
		 System.out.println(url);
		 String result = readContentFromGet(url);
		 System.out.println(result);*/
		 
		String param = "para";
		 String url = "http://127.0.0.1:8080/mywchat/wcs.do";
		 String result = readContentFromPost(url,param);
		 System.out.println(result);
		 
		/* try
			{
			 String urls ="http://api.kuaidi100.com/api" ;
			 StringBuffer sb = new StringBuffer();
			 sb.append("?id=");
			 sb.append("460a11bd622001ee"); //key
			 sb.append("&com=");
			 sb.append("shunfeng");   //快递公司
			 sb.append("&nu=");
			 sb.append("905774700220");   //快递单号
			 sb.append("&valicode=");
			 sb.append("");
			 sb.append("&show=");
			 sb.append("0"); //返回类型，0：返回json字符串，  1：返回xml对象，  2：返回html对象， 3：返回text文本。 
			 sb.append("&muti=");
			 sb.append("1");  //多行显示
			 sb.append("&order=");
			 sb.append("desc"); //排序
			 urls = urls + sb.toString();
			 System.out.println(urls);
			 
			 URL url= new URL(urls);
				URLConnection con=url.openConnection();
				 con.setAllowUserInteraction(false);
				   InputStream urlStream = url.openStream();
				   String type = con.guessContentTypeFromStream(urlStream);
				   String charSet=null;
				   if (type == null)
				    type = con.getContentType();

				   if (type == null || type.trim().length() == 0 || type.trim().indexOf("text/html") < 0)
				    return ;

				   if(type.indexOf("charset=") > 0)
				    charSet = type.substring(type.indexOf("charset=") + 8);

				   byte b[] = new byte[10000];
				   int numRead = urlStream.read(b);
				  String content = new String(b, 0, numRead);
				   while (numRead != -1) {
				    numRead = urlStream.read(b);
				    if (numRead != -1) {
				     //String newContent = new String(b, 0, numRead);
				     String newContent = new String(b, 0, numRead, charSet);
				     content += newContent;
				    }
				   }
				   System.out.println("content:" + content);
				   urlStream.close();
			} catch (MalformedURLException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}*/
	}
}
