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


}
