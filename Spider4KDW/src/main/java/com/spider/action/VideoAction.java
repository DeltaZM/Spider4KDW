package com.spider.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.spider.po.Video;
import com.spider.service.DownFileService;
import com.spider.service.VideoService;

@Controller
@RequestMapping("/video")
public class VideoAction {
	
	@Resource
	private VideoService videoService;
	@Resource
	private DownFileService downFileService;

	@RequestMapping(value="/findVideo" )//,produces ={"application/json;charset=UTF-8" }
	@ResponseBody
	public  String findVideo(@RequestParam String title){
		List<Video> videoList = new ArrayList<Video>();
		if(!"".equals(title)){
			videoList = videoService.findVideoByTitle(title);
		}else{
			videoList = videoService.finAll();
		}
		
		return JSON.toJSONString(videoList);
	}
	
	@RequestMapping(value="/download")
	@ResponseBody
	public String download(@RequestBody Video video){
		System.out.println(video.toString());
		//downFileService.down(path, 5);
		return "test";
	}
}
