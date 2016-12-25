package com.xuguo.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.xuguo.entity.Link;
import com.xuguo.entity.PageBean;
import com.xuguo.service.LinkService;
import com.xuguo.util.ResponseUtil;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * admin Link controller
 * @author xu
 *
 */
@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {
	
	@Resource
	private LinkService LinkService;
	
	
	/**
	 * search for Links and display in pages on admin pannel
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page", required=false) String page, @RequestParam(value="rows", required=false)String rows, 
			HttpServletResponse response) throws Exception{
		
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Link> LinkList = LinkService.list(map);
		Long total = LinkService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(LinkList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * add/update Link information
	 * @param Link
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Link Link, HttpServletResponse response) throws Exception{
		int resultTotal = 0;
		if(Link.getId()==null){
			resultTotal = LinkService.add(Link);			
		}else{
			resultTotal = LinkService.update(Link);
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
	 * delete Link
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
			LinkService.delete(Integer.parseInt(idsStr[i]));
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
