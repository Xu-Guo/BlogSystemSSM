package com.xuguo.service;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.Blog;
import com.xuguo.entity.Comment;

/**
 * Comment Service interface
 * @author xu
 *
 */
public interface CommentService {


	/**
	 * get user comment information
	 * @param map
	 * @return
	 */
	public List<Comment> list(Map<String, Object> map);
	
	/**
	 * add comment
	 * @param comment
	 * @return
	 */
	public int add(Comment comment);
	
	/**
	 * get total number of comments
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * Edit comments
	 * @param comment
	 * @return
	 */
	public int update(Comment comment);
}
