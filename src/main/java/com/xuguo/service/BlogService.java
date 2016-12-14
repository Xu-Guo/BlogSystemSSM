package com.xuguo.service;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.Blog;

/**
 * ²©¿ÍService½Ó¿Ú
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
}
