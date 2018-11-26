package com.java.sso.utils;

import java.util.UUID;


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
	
	public static boolean checkLogin(String cookieName,String cookieValue){
		if(cookieName.equals("sso_cookie")
				&& cookieValue.equals(ssoValue)){
			return true;
		}
		return false;
	}
}
