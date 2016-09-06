package com.spider.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spider.po.Mp4UrlDto;
import com.spider.po.Video;

public interface VideoMapper {
	
	 @Select("select * from Video ")
	 public List<Video> findAllVideoInfo();
	 
	 @Select("select count(id) from Video")
	 public int getCount();
	 
	 @Select("select url from Video limit 10")
	 public List<String> findAllUrl();
	 
	 @Update("update Video set Mp4Url=#{dto.Mp4Url} where url=#{dto.url}")
	 public void saveMp4Url(Mp4UrlDto dto);
}
