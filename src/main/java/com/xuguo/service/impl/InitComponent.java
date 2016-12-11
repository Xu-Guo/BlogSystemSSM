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
	
	
	//��ʼ��
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		//ͨ��ServletContextEvent��ȡapplication������
		ServletContext application = sce.getServletContext();	
		BloggerService bloggerService = (BloggerService) applicationContext.getBean("bloggerService");	
		Blogger blogger = bloggerService.find();//��ȡ������Ϣ	
		blogger.setPassword(null);//���������Ϣ
		application.setAttribute("blogger", blogger);//��Ӳ�����Ϣ��application��
		
		
		LinkService linkService = (LinkService) applicationContext.getBean("linkService");
		//��ѯ��������������Ϣ
		List<Link> linkList = linkService.list(null);//��ѯ��������������Ϣ
		application.setAttribute("linkList",linkList);
		
		BlogTypeService blogTypeService =(BlogTypeService) applicationContext.getBean("blogTypeService");
		List<BlogType> blogTypeCountList=blogTypeService.countList();//��ѯ��������Ѿ���������
		application.setAttribute("blogTypeCountList", blogTypeCountList);
		
		BlogService blogService =(BlogService) applicationContext.getBean("blogService");
		List<Blog> blogCountList=blogService.countList();//�������ڷ����ѯ����
		application.setAttribute("blogCountList", blogCountList);
		
	}
	
	
	//����
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	
	//��ȡȫ��application
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
	
}
