package com.xuguo.service;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.BlogType;

/**
 * blog type Service interface
 * @author xu
 *
 */
public interface BlogTypeService {
	
	/**
	 * search all the blogType and corresponding numbers of blogs
	 */
	public List<BlogType> countList();
	
	/**
	 * search all blogType with paging
	 * @param map
	 * @return
	 */
	public List<BlogType> list(Map<String, Object> map);
	
	/**
	 * get total number of blogTypes
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
}
