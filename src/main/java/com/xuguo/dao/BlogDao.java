package com.xuguo.dao;

import java.util.List;

import com.xuguo.entity.Blog;

/**
 * ����DAO�ӿ�
 * @author xu
 *
 */
public interface BlogDao {

	/**
	 * �������ڷ��·����ѯ
	 * @return
	 */
	public List<Blog> countList();
}
