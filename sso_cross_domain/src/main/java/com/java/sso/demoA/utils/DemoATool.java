package com.java.sso.demoA.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class DemoATool {
	public static String doGet(String url,Map<String, String> map){
		StringBuilder sb=new StringBuilder();
		HttpURLConnection httpURLConnection=null;
		try {
			StringBuilder sBuilder=new StringBuilder(url).append("?");
			for (Map.Entry<String, String> entry : map.entrySet()) {
				sBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
			url= sBuilder.substring(0, sBuilder.length()-1);
			URL urls=new URL(url);
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
