package com.dekan.mall.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientTest {

	public String method(HttpClient client, String url) {
		PostMethod method = new PostMethod(url);
		String product = null;
		try {
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {
				return product;
			} else {
				byte[] responseBody = method.getResponseBody();
				product = new String(responseBody, "utf-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return product;
	}

	/**
	 * @Title sendGet
	 * @Description 向指定URL发送GET方法的请求
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @Return String 返回类型
	 * @Throws
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			// Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			// for (String key : map.keySet()) {
			// System.out.println(key + "--->" + map.get(key));
			// }
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
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
	 * @Description 向指定 URL 发送POST方法的请求
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数应该是 name1=value1&name2=value2 的形式
	 * @return
	 * @Return String 返回类型
	 * @Throws
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public String getProduct(String pid) {
		HttpClient client = new HttpClient();
		String url = "http://115.29.232.103:8080/borMall/services/intfs/productdetails.ac?para={%22s%22:%2282b7f887977245bc9dea%22,%22device%22:%220%22,%22pid%22:%22"
				+ pid + "%22,%22device%22:%223%22}";
		return method(client, url);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		HttpClientTest hc = new HttpClientTest();
		String s = hc.getProduct("");
		System.out.println(s);

		// String hoteltName = (new
		// String("王旭".getBytes("ISO-8859-1"),"UTF-8"));
		// System.out.println(URLEncoder.encode("王旭", "utf-8"));
		// System.out.println(restult);
	}

	public String getOpenid(String code) {
		HttpClient client = new HttpClient();
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx49223c0feb2e0c3a&secret=8464c29ffc14bb54c24b6718797de3d2&code="
				+ code + "&grant_type=authorization_code";
		String openId = method(client, url);
		return openId;
	}
	
	
	
	
	
	public String getPrepayId(String appid, String mch_id,
			String nonce_str, String sign, String body, String out_trade_no,
			String total_fee, String spbill_create_ip, String notify_url,
			String trade_type, String openid) {
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

		String param = "<xml><appid><![CDATA["+appid+"]]></appid>"
				+ "<body><![CDATA["+ body+ "]]></body>"
				+ "<out_trade_no><![CDATA["+ out_trade_no+ "]]></out_trade_no>"
				+ "<mch_id><![CDATA["+mch_id+"]]></mch_id>"
				+ "<nonce_str><![CDATA["+ nonce_str+ "]]></nonce_str>"
				+ "<notify_url><![CDATA["+ notify_url+ "]]></notify_url>"
				+ "<openid><![CDATA["+ openid+ "]]></openid>"
				+ "<out_trade_no><![CDATA["+ out_trade_no+ "]]></out_trade_no>"
				+ "<spbill_create_ip><![CDATA["+ spbill_create_ip+ "]]></spbill_create_ip>"
				+ "<total_fee><![CDATA["+total_fee+"]]></total_fee><trade_type><![CDATA[JSAPI]]></trade_type>"
				+ "<sign><![CDATA[" + sign + "]]></sign>" + "</xml>";
		
		String openId = postMethod(url, param);
		System.out.println(openId);
		return openId;
	}

	private static String postMethod(String url, String param) {
		String data = param;
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(url);
		String info = null;
		try {
			RequestEntity entity = new StringRequestEntity(data, "text/xml",
					"UTF-8");
			post.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			post.addRequestHeader("Content-Type", "text/html;charset=UTF-8");
			post.setRequestHeader("Content-Type", "text/html;charset=UTF-8");

			post.setRequestEntity(entity);
			httpclient.executeMethod(post);
			int code = post.getStatusCode();
			if (code == HttpStatus.SC_OK) {
				info = new String(post.getResponseBodyAsString());
			}

			System.out.println(info);
			return info;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		return null;
	}

}