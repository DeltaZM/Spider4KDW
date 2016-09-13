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
import com.spider.pipline.Mp4UrlPipline;
import com.spider.po.Video;
import com.spider.service.DownFileService;
import com.spider.service.FindMp4UrlService;
import com.spider.service.VideoService;

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
	@Resource
	private Mp4UrlPipline mp4UrlPipline;
	@Resource
	private DownFileService downFileService;
	@Resource
	private VideoService videoService;
	
	Logger log = Logger.getLogger(test.class);
	
	private final String path = "http://www.cao7000.com/get_file/3/baba8c6f9b849d5f92ce878d52a7a1a1/33000/33109/33109.mp4";
	private final String str = "夫妻";
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
		System.out.println(mp4UrlPipline.getClass());
		System.out.println(videoMapper.getClass());
		//findMp4UrlService.test("www.baidu.com");
	}
	
	@Test
	public void testFindMp4Service(){
		List<String> urls = videoMapper.findAllUrl();
		for (int i=0; i<urls.size(); i++) {
			log.info("zhaoxiaoming----------"+i+"/"+urls.size()+"----------");
			findMp4UrlService.test(urls.get(i));
		}
	}
	
	@Test
	public void testBean1(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-mybatis.xml");
		System.out.println(context.getBean("mp4UrlPipline"));
	}
	
	@Test 
	public void down(){
		downFileService.down(path,10);
	}
	
	@Test
	public void testLikeQuery(){
		List<Video> list = videoService.findVideoByTitle(str);
		System.out.println("------------------"+list.size());
		System.out.println("------------------"+videoService.finAll().size());
	}
	
	@Test
	public void updataDataSouece(){
		List<Video> list = videoMapper.findAllVideoInfo();
//		System.out.println(list.get(0).getUrl());
//		String url = list.get(0).getUrl();
//		for (int i = 0; i < ary.length; i++) {
//			System.out.println(ary[i].toString());
//		}
	}
}
