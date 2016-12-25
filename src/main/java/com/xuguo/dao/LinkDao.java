package com.xuguo.dao;

import java.util.List; 
import java.util.Map;


import com.xuguo.entity.Link;

/**
 * friend link dao interface
 * @author xu
 *
 */
public interface LinkDao {
	/**
	 * find friend link information in database
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object>map);
	
	
	/**
	 * add friend link
	 * @param comment
	 * @return
	 */
	public int add(Link link);
	
	/**
	 * get total number of friend links
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * Edit friend link
	 * @param comment
	 * @return
	 */
	public int update(Link link);
	
	/**
	 * delete friend link
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
}