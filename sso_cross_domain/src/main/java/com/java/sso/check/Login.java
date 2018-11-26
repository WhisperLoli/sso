package com.java.sso.check;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.sso.utils.LoginUtil;
/**
 * 当前包代表站点www.check.com
 * @author HNJ
 *
 */
@Controller
@RequestMapping("/sso")
public class Login {
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("/checkCookie")
	public void checkCookie(@RequestParam("cookieName") String cookieName,@RequestParam("cookieValue") String cookieValue) throws IOException{
		String result="0";
		if(LoginUtil.checkLogin(cookieName, cookieValue)){
			result="1";
		}
		response.getWriter().print(result);
		response.getWriter().close();
	}
	
	@RequestMapping("/doLogin")
	public void doLogin(@RequestParam("username") String username,@RequestParam("password") String password) throws IOException{
		boolean ok = LoginUtil.doLogin(username, password);
		String result="0";
		if(ok){
			result="1";
		}
		response.getWriter().println(result);
		response.getWriter().close();
	}
}
