package com.xuguo.controller.admin;
/*
 * admin controller
 */

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xuguo.entity.Blogger;
import com.xuguo.service.BloggerService;
import com.xuguo.util.CryptographyUtil;
import com.xuguo.util.DateUtil;
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
	
	/**
	 * edit blogger information
	 * @param imageFile
	 * @param blogger
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(@RequestParam(value="imageFile") MultipartFile imageFile, Blogger blogger,HttpServletRequest request, HttpServletResponse response)throws Exception{
		if(!imageFile.isEmpty()){
			String filePath = request.getServletContext().getRealPath("/");
			String imageName = DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
			imageFile.transferTo(new File(filePath+"static/userImages/" + imageName));
			blogger.setImageName(imageName);
		}
		int resultTotal = bloggerService.update(blogger);
		StringBuffer result = new StringBuffer();
		if(resultTotal>0){
			result.append("<script language='javascript'>alert('Edit success!');</script>");
		}else{
			result.append("<script language='javascript'>alert('Edit Failed!');</script>");
		}
		ResponseUtil.write(response, result.toString());
		return null;
	}
	
	/**
	 * change password
	 * @param newPassword
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(String newPassword, HttpServletResponse response)throws Exception{
		Blogger blogger = new Blogger();
		blogger.setPassword(CryptographyUtil.md5(newPassword, "java1234"));
		int resultTotal = bloggerService.update(blogger);
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
