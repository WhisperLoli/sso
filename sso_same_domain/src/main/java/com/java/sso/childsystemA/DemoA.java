package com.java.sso.childsystemA;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.sso.utils.LoginUtil;

@Controller
public class DemoA {
	
	@RequestMapping("/demoA/main.action")
	public String main(HttpServletRequest request, Model mv){
		if(LoginUtil.checkLogin(request)){
			return "demoA";
		}
		mv.addAttribute("gotoUrl","demoA");
		return "login";
	}
}
