package com.spider.service.Impl;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.ConsoleAppender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spider.pipline.Mp4UrlPipline;
import com.spider.service.FindMp4UrlService;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

@Service
public class FindMp4UrlServiceImpl implements FindMp4UrlService {

//	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
//	private Site site = Site.me().setDomain("http://www.cao7000.com/")
//			.setUserAgent(
//					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
//			.setRetryTimes(3).setSleepTime(1000);
//
//	@Override
//	public Site getSite() {
//		return site;
//	}
//
//	@Override
//	// process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
//	public void process(Page page) {
//		Pattern pattern = Pattern.compile("http://www\\.cao7000\\.com/\\w+/\\d+/[a-z0-9A-Z]*/\\d+/\\d+/\\d+\\.mp4");
//		String str = page.getHtml().toString();
//		Matcher mat = pattern.matcher(str);
//		if (mat.find()) {
//			page.putField("url", page.getRequest().getUrl()+"");
//			page.putField("mp4Url", mat.group(0));
//		} else {
//			System.out.println("not find");
//		}
//	}
//
	public void test(String url) {
//		Spider.create(new FindMp4UrlServiceImpl())
//				.addPipeline(new Mp4UrlPipline())
//				.addUrl(url)
//				// 开启5个线程抓取
//				.thread(5)
//				// 启动爬虫
//				.run();
	}


	
}
