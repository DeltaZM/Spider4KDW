package com.spider.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spider.service.SpiderService;

@Controller
@RequestMapping("/spider")
public class SpiderAction {
	
	@Resource
	private SpiderService spiderService;
	
	@RequestMapping("/start")
	public String startSpider(){
		return "hello";
	}
	
	@RequestMapping("/findMp4UrlStart")
	public @ResponseBody String findMp4UrlStart(){
		spiderService.findMp4UrlStart();
		return "Success";
	}
	
	
}
