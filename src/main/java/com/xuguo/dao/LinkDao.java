package com.xuguo.dao;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.Link;

/**
 * 友情链接DAO
 * @author xu
 *
 */
public interface LinkDao {
	/**
	 * 查找友情链接信息
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object>map);
	
}