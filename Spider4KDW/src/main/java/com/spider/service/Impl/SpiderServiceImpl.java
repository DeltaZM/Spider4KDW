package com.spider.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.spider.mapper.VideoMapper;
import com.spider.po.Mp4UrlDto;
import com.spider.service.FindMp4UrlService;
import com.spider.service.SpiderService;
import com.spider.test.test;

@Service
public class SpiderServiceImpl implements SpiderService {

	@Resource
	private VideoMapper videoMapper;
	@Resource
	private FindMp4UrlService findMp4UrlService;
	
	
	Logger log = Logger.getLogger(SpiderServiceImpl.class);

	@Override
	public void findMp4UrlStart() {
		List<String> urls = videoMapper.findAllUrl();
		for (int i=0; i<urls.size(); i++) {
			log.info("zhaoxiaoming----------"+i+"/"+urls.size()+"----------");
			findMp4UrlService.test(urls.get(i));
		}
	}

}
