package util;

import java.text.*;
import java.util.*;

public class DataConverter {
	/*
	 * ��ʽ�����ڣ�תΪ�ַ���
	 */
	
	public static String dataToString(Date date){
		return dataToString(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	public static String dataToString(Date date,String formatType) {
		if(date==null){
			date=Utility.getNowDateTime();
		}
		SimpleDateFormat formatter=new SimpleDateFormat(formatType);
		return formatter.format(date);
	}
	
	/*
	 * �ַ���ת����
	 */
	public static Date toDate(String input) {
		return toDate(input,"yyyy-MM-dd HH:mm:ss");
	}
	public static Date toDate(String input,String formetType) {
		SimpleDateFormat format=new SimpleDateFormat(formetType);
		Date dt=new Date();
		if(DataValidator.isNullOrEmpty(input)){
			return dt;
		}
		try{
		dt=format.parse(input);
		}catch (ParseException e) {
			// TODO: handle exception
		}
		return dt;
	}
	
	/*
	 * �����ڸ�ʽ
	 */
	public static java.util.Date toShortDate(String input){
		return toDate(input,"yyyy-MM-dd");
	}
	
	/*
	 * �����ڸ�ʽ
	 */
	public static java.util.Date toFullDate(String input){
		return toDate(input,"yyyy-MM-dd HH:mm:ss");
	}
	
	/*
	 * �ַ���תΪint
	 */
	public static int  toInt(String input) {
		try{
			return Integer.parseInt(input);
		}catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}

}
