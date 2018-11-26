package com.java.sso.login;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.java.sso.utils.LoginUtil;

@Controller
public class Login {
	
	@RequestMapping("/doLogin")
	public String main(@RequestParam String username,@RequestParam String password,@RequestParam String gotoUrl){
		if(LoginUtil.doLogin(username, password)){
			Cookie cookie = new Cookie("sso_cookie", LoginUtil.ssoValue);
			cookie.setPath("/");
			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
			ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes) requestAttributes;
			servletRequestAttributes.getResponse().addCookie(cookie);
			return "redirect:/"+gotoUrl;
		}
		return null;
	}
}
