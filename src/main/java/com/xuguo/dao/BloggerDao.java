package com.xuguo.dao;

import com.xuguo.entity.Blogger;

public interface BloggerDao {
	/**
	 * get user by username
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);
	
	
	/**
	 * get blogger information
	 * 
	 */
	public Blogger find();

	/**
	 * update blogger informations
	 * @param blogger
	 * @return
	 */
	public Integer update(Blogger blogger);
}
