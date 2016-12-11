package com.xuguo.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xuguo.dao.BlogTypeDao;
import com.xuguo.entity.BlogType;
import com.xuguo.entity.Blogger;
import com.xuguo.service.BlogTypeService;
import com.xuguo.service.BloggerService;

/**
 * 博客类型Service实现类
 * @author xu
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService{
	
	@Resource
	private BlogTypeDao blogTypeDao;


	public List<BlogType> countList() {
		// TODO Auto-generated method stub
		
		return blogTypeDao.countList();
	}
}
