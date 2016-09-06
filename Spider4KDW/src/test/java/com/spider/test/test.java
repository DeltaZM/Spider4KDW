package com.spider.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spider.mapper.VideoMapper;
import com.spider.po.Video;
import com.spider.service.FindMp4UrlService;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

@RunWith(value=SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext-mybatis.xml","classpath:/spring/applicationContext-service.xml"})
public class test {
	@Resource
	private VideoMapper videoMapper;
	@Resource
	private FindMp4UrlService findMp4UrlService;

	
	Logger log = Logger.getLogger(test.class);

	@Test
	public void testPoVideo() {
		OOSpider.create(Site.me(), new ConsolePageModelPipeline(), Video.class)
				.addUrl("http://www.cao7000.com//most-popular").thread(4).run();
	}

	@Test
	public void testFindAllVideoInfo() {
		System.out.println(videoMapper);
		List<Video> list = videoMapper.findAllVideoInfo();
		for (Video video : list) {
			log.info(video.toString());
		}
	}
	
	@Test
	public void testBean(){
		//findMp4UrlService.test("www.baidu.com");
	}
	
	@Test
	public void testFindMp4Service(){
		List<String> urls = videoMapper.findAllUrl();
		for (String url : urls) {
			log.info("zhaoxiaoming--------------------"+url);
			findMp4UrlService.test(url);
		}
	}
	
	@Test
	public void testBean1(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-mybatis.xml");
		System.out.println(context.getBean("mp4UrlPipline"));
	}
}
