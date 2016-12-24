package com.xuguo.controller.admin;
/*
 * admin controller
 */

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xuguo.entity.Blogger;
import com.xuguo.service.BloggerService;
import com.xuguo.util.ResponseUtil;

import net.sf.json.JSONObject;
/**
 * blogger admin controller
 * @author xu
 *
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {
	
	@Resource
	private BloggerService bloggerService;
	
	/**
	 * get blog information
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/find")
	public String find(HttpServletResponse response)throws Exception{
		Blogger blogger = bloggerService.find();
		JSONObject jsonObject = JSONObject.fromObject(blogger);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
