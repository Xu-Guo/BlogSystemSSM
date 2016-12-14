package com.xuguo.dao;

import java.util.List;

import com.xuguo.entity.BlogType;

/**
 * ��������DAO�ӿ�
 * @author xu
 *
 */
public interface BlogTypeDao {
	
	/**
	 * ��ѯ���в������ͣ��Ѿ���Ӧ�Ĳ�������
	 */
	public List<BlogType> countList();
	
	
	
	/**
	 * ͨ��ID���Ҳ�������ʵ��
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);
}
