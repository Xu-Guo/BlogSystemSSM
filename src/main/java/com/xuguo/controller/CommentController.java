package com.xuguo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xuguo.entity.Blog;
import com.xuguo.entity.Comment;
import com.xuguo.service.BlogService;
import com.xuguo.service.CommentService;
import com.xuguo.util.ResponseUtil;

import net.sf.json.JSONObject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * comment controller layer
 * @author xu
 *
 */

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Resource
	private CommentService commentService;
	
	@Resource
	private BlogService blogService;
	
	/**
	 * add or update comment
	 * @param comment
	 * @param imageCode
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(Comment comment,@RequestParam("imageCode") String imageCode, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		String sRand = (String) session.getAttribute("sRand"); //get correct Verify coder
		JSONObject result = new JSONObject();
		int resultTotal = 0;
		if(!imageCode.equals(sRand)){
			result.put("success", false);
			result.put("errorInfo", "verify code is wrong.");
		}else{
			String userIp = request.getRemoteAddr();//get user ip
			comment.setUserIp(userIp);
			if(comment.getId()==null){
				resultTotal = commentService.add(comment);				
				//increment ReplyHit
				Blog blog = blogService.findById(comment.getBlog().getId());
				blog.setReplyHit(blog.getReplyHit()+1);
				blogService.update(blog);
			}else{
				
			}
		}
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		
		return null;
	}
}
