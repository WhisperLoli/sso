package com.java.sso.demoB;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.sso.demoB.utils.DemoBTool;

@Controller
public class DemoBController {
	
	@RequestMapping("/demoB/main.action")
	public String main(HttpServletRequest request, Model mv){
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("sso_cookie")){
					String result=DemoBTool.doGet("http://check.x.com/checkCookie", cookie.getName(), cookie.getValue());
					if(result.equals("1")){
						return "demoB";
					}
				}
			}
		}
		mv.addAttribute("gotoUrl","http://demoB.x.com/demoB/main.action");
		return "login";
	}
}
