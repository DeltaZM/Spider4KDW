package com.spider.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spider.mapper.VideoMapper;
import com.spider.po.Mp4UrlDto;
import com.spider.service.SpiderService;

@Service
public class SpiderServiceImpl implements SpiderService {

	@Resource
	private VideoMapper videoMapper;

	public Mp4UrlDto initMp4Url() {
		return null;
	}

}
