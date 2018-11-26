package com.java.sso.childsystemB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.sso.utils.LoginUtil;

@Controller
public class DemoB {
	@RequestMapping("/demoB/main.action")
	public String main(HttpServletRequest request,Model mv){
		if(LoginUtil.checkLogin(request)){
			return "demoB";
		}
		mv.addAttribute("gotoUrl","demoB");
		return "login";
	}
}
