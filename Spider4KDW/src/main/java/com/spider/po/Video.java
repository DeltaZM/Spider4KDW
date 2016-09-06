package com.spider.po;

public class Video {
	public int id;
	public String title;
	public String url;
	public String time;
	public String ratepositive;
	public String Mp4Url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRatepositive() {
		return ratepositive;
	}

	public void setRatepositive(String ratepositive) {
		this.ratepositive = ratepositive;
	}

	public String getMp4Url() {
		return Mp4Url;
	}

	public void setMp4Url(String mp4Url) {
		Mp4Url = mp4Url;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", url=" + url + ", time=" + time + ", ratepositive="
				+ ratepositive + ", Mp4Url=" + Mp4Url + "]";
	}
	
	
}
