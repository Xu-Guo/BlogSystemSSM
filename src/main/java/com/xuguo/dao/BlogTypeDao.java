package com.xuguo.dao;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.BlogType;

/**
 * BlogType DAO interface
 * @author xu
 *
 */
public interface BlogTypeDao {
	
	
	/**
	 * search all the blogType and corresponding numbers of blogs
	 * @return
	 */
	public List<BlogType> countList();
	
	/**
	 * get BlogType by Id
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);
	
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
	
	
	/**
	 * add blogType
	 * @param blogType
	 * @return
	 */
	public Integer add(BlogType blogType);
	
	
	/**
	 * edit blogType
	 * @param blogType
	 * @return
	 */
	public Integer update(BlogType blogType);
	
	
	/**
	 * delete blogType
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
}
