package com.spider.service.Impl;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.spider.service.DownFileService;
import com.spider.util.DownThread;

@Service
public class DownFileServiceImpl implements DownFileService {

	public void down(String path, int threadnum) {
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//conn.setConnectTimeout(10 * 1000);
			conn.setRequestProperty("User-Agent",
					" Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36");
			conn.setRequestProperty("Accept-Encoding", "identity");
			conn.setRequestMethod("POST");
			// 获得网络文件的长度
			int length = conn.getContentLength();
			// 每个线程负责下载的文件大小
			int block = (length % threadnum) == 0 ? length / threadnum : length / threadnum + 1;
			// 从http相应消息获取的状态码，200:OK;401:Unauthorized
			if (conn.getResponseCode() == 200) {
				for (int i = 0; i < threadnum; i++) {
					// 开启线程下载
					new DownThread(i, new File(realPath(), getFileName(path)), block, url).start();
				}
			}
		} catch (Exception e) {
			e.getCause();
		}
	}

	public String realPath() {
		String realPath = "F:/mp4/";
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return realPath;
	}

	/**
	 * 获取文件名
	 * 
	 * @param path
	 * @return
	 */
	public String getFileName(String path) {
		return path.substring(path.lastIndexOf("/") + 1);
	}

}


