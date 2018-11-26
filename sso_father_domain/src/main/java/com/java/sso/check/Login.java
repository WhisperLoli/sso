package com.java.sso.check;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.java.sso.utils.LoginUtil;

@Controller
public class Login {
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("/doLogin")
	public String main(@RequestParam String username,@RequestParam String password,@RequestParam String gotoUrl){
		if(LoginUtil.doLogin(username, password)){
			Cookie cookie = new Cookie("sso_cookie", LoginUtil.ssoValue);
			cookie.setPath("/");
			cookie.setDomain("x.com");
			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
			ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes) requestAttributes;
			servletRequestAttributes.getResponse().addCookie(cookie);
			return "redirect:"+gotoUrl;
		}
		return null;
	}
	
	@RequestMapping("/checkCookie")
	public void checkCookie(@RequestParam String cookieName,@RequestParam String cookieValue) throws IOException{
		String result="0";
		if(LoginUtil.checkLogin(cookieName, cookieValue)){
			result="1";
		}
		response.getWriter().print(result);
		response.getWriter().close();
	}
}
