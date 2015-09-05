package com.wolf.hr.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

public class UploadUtils {
	
	public static String saveUploadFile(File upload){
		//把日期格式化成字符串的一个帮助类 
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		/*
		 * 得到upload文件夹的绝对路径
		 * ServletActionContext.getServletContext()
		 * =
		 * C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\itcastoa823\WEB-INF/upload/2012\02\16\aaaaadfasdf
		 */
		String basePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		//把日期类型格式化为"/yyyy/MM/dd/"这种形式的字符串
		String subPath = sdf.format(new Date());
		//如果文件夹不存在，就创建文件夹
		File dir = new File(basePath+subPath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		//String path = basePath+"/"+this.uploadFileName;
		//UUID.randomUUID().toString()能够保证名字的唯一性
		String path = basePath+subPath+UUID.randomUUID().toString();
		File dest = new File(path);
		//把文件移动到dest处
		upload.renameTo(dest);
		return path;
	}
}
