package com.xuguo.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xuguo.entity.Blog;
import com.xuguo.entity.BlogType;
import com.xuguo.entity.PageBean;
import com.xuguo.service.BlogService;
import com.xuguo.service.BlogTypeService;
import com.xuguo.util.ResponseUtil;
import com.xuguo.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * admin blogType controller
 * @author xu
 *
 */
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {
	
	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource
	private BlogService blogService;
	
	/**
	 * search for blogTypes and display in pages on admin pannel
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String List(@RequestParam(value="page", required=false) String page, @RequestParam(value="rows", required=false)String rows, 
			HttpServletResponse response) throws Exception{
		
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<BlogType> blogTypeList = blogTypeService.list(map);
		Long total = blogTypeService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(blogTypeList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * add/update blogType information
	 * @param blogType
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(BlogType blogType, HttpServletResponse response) throws Exception{
		int resultTotal = 0;
		if(blogType.getId()==null){
			resultTotal = blogTypeService.add(blogType);			
		}else{
			resultTotal = blogTypeService.update(blogType);
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
	 * delete blogType
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response)throws Exception{
		String[] idsStr=ids.split(",");
		JSONObject result = new JSONObject();
		for(int i = 0; i < idsStr.length; i++){
			if(blogService.getBlogCountByTypeId(Integer.parseInt(idsStr[i]))>0){
				result.put("exist", "Found blog under this blog type, delete denied!");
			}else{
				blogTypeService.delete(Integer.parseInt(idsStr[i]));				
			}
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
