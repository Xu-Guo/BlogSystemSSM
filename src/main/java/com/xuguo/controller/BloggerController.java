package com.xuguo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xuguo.entity.Blogger;
import com.xuguo.service.BloggerService;
import com.xuguo.util.CryptographyUtil;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	
	@Resource
	private BloggerService blogServise;
	
	@RequestMapping("/login")
	public String login(Blogger blogger,HttpServletRequest request){
		System.out.println("%%%%%login Controller!!%%%%%%");
		//获取当前登录的用户
		Subject subject = SecurityUtils.getSubject();
		//生成token
		UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "java1234"));
		try{
			subject.login(token);//登陆验证，调用Myrealm中的方法
			return "redirect:/admin/main.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("blogger", blogger);
			request.setAttribute("errorInfo", "Username or password is wrong!!");
			return "login";	
		}
	}
}
