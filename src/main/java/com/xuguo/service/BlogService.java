package com.xuguo.service;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.Blog;

/**
 * Blog service interface
 * @author xu
 *
 */
public interface BlogService {
	/**
	 * group search by month in date
	 * @return
	 */
	public List<Blog> countList();
	
	
	
	/**
	 * search by page
	 * @return
	 */
	public List<Blog> list(Map<String, Object> map);
	
	
	
	/**
	 * get total number of pages
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	
	/**
	 * get blog entity by id
	 * @param id
	 * @return
	 */
	public Blog findById(Integer id);
	
	/**
	 * update blog information
	 * @param blog
	 * @return
	 */
	public Integer update(Blog blog);
	
	/**
	 * get Last blog
	 * @param id
	 * @return
	 */
	public Blog getLastBlog(Integer id);
	
	
	/**
	 * get next blog
	 * @param id
	 * @return
	 */
	public Blog getNextBlog(Integer id);
	
	/**
	 * Add new blog
	 * @param blog
	 * @return
	 */
	public Integer add(Blog blog);
}
