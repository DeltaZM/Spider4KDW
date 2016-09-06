package com.spider.pipline;


import javax.annotation.Resource;

import com.spider.mapper.VideoMapper;
import com.spider.po.Mp4UrlDto;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class Mp4UrlPipline implements Pipeline{

	@Resource
	private VideoMapper videoMapper;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		System.out.println("this is test pipline" + resultItems.get("url")+"");
		System.out.println("this is test pipline" + resultItems.get("mp4Url")+"");
		Mp4UrlDto mp4UrlDto = new Mp4UrlDto();
		mp4UrlDto.setUrl(resultItems.get("url")+"");
		mp4UrlDto.setMp4Url(resultItems.get("mp4Url")+"");
		
		System.out.println(videoMapper);
		videoMapper.saveMp4Url(mp4UrlDto);
	}

}
