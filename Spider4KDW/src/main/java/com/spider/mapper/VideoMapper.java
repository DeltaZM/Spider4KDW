package com.spider.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spider.po.Mp4UrlDto;
import com.spider.po.Video;

public interface VideoMapper {

	@Select("select * from Video limit 1")
	public List<Video> findAllVideoInfo();
	
	@Update("update Video v set v.url=#{url},v.Mp4Url=#{Mp4Url} where id=#{id}")
	public void updataData(Video video);

	@Select("select count(id) from Video")
	public int getCount();

	@Select("select url from Video v where v.Mp4Url is NULL")
	public List<String> findAllUrl();

	@Update("update Video set Mp4Url=#{Mp4Url} where url=#{url}")
	public void saveMp4Url(Mp4UrlDto dto);
	
	@Select("select * from video v where v.title like CONCAT('%',#{title},'%') order by id ")
	public List<Video> findVideoByTitle(String title);
}
