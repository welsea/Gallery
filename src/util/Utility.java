package util;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.*;
import java.security.spec.ECField;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utility {
	/*
	 * ��ȡ�ַ���
	 */
	public  static String SubString(String input,int len) {
		if(DataValidator.isNullOrEmpty(input))
			return "";
		if(len>=input.length())
			return input;
		return input.substring(0,len);
	}
	
	/*
	 * ��ȡ��ǰʱ��
	 */
	public static Date getNowDateTime() {
		Calendar calendar=Calendar.getInstance();
		String now=calendar.get(Calendar.YEAR)+"-"
				+(calendar.get(Calendar.MONTH)+1)+"-"
				+calendar.get(Calendar.DATE)+" "
				+calendar.get(Calendar.HOUR)+":"
				+calendar.get(Calendar.MINUTE)+":"
				+calendar.get(Calendar.SECOND);
		return DataConverter.toDate(now,"yyyy-MM-dd HH:mm:ss");
	}
	/*
	 * ��ǰ����
	 */
	public static Date getNowDate() {
		Calendar calendar=Calendar.getInstance();
		String now=calendar.get(Calendar.YEAR)+"-"
				+(calendar.get(Calendar.MONTH)+1)+"-"
				+calendar.get(Calendar.DATE);
		return DataConverter.toDate(now,"yyyy-MM-dd");
	}

	/*
	 * д��cookie
	 * 
	 */
	public static void writeCookie(HttpServletResponse response,String key,String value) {
		writeCookie(response, key, value,-1);
	}
	
	/*
	 * д��cookie
	 * 
	 */
	public static void writeCookie(HttpServletResponse response,String key,String value,int exprise) {
		Cookie newCookie=new Cookie(key, value);
		if(exprise>0)
			exprise=exprise*60;
		newCookie .setPath("/");
		newCookie.setMaxAge(exprise);
		response.addCookie(newCookie);
	}
	
	/*
	 * ��ȡcookie
	 */
	public static String readCookie(HttpServletRequest request,String key) {
		String value="";
		Cookie[] ck=request.getCookies();
		if(ck==null){
			return "";
		}
		for(Cookie c:ck){
			if(c.getName().equals(key)) {
				value=c.getValue();
				break;
			}
		}
		return value;
	}
	
}
