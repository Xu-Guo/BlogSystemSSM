package com.xuguo.service;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.Link;

/**
 * 友情链接Service层
 * @author xu
 *
 */
public interface LinkService {
	
	/**
	 * 查找友情链接信息
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object>map);


}
