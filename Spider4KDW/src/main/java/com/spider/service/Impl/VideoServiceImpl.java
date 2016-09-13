package com.spider.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spider.mapper.VideoMapper;
import com.spider.po.Video;
import com.spider.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	@Resource
	private VideoMapper videoMapper;
	@Override
	public List<Video> findVideoByTitle(String title) {
		return videoMapper.findVideoByTitle(title);
	}
	@Override
	public List<Video> finAll() {
		return videoMapper.findAllVideoInfo();
	}

}
