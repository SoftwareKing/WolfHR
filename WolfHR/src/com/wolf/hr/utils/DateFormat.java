package com.wolf.hr.utils;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
 

  
public class DateFormat{  
  
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
  
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
   public static  String marshal(Date date) throws Exception {  
       return dateFormat.format(date);  
    }    
   
    public static String toStringWork(Date date){ //上一月 
    	String dateString = DateFormat.replace(date) ;
    	String [] ds = dateString.split("-") ;
    	Integer month = date.getMonth() ;
    	Integer year = date.getYear()+1900 -1 ; 
    	if(month == 0){
    		month = 12 ;
    		
    		ds[0] = year.toString() ;
    		ds[1] = month.toString() ;
    	} else if(month<10){
    			ds[1] = "0"+month.toString() ;
    	}else {
    		ds[1] = month.toString() ;
    	}
    	StringBuffer sb = new StringBuffer() ;
    	for (int i = 0; i < ds.length; i++) {
			
    		sb.append(ds[i]);
    		if(i < ds.length-1 ){
    			sb.append("-");
    		} 
		}
    	System.out.println("work : "+sb.toString());
    	return sb.toString();
    }
    public static String replace(Date date){
    	return format.format(date);
    }
    public static String toStringMonth(Date date){ //当月
    	String dateString = DateFormat.replace(date) ;
    	String [] ds = dateString.split("-") ;
    	Integer month = date.getMonth() +1 ;
    	Integer year = date.getYear()+1900 ; 
    	if(month<10){
    			ds[1] = "0"+month.toString() ;
    	}else {
    		ds[1] = month.toString() ;
    	}
    	StringBuffer sb = new StringBuffer() ;
    	for (int i = 0; i < ds.length; i++) {
			
    		sb.append(ds[i]);
    		if(i < ds.length-1 ){
    			sb.append("-");
    		} 
		}
    	System.out.println("month : " + sb.toString());
    	return sb.toString();
    }
    
}  
