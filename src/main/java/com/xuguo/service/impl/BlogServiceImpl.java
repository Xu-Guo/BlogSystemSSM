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

		return blogDao.countList();
	}

	public List<Blog> list(Map<String, Object> map) {

		return blogDao.list(map);
	}

	public Long getTotal(Map<String, Object> map) {

		return blogDao.getTotal(map);
	}

	public Blog findById(Integer id) {

		return blogDao.findById(id);
	}

	public Integer update(Blog blog) {

		return blogDao.update(blog);
	}

	public Blog getLastBlog(Integer id) {

		return blogDao.getLastBlog(id);
	}

	public Blog getNextBlog(Integer id) {

		return blogDao.getNextBlog(id);
	}

	public Integer add(Blog blog) {

		return blogDao.add(blog);
	}

	@Override
	public Integer delete(Integer id) {

		return blogDao.delete(id);
	}

	@Override
	public Integer getBlogCountByTypeId(Integer typeId) {
		return blogDao.getBlogCountByTypeId(typeId);
	}


}
