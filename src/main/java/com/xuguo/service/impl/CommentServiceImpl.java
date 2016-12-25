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
	private CommentDao commentDao;
	
	
	/**
	 * get user comment information
	 * @param map
	 * @return
	 */
	public List<Comment> list(Map<String, Object> map) {
		return commentDao.list(map);
	}

	/**
	 * add comment
	 * @param comment
	 * @return
	 */
	public int add(Comment comment) {
		return commentDao.add(comment);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return commentDao.getTotal(map);
	}

	@Override
	public int update(Comment comment) {		
		return commentDao.update(comment);
	}

	@Override
	public Integer delete(Integer id) {
		return commentDao.delete(id);
	}

}
