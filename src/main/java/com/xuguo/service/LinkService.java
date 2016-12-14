package com.xuguo.service;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.Link;

/**
 * ��������Service��
 * @author xu
 *
 */
public interface LinkService {
	
	/**
	 * find friend link information in database
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object>map);


}
