package com.xuguo.service;

import java.util.List;

import com.xuguo.entity.Blog;

/**
 * 博客Service接口
 * @author xu
 *
 */
public interface BlogService {
	/**
	 * 根据日期分月分组查询
	 * @return
	 */
	public List<Blog> countList();
}
