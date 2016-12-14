package com.xuguo.dao;

import java.util.List;

import com.xuguo.entity.BlogType;

/**
 * BlogType DAO interface
 * @author xu
 *
 */
public interface BlogTypeDao {
	
	/**
	 *  search all the blogType and corresponding numbers of blogs
	 */
	public List<BlogType> countList();
	
	
	
	/**
	 * get BlogType by Id
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);
}
