package com.xuguo.dao;

import com.xuguo.entity.Blogger;

public interface BloggerDao {
	/**
	 * ͨ���û��������û�
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);

}
