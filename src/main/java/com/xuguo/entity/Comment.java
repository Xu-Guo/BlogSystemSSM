package com.xuguo.entity;

import java.util.Date;

/**
 * comment entity
 * @author xu
 *
 */
public class Comment {
	
	private Integer id;
	private String userIp; //user ip address
	private String content;
	private Blog blog;//blog that be commented
	private Date commentDate;
	private Integer state;//Blogger check state: 0:waiting, 1:pass, 2:failed check
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	

	
	
}
