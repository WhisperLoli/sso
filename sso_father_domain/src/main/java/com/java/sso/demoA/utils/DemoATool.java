package com.java.sso.demoA.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DemoATool {
	public static String doGet(String url,String cookieName,String cookieValue){
		StringBuilder sb=new StringBuilder();
		HttpURLConnection httpURLConnection=null;
		try {
			URL urls=new URL(url+"?cookieName="+cookieName+"&cookieValue="+cookieValue);
			httpURLConnection=(HttpURLConnection) urls.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.connect();
			InputStreamReader ir=new InputStreamReader(httpURLConnection.getInputStream());
			BufferedReader br=new BufferedReader(ir);
			String temp=null;
			while((temp=br.readLine())!=null){
				sb.append(temp);
			}
			br.close();
			ir.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(httpURLConnection!=null){
				httpURLConnection.disconnect();
			}
		}
		return sb.toString();
	}
}
