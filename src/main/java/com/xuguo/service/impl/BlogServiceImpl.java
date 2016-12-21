package com.xuguo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.xuguo.dao.BlogDao;
import com.xuguo.entity.Blog;
import com.xuguo.service.BlogService;
/**
 * blog Service implementation
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

	public List<Blog> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogDao.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogDao.getTotal(map);
	}

	public Blog findById(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.findById(id);
	}

	public Integer update(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.update(blog);
	}

	public Blog getLastBlog(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.getLastBlog(id);
	}

	public Blog getNextBlog(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.getNextBlog(id);
	}


}