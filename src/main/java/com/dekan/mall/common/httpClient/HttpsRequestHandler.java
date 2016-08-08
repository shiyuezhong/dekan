package com.dekan.mall.common.httpClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;
/**
 * @ClassName HttpsRequestHandler
 * @Description https请求
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class HttpsRequestHandler {
	
	 /**
	* @Title sendGet
	* @Description 向指定URL发送GET方法的请求
	* @param url 发送请求的URL
	* @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
	/*		TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();*/
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
			      new java.security.SecureRandom());

			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			HttpsURLConnection connection = (HttpsURLConnection) realUrl
					.openConnection();
			// 设置通用的请求属性
			//connection.setSSLSocketFactory(ssf);
			connection.setSSLSocketFactory(sc.getSocketFactory());
		    connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Accept-Charset", "utf-8");
			connection.setRequestProperty("contentType", "utf-8");
			// 建立实际的连接
			connection.connect();
			/*// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}*/
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	* @Title sendPost
	* @Description  向指定 URL 发送POST方法的请求
	* @param url 发送请求的URL
	* @param param 请求参数应该是 name1=value1&name2=value2 的形式
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	public static String sendPost(String url, String param) {
        //PrintWriter out = null;
		DataOutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try{
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
			      new java.security.SecureRandom());
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpsURLConnection conn = (HttpsURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            //发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            if(StringUtils.isNotBlank(param)){
                param = new String(param.getBytes("utf-8"),"utf-8");
                // 获取URLConnection对象对应的输出流
                out = new DataOutputStream(conn.getOutputStream());
                out.write(param.getBytes());
                //byte[] bypes = param.toString().getBytes();
               // out.writeBytes(param);// 输入参数
                //out = new PrintWriter(conn.getOutputStream());
                // 发送请求参数
                //out.print(param);
                // flush输出流的缓冲
                out.flush();
            }
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        }catch (Exception e) {
           System.out.println("发送 POST 请求出现异常！"+e);
           e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    } 
	
	public static void main(String[] args) {
		
		String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
		String requstUrl = "https://api.weixin.qq.com/cgi-bin/menu/get";
		
		String restult = sendGet(tokenUrl,"grant_type=client_credential&appid=wxda24d62314dca88c&secret=2e26eb52cdbc10b46a793e5e2869f44f");
		System.out.println("获取access_token返回结果："+restult);
		JSONObject jsonObj = JSONObject.fromObject(restult); 
		String access_token = jsonObj.getString("access_token");
		System.out.println("access_token="+access_token);
		String param = "access_token="+access_token;
		String restult2 = sendGet(requstUrl,param); 
		System.out.println("restult2="+restult2);
		
	}

}
