package com.spider.pipline;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spider.mapper.VideoMapper;
import com.spider.po.Mp4UrlDto;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class Mp4UrlPipline implements Pipeline{

	@Resource
	private VideoMapper videoMapper;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		Mp4UrlDto mp4UrlDto = new Mp4UrlDto();
		mp4UrlDto.setUrl(resultItems.get("url")+"");
		mp4UrlDto.setMp4Url(resultItems.get("mp4Url")+"");
		
		videoMapper.saveMp4Url(mp4UrlDto);
	}

}
