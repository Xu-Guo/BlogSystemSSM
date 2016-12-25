package com.xuguo.service;

import com.xuguo.entity.Blogger;

/**
 * Blogger service interface
 * @author Administrator
 *
 */
public interface BloggerService {

	/**
	 * get user entity by username
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);
	
	
	/**
	 * get blogger information
	 * @return
	 */
	public Blogger find();
	
	
	/**
	 * update blogger information
	 * @param blogger
	 * @return
	 */
    public Integer update(Blogger blogger);
}