package com.xuguo.dao;

import com.xuguo.entity.Blogger;

public interface BloggerDao {
	/**
	 * 通过用户名查找用户
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);

}
