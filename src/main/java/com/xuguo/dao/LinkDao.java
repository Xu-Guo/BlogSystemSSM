package com.xuguo.dao;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.Link;

/**
 * ��������DAO
 * @author xu
 *
 */
public interface LinkDao {
	/**
	 * ��������������Ϣ
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object>map);
	
}