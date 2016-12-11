package com.xuguo.dao;

import java.util.List;

import com.xuguo.entity.BlogType;

/**
 * 博客类型DAO接口
 * @author xu
 *
 */
public interface BlogTypeDao {
	
	/**
	 * 查询所有博客类型，已经对应的博客数量
	 */
	public List<BlogType> countList();
}
