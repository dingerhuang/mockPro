package com.mock.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CommonUtil {

	/*
	 * 返回数字字母随机数 
	 */
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
	/*
	 * 返回当前时间毫秒
	 */
	public static String getTimeSss(){
		Calendar cal = Calendar.getInstance(); 
		Date date = cal.getTime();
		//String uid=new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(date);
		String timeSss=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
	
	     return timeSss;
	 }
	/*
	 * mock结果响应时间
	 */
	public static void thinkTime(String thkTime) throws InterruptedException{
		if (thkTime == null){
		}else
		{
			Thread.sleep(Integer.parseInt(thkTime));
		}
		
	}
}
