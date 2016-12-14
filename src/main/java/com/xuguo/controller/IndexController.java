package com.xuguo.controller;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xuguo.entity.Blog;
import com.xuguo.entity.PageBean;
import com.xuguo.service.BlogService;
import com.xuguo.util.PageUtil;
import com.xuguo.util.StringUtil;

/**
 * home page controller
 * @author xu
 *
 */

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Resource
	private BlogService blogService;
	
	/**
	 * request home page
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="page",required=false)String page,HttpServletRequest request)throws Exception{
		ModelAndView modelAndView =new ModelAndView();
		
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		PageBean pageBean= new PageBean(Integer.parseInt(page), 10);
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Blog> blogList = blogService.list(map);
		
		for(Blog blog:blogList){
			List<String> imageList=blog.getImageList();//get imageName list
			String blogInfo=blog.getContent();
			//System.out.println(blogInfo);
			Document doc=Jsoup.parse(blogInfo);
			Elements jpgs=doc.select("img[src$=.jpg]");//后缀是。jpg的元素
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i);
				imageList.add(jpg.toString());
				if(i==2){//只显示3张图片
					break;
				}
			}
		}
		
		
		modelAndView.addObject("blogList", blogList);
		
		StringBuffer param=new StringBuffer();
		modelAndView.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/index.html", blogService.getTotal(map), Integer.parseInt(page), 10, param.toString()));
		
		modelAndView.addObject("pageTitle", "java open source blog system");
		modelAndView.addObject("mainPage", "foreground/blog/list.jsp");
		modelAndView.setViewName("mainTemp");
		
		return modelAndView;
	}
}
