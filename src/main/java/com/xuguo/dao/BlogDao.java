package com.xuguo.dao;

import java.util.List;
import java.util.Map;

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
	
	
	/**
	 * 分页查询博客
	 * @return
	 */
	public List<Blog> list(Map<String, Object> map);
	
	
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
}
