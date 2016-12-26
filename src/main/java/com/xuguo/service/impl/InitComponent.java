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
	
	
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		//get applicationContext using ServletContextEvent
		ServletContext application = sce.getServletContext();	
		BloggerService bloggerService = (BloggerService) applicationContext.getBean("bloggerService");	
		Blogger blogger = bloggerService.find();//get blogger information
		blogger.setPassword(null);//reset password
		application.setAttribute("blogger", blogger);//add blogger information into application
		
		
		LinkService linkService = (LinkService) applicationContext.getBean("linkService");
		//find all friend link information
		List<Link> linkList = linkService.list(null);// search all friend link information
		application.setAttribute("linkList",linkList);
		
		BlogTypeService blogTypeService =(BlogTypeService) applicationContext.getBean("blogTypeService");
		List<BlogType> blogTypeCountList=blogTypeService.countList();//find blogType and numbers of blogs
		application.setAttribute("blogTypeCountList", blogTypeCountList);
		
		BlogService blogService =(BlogService) applicationContext.getBean("blogService");
		List<Blog> blogCountList=blogService.countList();//find blogs grouped by releaseDate
		application.setAttribute("blogCountList", blogCountList);
		
	}
	
	
	//destroyed
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	
	//get application
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
	
}
