package com.xuguo.service;

import java.util.List;

import com.xuguo.entity.BlogType;

/**
 * ��������Service�ӿ�
 * @author xu
 *
 */
public interface BlogTypeService {
	
	/**
	 * search all the blogType and corresponding numbers of blogs
	 */
	public List<BlogType> countList();
}
