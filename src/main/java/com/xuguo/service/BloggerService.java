package com.xuguo.service;

import com.xuguo.entity.Blogger;

/**
 * ����Dao�ӿ�
 * @author Administrator
 *
 */
public interface BloggerService {

	/**
	 * ͨ���û�����ѯ�û�
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);
	
	
	/**
	 * ��ѯ������Ϣ
	 * @return
	 */
	public Blogger find();
}