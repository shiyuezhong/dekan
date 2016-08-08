package com.dekan.mall.common.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
* @ClassName LogUtils
* @Description TODO【日志记录工具类】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
public class LogUtils {
	
	/** 默认文件名 */
	protected static final String DEFAULT_NAME = "payment";
	/** 默认文件名 */
	protected static final String DIR_NAME = "/opt/temp/log/payment/";
	/** 默认存储方式 */
	protected static final boolean DEFAULT_METHOD = false;
	/** 默认缓存大小 */
	protected static final int DEFAULT_SIZE = 10;
	/** 日志间的分隔符 */
	protected static final String SEP = "\n";
	/** 文件名的分隔符 */
	protected static final String FILE_SEP = "_";
	/** 缓存大小 */
	protected int messageSize = 0;
	/** 文件前缀 */
	protected String dirName = null;
	/** 文件前缀 */
	protected String fileName = null;
	/** 当前文件名，不含.log */
	protected String currentLogFile = "";
	/** 当前是否使用缓存 */
	protected boolean bufferMethod = DEFAULT_METHOD;
	/** 以 List 实现的缓存 */
	@SuppressWarnings("rawtypes")
	protected List bufferedMessage;
	
	/**
	* @Title 默认构造函数，使用默认值构造日志记录器
	* @Description 
	*/ 
	public LogUtils(){
		init(DIR_NAME,DEFAULT_NAME,DEFAULT_SIZE,DEFAULT_METHOD);
	}
	
	/**
	* @Title 指定文件前缀与缓存大小，缓存将自动启用
	* @Description 
	* @param fileName 文件前缀，不含日期
	* @param bufferSize 缓存大小 10~200，超过200以200计，低与10以10计
	*/ 
	public LogUtils(String fileName,int bufferSize){
		bufferSize = (bufferSize >= 10 && bufferSize <= 200) ?
	    bufferSize : ((bufferSize > 200) ? 200 : 10);
		init(DIR_NAME,fileName,bufferSize,true);
	}
	
	/**
	* @Title 指定文件前缀与是否启用缓存，缓存将使用默认值: <code>{@link #DEFAULT_METHOD}</code>
	* @Description 
	* @param fileName
	* @param bufferMethod
	*/ 
	public LogUtils(String fileName,boolean bufferMethod){
		init(DIR_NAME,fileName,DEFAULT_SIZE,bufferMethod);
	}
	
	/**
	* @Title 指定文件前缀与缓存大小，缓存将自动启用
	* @param dirName
	* @param fileName
	* @param bufferSize
	*/ 
	public LogUtils(String dirName,String fileName,int bufferSize){
		bufferSize = (bufferSize >= 10 && bufferSize <= 200) ?
	    bufferSize : ((bufferSize > 200) ? 200 : 10);
		init(dirName,fileName,bufferSize,true);
	}
	
	/**
	* @Title 指定文件前缀与是否启用缓存，缓存将使用默认值: <code>{@link #DEFAULT_METHOD}</code>
	* @param dirName
	* @param fileName
	* @param bufferMethod
	*/ 
	public LogUtils(String dirName,String fileName,boolean bufferMethod){
		init(dirName,fileName,DEFAULT_SIZE,bufferMethod);
	}
	
	/**
	* @Title init
	* @Description TODO【根据指定参数初始化实例，并计算当前文件名】
	* @param fileName 文件前缀
	* @param bufferSize 缓存大小
	* @param bufferMethod 是否启用缓存
	* @Return void 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void init(String dirName,String fileName,int bufferSize,boolean bufferMethod){
		this.messageSize = bufferSize;
		this.fileName = fileName;
		this.dirName = dirName;
		this.bufferMethod = bufferMethod;
		if (bufferMethod){
		   this.bufferedMessage = Collections.synchronizedList(new ArrayList());
		}
		//创建目录
		createDir(DIR_NAME);
		//先计算文件名
		this.currentLogFile = this.dirName + this.fileName + FILE_SEP + getDateString();
	}
	
	/**
	* 处理日志信息，判断<code>{@link #bufferMethod}</code>，<br/>
	* true : 将日志缓存，直到缓存超出<code>{@link #messageSize}</code>，则追加到文件尾部<br/>
	* false : 将日志直接追加到文件尾部<br>
	* <b>注意</b> : 缓存模式中，请在应用程序退出前调用<code>{@link #forceClearBufferAtOnce()}</code>提交<br>，
	* 否则缓存中未及时保存的信息将丢失
	* @param message 要保存的信息
	* @return true保存成功 false保存失败
	*/
	public synchronized boolean processLog(String message){
		String tempName = this.dirName +  this.fileName + FILE_SEP + getDateString();
		// 生成文件名并判断是否日期已经更换
		if (!currentLogFile.equals(tempName)){
		   if (bufferMethod)
		   {
		    // 日期更换则先强行提交
		    try {
		     forceClearBufferAtOnce();
		    } catch (Exception e) {
		     // 忽略错误
		    }
		   }
		   // 文件名替换
		   currentLogFile = tempName; 
		}
		// 根据记录模式选择对应的记录方式
		try {
		   if (bufferMethod){
			   processLogWithBuffer(message,false);
		   }else{
			   processLogAtOnce(message);
		   }
		} catch (IOException e) {
		   // 保存过程捕捉到错误
		   return false;
		}
		// 准确完成
		return true;
	}

