package com.xuguo.service.impl;

import java.util.List;

import javax.servlet.ServletContext; 
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.xuguo.entity.Blog;
import com.xuguo.entity.BlogType;
import com.xuguo.entity.Blogger;
import com.xuguo.entity.Link;
import com.xuguo.service.BlogService;
import com.xuguo.service.BlogTypeService;
import com.xuguo.service.BloggerService;
import com.xuguo.service.LinkService;



@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{
	
	
	
	private static ApplicationContext applicationContext;
	
	
	//初始化
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		//通过ServletContextEvent获取application上下文
		ServletContext application = sce.getServletContext();	
		BloggerService bloggerService = (BloggerService) applicationContext.getBean("bloggerService");	
		Blogger blogger = bloggerService.find();//获取博主信息	
		blogger.setPassword(null);//清空密码信息
		application.setAttribute("blogger", blogger);//添加博主信息到application中
		
		
		LinkService linkService = (LinkService) applicationContext.getBean("linkService");
		//查询所有友情链接信息
		List<Link> linkList = linkService.list(null);//查询所有友情链接信息
		application.setAttribute("linkList",linkList);
		
		BlogTypeService blogTypeService =(BlogTypeService) applicationContext.getBean("blogTypeService");
		List<BlogType> blogTypeCountList=blogTypeService.countList();//查询博客类别已经博客数量
		application.setAttribute("blogTypeCountList", blogTypeCountList);
		
		BlogService blogService =(BlogService) applicationContext.getBean("blogService");
		List<Blog> blogCountList=blogService.countList();//根据日期分组查询博客
		application.setAttribute("blogCountList", blogCountList);
		
	}
	
	
	//销毁
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	
	//获取全局application
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
	
}
