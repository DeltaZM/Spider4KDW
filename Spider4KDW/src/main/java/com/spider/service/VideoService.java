package com.spider.service;

import java.util.List;

import com.spider.po.Video;

public interface VideoService {
	List<Video> findVideoByTitle(String title);

	List<Video> finAll();
}
