package com.java.sso.demoA;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.sso.demoA.utils.DemoATool;

@Controller
public class DemoAController {
	
	@RequestMapping("/demoA/main.action")
	public String main(HttpServletRequest request, Model mv){
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("sso_cookie")){
					String result=DemoATool.doGet("http://check.x.com/checkCookie", cookie.getName(), cookie.getValue());
					if(result.equals("1")){
						return "demoA";
					}
				}
			}
		}
		mv.addAttribute("gotoUrl","http://demoA.x.com/demoA/main.action");
		return "login";
	}
}
