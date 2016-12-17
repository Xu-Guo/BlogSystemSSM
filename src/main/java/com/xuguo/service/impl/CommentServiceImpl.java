package com.xuguo.service.impl;

import java.util.List; 
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xuguo.dao.CommentDao;

import com.xuguo.entity.Comment;

import com.xuguo.service.CommentService;



/**
 * Comment Service implementation
 * @author xu
 *
 */
@Service("CommentService")
public class CommentServiceImpl implements CommentService{
	
	@Resource
	CommentDao commentDao;
	
	
	/**
	 * get user comment information
	 * @param map
	 * @return
	 */
	public List<Comment> list(Map<String, Object> map) {
		return commentDao.list(map);
	}

}
