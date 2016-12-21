package com.xuguo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;

import com.xuguo.entity.Blog;
import com.xuguo.service.BlogService;
import com.xuguo.util.ResponseUtil;

import net.sf.json.JSONObject;

/**
 * admin blog controller
 * @author xu
 *
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	
	@Resource
	private BlogService blogService;
	
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response) throws Exception{
		int resultTotal = 0;
		if(blog.getId()==null){
			resultTotal = blogService.add(blog);
		}else{
			
		}
		
		JSONObject result = new JSONObject();
		if(resultTotal > 0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
}
