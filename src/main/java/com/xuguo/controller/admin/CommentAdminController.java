package com.xuguo.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.xuguo.entity.Comment;
import com.xuguo.entity.PageBean;
import com.xuguo.service.CommentService;
import com.xuguo.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * admin comment controller layer
 * @author xu
 *
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController {
	
	@Resource
	private CommentService commentService;
	
	
	/**
	 * search for comments and display in pages on admin pannel
	 * @param page
	 * @param rows
	 * @param state
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String List(@RequestParam(value="page", required=false) String page, @RequestParam(value="rows", required=false)String rows, @RequestParam(value="state", required=false)String state , HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("state", state); //comment state
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Comment> commentList = commentService.list(map);
		Long total = commentService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(commentList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * Comments review
	 * @param ids
	 * @param state
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/review")
	public String review(@RequestParam(value="ids", required=false)String ids, @RequestParam(value="state", required=false)Integer state,  HttpServletResponse response)throws Exception{
		String[] idsStr=ids.split(",");
		for(int i = 0; i < idsStr.length; i++){
			Comment comment = new Comment();
			comment.setId(Integer.parseInt(idsStr[i]));
			comment.setState(state);
			commentService.update(comment);

		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;

	}
	
}
