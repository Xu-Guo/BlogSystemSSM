package com.xuguo.service;

import java.util.List;

import com.xuguo.entity.BlogType;

/**
 * 博客类型Service接口
 * @author xu
 *
 */
public interface BlogTypeService {
	
	/**
	 * 查询所有博客类型
	 */
	public List<BlogType> countList();
}
