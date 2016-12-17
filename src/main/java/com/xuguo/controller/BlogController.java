package com.xuguo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xuguo.entity.Blog;
import com.xuguo.entity.Comment;
import com.xuguo.service.BlogService;
import com.xuguo.service.CommentService;
import com.xuguo.util.StringUtil;

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
	
	@Resource
	private CommentService commentService;
	
	
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
		String keyWords = blog.getKeyWord();
		
		if(StringUtil.isNotEmpty(keyWords)){
			//get keyWord set and pass to view          
			String[] arr = keyWords.split(" ");		
			modelAndView.addObject("keyWords",StringUtil.filterWhite(Arrays.asList(arr)));
		}else{
			modelAndView.addObject("keyWords",null);
		}

		modelAndView.addObject("blog",blog);
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogId", blog.getId());
		map.put("state", 1);
		List<Comment> list = commentService.list(map);

		modelAndView.addObject("commentList",commentService.list(map));
		modelAndView.addObject("pageCode",this.getUpAndDownPageCode(blogService.getLastBlog(id),blogService.getNextBlog(id),request.getServletContext().getContextPath()));
		modelAndView.addObject("pageTitle", blog.getTitle()+"java open source blog system");
		modelAndView.addObject("mainPage", "foreground/blog/view.jsp");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
	
	/**
	 * get last and next blog pageCode
	 * @param lastBlog
	 * @param nextBlog
	 * @param projectContext
	 * @return
	 */
	private String getUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String projectContext){
		
		StringBuffer pageCode = new StringBuffer();
		if(lastBlog==null||lastBlog.getId()==null){
			pageCode.append("<p><font><strong>Last Blog:</font></strong> None</p>");
		}else{
			pageCode.append("<p><font><strong>Last Blog:</font></strong> <a herf='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
		}
		if(nextBlog==null||nextBlog.getId()==null){
			pageCode.append("<p><font><strong>Next Blog:</font></strong> None</p>");
		}else{
			pageCode.append("<p><font><strong>Next Blog:</font></strong> <a herf='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
}
