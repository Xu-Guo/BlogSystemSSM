package com.xuguo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import com.xuguo.dao.BloggerDao;
import com.xuguo.dao.LinkDao;
import com.xuguo.entity.Blogger;
import com.xuguo.entity.Link;
import com.xuguo.service.BloggerService;
import com.xuguo.service.LinkService;



/**
 * friend link Service implementation
 * @author xu
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService{
	
	@Resource
	private LinkDao linkDao;

	public List<Link> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return linkDao.list(map);
	}

	@Override
	public int add(Link link) {
		return linkDao.add(link);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return linkDao.getTotal(map);
	}

	@Override
	public int update(Link link) {
		return linkDao.update(link);
	}

	@Override
	public Integer delete(Integer id) {
		return linkDao.delete(id);
	}


}
