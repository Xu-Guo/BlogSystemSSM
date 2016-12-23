package com.xuguo.controller.admin;


import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;

import com.xuguo.entity.Blog;
import com.xuguo.entity.PageBean;
import com.xuguo.lucene.BlogIndex;
import com.xuguo.service.BlogService;
import com.xuguo.util.ResponseUtil;
import com.xuguo.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

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
	
	private BlogIndex blogIndex = new BlogIndex();
	
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response) throws Exception{
		int resultTotal = 0;
		if(blog.getId()==null){
			resultTotal = blogService.add(blog);
			blogIndex.addIndex(blog);
			
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
	
	/**
	 * search for blogs and display in pages on admin pannel
	 * @param page
	 * @param rows
	 * @param s_blog
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String List(@RequestParam(value="page", required=false) String page, 
			@RequestParam(value="rows", required=false)String rows, Blog s_blog, HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("title", StringUtil.formatLike(s_blog.getTitle()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Blog> blogList = blogService.list(map);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+blogList.size() +"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		for (Blog blog : blogList) {
			System.out.println(blog.getTitle());
		}
		Long total = blogService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(blogList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	/**
	 * delete blog
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response)throws Exception{
		String[] idsStr=ids.split(",");
		for(int i = 0; i < idsStr.length; i++){
			blogService.delete(Integer.parseInt(idsStr[i]));
			blogIndex.deleteIndex(idsStr[i]);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
