package com.xuguo.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.xuguo.entity.Blog;
import com.xuguo.entity.BlogType;
import com.xuguo.entity.Blogger;
import com.xuguo.entity.Link;
import com.xuguo.service.BlogService;
import com.xuguo.service.BlogTypeService;
import com.xuguo.service.BloggerService;
import com.xuguo.service.LinkService;
import com.xuguo.util.ResponseUtil;

import net.sf.json.JSONObject;

/**
 * admin system controller layer
 * @author xu
 *
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {
	
	@Resource
	private BloggerService bloggerService;
	
	@Resource
	private LinkService linkService;
	
	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource
	private BlogService blogService;
	
	/**
	 * refresh system application cache
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/refreshSystem")
	public String refreshSystem(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ServletContext application = RequestContextUtils.getWebApplicationContext(request).getServletContext();
		
		Blogger blogger = bloggerService.find();//find blogger information
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);
		
		List<Link> linkList = linkService.list(null);//find all friend links information
		application.setAttribute("linkList", linkList);
		
		List<BlogType> blogTypeCountList = blogTypeService.countList();//find all blogtype and count the number of blogs under them

		application.setAttribute("blogTypeCountList", blogTypeCountList);
		
		List<Blog> blogCountList = blogService.countList();//find all blogs by publish date
		application.setAttribute("blogCountList", blogCountList);
		
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
