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
	
}