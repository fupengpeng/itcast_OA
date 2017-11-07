package cn.itcast.oa.domain;

import java.util.Date;


/**
 * 
 * @Title: Article
 * @Description: 主题和回复的父类
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 下午2:51:04
 *
 */
public class Article {
	
	private Long id;
	private String content;    //主题或者回复内容
	private Date postTime;   //主题或者回复发表时间
	private User author;    //发表主题或者回复用户
	private String ipAddress;    //用户的ip
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
}
