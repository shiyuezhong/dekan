package com.dekan.mall.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
* @ClassName SocketClient
* @Description TODO【柜子开锁】
* @Author Shiyz
* @Date 2014-7-25 下午4:12:39
 */
public class SocketClient implements Runnable {  
	private  String host = "115.29.189.78";  //要连接的服务端IP地址
	private static int port = 9091;   //要连接的服务端对应的监听端口  
	
	private long number;
	private long cell;
	private long shelfid;
	
	public SocketClient(long number,long shelfid,long cell){
		this.number = number;
		this.shelfid = shelfid;
		this.cell = cell;
	}
	
	@Override
    public void run(){
	      //为了简单起见，所有的异常都直接往外抛  
	      //与服务端建立连接  
	      Socket client = null;
		  try {
		 	client = new Socket(host, port);
		  } catch (Exception e) {
		 	e.printStackTrace();
		  }
		   try {
			 //建立连接后就可以往服务端写数据了  
		      OutputStream writer = client.getOutputStream();
			  openLock(writer,number,shelfid,cell);
 	          writer.close(); 
 	          client.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}  
   }
    
    
    //处理高位数据
    public static byte[] getHlong(long rHlong,long shelf,long shelfid){
 	   byte hlongBuf[] =new byte[8];
 	   byte dataBuf[] =new byte[8];
 	   rHlong = (long)0xA << 60;
 	   rHlong |= shelfid << 56; //预留的副柜起始位56
	   rHlong |= shelf;
	   hlongBuf = longToBytes(rHlong);  
	   for(int i=0;i<8;i++){
 	 	   dataBuf[8-1-i] = hlongBuf[i];
 	   }
	   return dataBuf;
    }
    //处理低位数据
    public static byte[] getLlong(long rLlong,long cell){
 	   byte rLlongBuf[] =new byte[8];
 	   byte dataBuf[] =new byte[8];
 	   cell = (long)0x1 << cell; 
 	   rLlong |= cell;
 	   rLlongBuf = longToBytes(rLlong);  
 	   for(int i=0;i<8;i++){
 		   dataBuf[8-1-i] = rLlongBuf[i];
 	   }
	       return dataBuf;
    }
    
    
    //byte 数组与 long 的相互转换  
     public static byte[] longToBytes(long x) {  
     	ByteBuffer buffer = ByteBuffer.allocate(8);   
         buffer.putLong(0, x);  
         return buffer.array();  
     }  
     
     //开锁
     public static void openLock(OutputStream writer,long number,long shelfid,long cell) {  
         long rHlong = 0;
 	     long rLlong = 0;
	       /* long number = 998;//998号柜子
	        long cell = 8;//9号隔子*/
		    byte rHlongByte[] = getHlong(rHlong, number,shelfid);
		    byte rLlongByte[] = getLlong(rLlong, cell);
		    byte[] data = new byte[rHlongByte.length+rLlongByte.length];
		    System.arraycopy(rHlongByte,0,data,0,rHlongByte.length);
		    System.arraycopy(rLlongByte,0,data,rHlongByte.length,rLlongByte.length);
		    try {
				writer.write(data);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
     }

     //处理获取的数据
     public static long byteToLong(byte[] buf, int offset) {  
  	   long h0 = 0;  
  	   long h1 = 0;   
  	   long h2 = 0;  
  	   long h3 = 0;   
  	   long h4 = 0;  
  	   long h5 = 0;   
  	   long h6 = 0;  
  	   long h7 = 0;   
  	   int index = offset;  
         h0 = (0x000000FF & ((int) buf[index]));  
         h1 = (0x000000FF & ((int) buf[index + 1]));  
         h2 = (0x000000FF & ((int) buf[index + 2]));  
         h3 = (0x000000FF & ((int) buf[index + 3]));  
         h4 = (0x000000FF & ((int) buf[index + 4]));  
         h5 = (0x000000FF & ((int) buf[index + 5]));  
         h6 = (0x000000FF & ((int) buf[index + 6]));  
         h7 = (0x000000FF & ((int) buf[index + 7]));  

         return ((long) (h7 << 56 | h6 << 48 | h5 << 40 | h4 << 32 | h3 << 24 | h2 << 16 | h1 << 8 | h0));   
     	}  
     
     //获取柜子编号
     public static long getNumber(long hLong){
  	   long number = hLong;
  	   number &= 0xFFFF;
         return number;
     }
     //检测锁状态
     public static long checkLock(long lLong){
  	   long lock = lLong;
  	   lock >>= 63;
         lock &= 0x1;
         return lock;
     }
     //获取格子编号
     public static long getCell(long lLong){
     	lLong &= ((long)0x1 << 63) - 1; 
     	int log = (int) log(lLong, 2); // log is 2.0
         return log;
     }
     
     static public double log(double value, double base) {
     	return Math.log(value) / Math.log(base);
     }
     
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public long getCell() {
		return cell;
	}
	public void setCell(long cell) {
		this.cell = cell;
	}
	public long getShelfid() {
		return shelfid;
	}
	public void setShelfid(long shelfid) {
		this.shelfid = shelfid;
	}

}
