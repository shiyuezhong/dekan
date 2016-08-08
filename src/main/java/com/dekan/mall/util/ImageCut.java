package com.dekan.mall.util;   
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
      
    public class ImageCut {  
        /**  
         * 图像切割（改）     *  
         * @param srcImageFile            源图像地址 
         * @param dirImageFile            新图像地址 
         * @param x                       目标切片起点x坐标 
         * @param y                      目标切片起点y坐标 
         * @param destWidth              目标切片宽度 
         * @param destHeight             目标切片高度 
         */  
        public static void abscut(String srcImageFile,String dirImageFile,String imgFileId, int x, int y, int destWidth,  
                int destHeight) {  
            try {  
                Image img;  
                ImageFilter cropFilter;  
                // 读取源图像  
                BufferedImage bi = ImageIO.read(new File(srcImageFile));  
                int srcWidtho = bi.getWidth(); // 源图宽度  
                int srcHeighto = bi.getHeight(); // 源图高度            
                
                double imgrate = 1.0d;
                
                int srcWidth = 0;
                int srcHeight = 0;
                
                srcWidth = srcWidtho;
           	    srcHeight = srcHeighto;
           	 
           	 
                if(srcWidtho <= 455 && srcHeighto <= 291){
                	 srcWidth = srcWidtho;
                	 srcHeight = srcHeighto;
                }else if(Float.parseFloat(srcWidtho+"")/Float.parseFloat(srcHeighto+"")<455.0/291.0){
                	// srcWidth = (int) (291*Float.parseFloat(bi.getWidth()+"")/Float.parseFloat(bi.getHeight()+""));
                	// srcHeight = 291;
                	 imgrate = srcHeighto/291.0;
		   		}else{
		   			// srcHeight = (int) (455*Float.parseFloat(bi.getHeight()+"")/Float.parseFloat(bi.getWidth()+""));
		   			//srcWidth = 455;
		   			 imgrate = srcWidtho/455.0;
		   		}
                if(imgrate ==0 ){
                	imgrate = 1;
                }
                
              //  if (srcWidth >= destWidth && srcHeight >= destHeight) {  
                    Image image = bi.getScaledInstance(srcWidth, srcHeight,  
                            Image.SCALE_DEFAULT);  
                    // 改进的想法:是否可用多线程加快切割速度  
                    // 四个参数分别为图像起点坐标和宽高  
                    // 即: CropImageFilter(int x,int y,int width,int height)  
                    cropFilter = new CropImageFilter((int)(Math.round(x*imgrate)), (int)(Math.round(y*imgrate)), (int)(Math.round(destWidth*imgrate)), (int)(Math.round(destHeight*imgrate)));  
                    img = Toolkit.getDefaultToolkit().createImage(  
                            new FilteredImageSource(image.getSource(), cropFilter));  
                    BufferedImage tag = new BufferedImage((int)(Math.round(destWidth*imgrate)), (int)(Math.round(destHeight*imgrate)),  
                            BufferedImage.TYPE_INT_RGB);  
                    Graphics g = tag.getGraphics();  
                    g.drawImage(img, 0, 0, null); // 绘制缩小后的图  
                    g.dispose();  
                    // 输出为文件  
                    ImageIO.write(tag, "JPEG", new File(dirImageFile+imgFileId+ ".png"));  
                    
                    ImageCut.scale(dirImageFile+imgFileId+ ".png",dirImageFile+"640_"+imgFileId+".png",640,true);
                    ImageCut.scale(dirImageFile+imgFileId+ ".png",dirImageFile+"232_"+imgFileId+".png",232,true);
                    ImageCut.scale(dirImageFile+imgFileId+ ".png",dirImageFile+"172_"+imgFileId+".png",172,true);
                    
             //   }  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
      
          
        /** 
         * 缩放图像 
         *  
         * @param srcImageFile       源图像文件地址 
         * @param result             缩放后的图像地址 
         * @param scale              缩放比例 
         * @param flag               缩放选择:true 放大; false 缩小; 
         */  
        public static void scale(String srcImageFile, String result, int scale,  
                boolean flag) {  
            try {  
                BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件  
                int width = src.getWidth(); // 得到源图宽  
                int height = src.getHeight(); // 得到源图长  
              /*  if (flag) {  
                    // 放大  
                    width = width * scale;  
                    height = height * scale;  
                } else {  
                    // 缩小  
                    width = width / scale;  
                    height = height / scale;  
                }  */
                    
                height = height * scale/width;  
                width = scale;
               
                Image image = src.getScaledInstance(width, height,Image.SCALE_DEFAULT);  
                BufferedImage tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);  
                Graphics g = tag.getGraphics();  
                g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
                g.dispose();  
                ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
          
        /** 
         * 重新生成按指定宽度和高度的图像 
         * @param srcImageFile       源图像文件地址 
         * @param result             新的图像地址 
         * @param _width             设置新的图像宽度 
         * @param _height            设置新的图像高度 
         */  
        public static void scale(String srcImageFile, String result, int _width,int _height) {        
            scale(srcImageFile,result,_width,_height,0,0);  
        }  
          
        public static void scale(String srcImageFile, String result, int _width,int _height,int x,int y) {  
            try {  
                  
                BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件  
                  
                int width = src.getWidth(); // 得到源图宽  
                int height = src.getHeight(); // 得到源图长  
                  
                if (width > _width) {  
                     width = _width;  
                }  
                if (height > _height) {  
                    height = _height;  
                }             
                Image image = src.getScaledInstance(width, height,Image.SCALE_DEFAULT);  
                BufferedImage tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);  
                Graphics g = tag.getGraphics();  
                g.drawImage(image, x, y, null); // 绘制缩小后的图  
                g.dispose();              
                ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
          
        /** 
         * 图像类型转换 GIF->JPG GIF->PNG PNG->JPG PNG->GIF(X) 
         */  
        public static void convert(String source, String result) {  
            try {  
                File f = new File(source);  
                f.canRead();  
                f.canWrite();  
                BufferedImage src = ImageIO.read(f);  
                ImageIO.write(src, "JPG", new File(result));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
      
        /** 
         * 彩色转为黑白 
         *  
         * @param source 
         * @param result 
         */  
        public static void gray(String source, String result) {  
            try {  
                BufferedImage src = ImageIO.read(new File(source));  
                ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);  
                ColorConvertOp op = new ColorConvertOp(cs, null);  
                src = op.filter(src, null);  
                ImageIO.write(src, "JPEG", new File(result));  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }     
    }  