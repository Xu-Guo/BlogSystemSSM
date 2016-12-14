package com.xuguo.service;

import java.util.List;
import java.util.Map;

import com.xuguo.entity.Blog;

/**
 * ����Service�ӿ�
 * @author xu
 *
 */
public interface BlogService {
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
