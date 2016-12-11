package com.xuguo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.xuguo.dao.BlogDao;
import com.xuguo.entity.Blog;
import com.xuguo.service.BlogService;
/**
 * 博客Service实现类
 * @author xu
 *
 */


@Service("blogService")
public class BlogServiceImpl implements BlogService{
	
	@Resource
	private BlogDao blogDao;

	public List<Blog> countList() {
		// TODO Auto-generated method stub
		return blogDao.countList();
	}

}
