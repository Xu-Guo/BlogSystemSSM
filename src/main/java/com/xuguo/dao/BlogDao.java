package com.xuguo.dao;

import java.util.List;
import java.util.Map;

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
	
	
	/**
	 * ��ҳ��ѯ����
	 * @return
	 */
	public List<Blog> list(Map<String, Object> map);
	
	
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
}
