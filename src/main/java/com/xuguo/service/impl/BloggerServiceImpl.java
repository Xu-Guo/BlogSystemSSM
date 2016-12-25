package com.xuguo.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import com.xuguo.dao.BloggerDao;
import com.xuguo.entity.Blogger;
import com.xuguo.service.BloggerService;



/**
 * BloggerServive implementation
 * @author xu
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService{
	
	@Resource
	private BloggerDao bloggerDao;

	public Blogger getByUserName(String userName) {
		return bloggerDao.getByUserName(userName);
	}

	public Blogger find() {
		return bloggerDao.find();
	}

	@Override
	public Integer update(Blogger blogger) {
		return bloggerDao.update(blogger);
	}
	
}
