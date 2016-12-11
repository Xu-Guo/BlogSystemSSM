package com.xuguo.entity;

import java.util.Date;

//blog entity
public class Blog {
	
	
	private Integer id;
	private String title;
	private String summary;
	private Date releaseDate;
	private Integer clickHit;
	private Integer replayHit;
	private String content;
	
	private BlogType blogType; //��������
	
	private String keyWord; //�ؼ��� �ո����	
	private Integer blogCount; //���� �ǲ���ʵ�����ԣ����ݷ������ڹ鵵��ѯ�������õ�
	private String releaseDateStr; //�������ڵ��ַ�����ֻ�������
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getClickHit() {
		return clickHit;
	}
	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}
	public Integer getReplayHit() {
		return replayHit;
	}
	public void setReplayHit(Integer replayHit) {
		this.replayHit = replayHit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BlogType getBlogType() {
		return blogType;
	}
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Integer getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	public String getReleaseDateStr() {
		return releaseDateStr;
	}
	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}
}
