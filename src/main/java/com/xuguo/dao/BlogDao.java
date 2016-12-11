package com.xuguo.dao;

import java.util.List;

import com.xuguo.entity.Blog;

/**
 * 博客DAO接口
 * @author xu
 *
 */
public interface BlogDao {

	/**
	 * 根据日期分月分组查询
	 * @return
	 */
	public List<Blog> countList();
}
