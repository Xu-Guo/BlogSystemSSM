package com.xuguo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xuguo.entity.Blog;
import com.xuguo.service.BlogService;

/**
 * blog controller layer
 * @author xu
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource
	private BlogService blogService;
	
	/**
	 * request blog detail information
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id") Integer id, HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Blog blog = blogService.findById(id);
		System.out.println(blog.getTitle());
		
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
		
		modelAndView.addObject("blog",blog);
		
		modelAndView.addObject("pageTitle", blog.getTitle()+"java open source blog system");
		modelAndView.addObject("mainPage", "foreground/blog/view.jsp");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
}
