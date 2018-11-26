package com.java.sso.utils;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class LoginUtil {
	private static String username="user";
	private static String password="123";
	public static String ssoValue=UUID.randomUUID().toString();
	
	public static boolean doLogin(String username,String password){
		if(LoginUtil.username.equals(username) 
				&& LoginUtil.password.equals(password)){
			return true;
		}
		return false;
	}
	
	public static boolean checkLogin(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("sso_cookie")
						&& cookie.getValue().equals(ssoValue)){
					return true;
				}
			}
		}
		return false;
	}
}
