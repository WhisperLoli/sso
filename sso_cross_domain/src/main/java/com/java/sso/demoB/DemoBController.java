package com.java.sso.demoB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.java.sso.demoB.utils.DemoBTool;
import com.java.sso.utils.LoginUtil;

@Controller
@RequestMapping("/demoB")
public class DemoBController {
	
	@RequestMapping("/main.action")
	public String main(HttpServletRequest request, Model mv){
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("sso_cookie")){
					Map<String, String> map=new HashMap<String, String>();
					map.put("cookieName", cookie.getName());
					map.put("cookieValue", cookie.getValue());
					String result=DemoBTool.doGet("http://www.check.com/sso/checkCookie", map);
					if(result.equals("1")){
						return "demoB";
					}
				}
			}
		}
		mv.addAttribute("gotoUrl","http://www.demoB.com/demoB/main.action");
		mv.addAttribute("path","demoB");
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String username,@RequestParam String password,Model model) throws IOException{
		Map<String, String> map=new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		String result=DemoBTool.doGet("http://www.check.com/sso/doLogin", map);
		List<String> hiddenUrl=new ArrayList<String>();
		if(result.equals("1")){
			hiddenUrl.add("http://www.demoA.com/demoA/addCookie");
			hiddenUrl.add("http://www.demoB.com/demoB/addCookie");
			model.addAttribute("hiddenUrl", hiddenUrl);
			return "demoB";
		}
		model.addAttribute("gotoUrl","http://www.demoB.com/demoB/main.action");
		return "login";
	}
	
	@RequestMapping("/addCookie")
	public void addCookie(){
		Cookie cookie=new Cookie("sso_cookie", LoginUtil.ssoValue);
		cookie.setPath("/");
		HttpServletResponse response=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		response.addCookie(cookie);
	}
}
