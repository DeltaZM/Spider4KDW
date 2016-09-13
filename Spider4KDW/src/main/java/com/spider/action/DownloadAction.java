package com.spider.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spider.service.DownFileService;

@Controller
@RequestMapping("/download")
public class DownloadAction {
	
	@Resource 
	private DownFileService downFileService;
	
	private final String path = "http://www.cao7000.com/get_file/3/baba8c6f9b849d5f92ce878d52a7a1a1/33000/33109/33109.mp4";

	
	@RequestMapping("/mp4")
	public @ResponseBody String mp4(){
		downFileService.down(path, 5);
		return "success";
	}
}