	/**
	* 将消息立即保存到以<code>{@link #currentLogFile}</code>命名的.log文件，<br/>
	* 使用 java.io.RandomAccessFile 进行保存，并且以插入分隔符 <code>{@link #SEP}</code>   
	* @param message 
	* @throws IOException 保存失败时抛出
	*/
	protected void processLogAtOnce(String message) throws IOException{
		File currentFile = new File(currentLogFile + ".log");
		if (!currentFile.exists()){
		   currentFile.createNewFile();
		}
		//FileWriter out = new FileWriter(currentFile);
		RandomAccessFile out = new RandomAccessFile(currentFile,"rw");
		out.seek(out.length());
		out.writeBytes(SEP);
		out.write(message.getBytes("UTF-8"));
		out.close();
	}

	/**
	* 将消息保存到 <code>{@link #bufferedMessage}</code> ，直到缓存达到指定数，<br/>
	* 使用<code> #processLogAtOnce(String)}</code> 立即保存消息<br/>
	* @param message
	* @param force 忽略缓存大小，强制保存
	* @throws IOException 保存失败时抛出
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected synchronized void processLogWithBuffer(String message,boolean force) throws IOException{
		// 先保存消息
		if (message != null){
		   bufferedMessage.add(message);
		}
		// 判断是否需要立即保存到文件
		if (force || bufferedMessage.size() >= messageSize){
		   StringBuffer sb = new StringBuffer();
		   Iterator it = bufferedMessage.iterator();
		   if (it.hasNext()){
		    do {
		     sb.append(SEP + it.next());
		    } while (it.hasNext());
		   }
		   /*if (force){
		    System.out.println("Save at once cause force!");
		   }else{
		    System.out.println("Save at once cause buffer full!");
		   }*/
		   //截取字符串首个分隔符，因为系统自动会在消息前加
		   processLogAtOnce(sb.substring(SEP.length()));
		   bufferedMessage.clear();
		}
	}

	/**
	* 强制将缓存中的消息保存到文件
	* @return true保存成功 false保存失败
	* @throws Exception 非缓存模式
	*/
	public boolean forceClearBufferAtOnce() throws Exception{
		if (!bufferMethod){
		   throw new Exception("Not buffer model, can't force clear!");
		}
		try {
		   processLogWithBuffer(null,true);
		} catch (IOException e) {
		   return false;
		}
		return true;
	}

	/**
	* TODO 以更好的算法替换每次记录都判断时间<br/>
	* 
	* 获取日期字符串，不包含时间
	* @return 表示日期的字符串
	*/
	protected String getDateString(){
		return DateUtils.formatString(new Date(), "yyyyMMdd");
	}
	
	/**
	* @Title createDir
	* @Description TODO【创建目录】
	* @param destDirName
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	protected static boolean createDir(String destDirName) {
	    File dir = new File(destDirName);
	    if (dir.exists()) {
	    	return false;
	    }
	    if (!destDirName.endsWith(File.separator)) {
	    	destDirName = destDirName + File.separator;
	    }
	    //创建目录
	    if (dir.mkdirs()) {
		    return true;
	    } else {
	        return false;
	    }
	}
	


	public static void main(String[] args) throws Exception{
		System.out.println("not buffer model start!");
		LogUtils log = new LogUtils();
		for (int i = 0; i < 100 ; ++ i){
		   log.processLog("哈哈，This is my log, number : " + i);
		}
	}

}
