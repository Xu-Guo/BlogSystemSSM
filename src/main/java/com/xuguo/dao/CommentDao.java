package com.xuguo.dao;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.Comment;

/**
 * CommentDao interface
 * @author xu
 *
 */
public interface CommentDao {
	
	/**
	 * get user comment information
	 * @param map
	 * @return
	 */
	public List<Comment> list(Map<String, Object> map);
}
