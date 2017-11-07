package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;




/**
 * 
 * @Title: Forum
 * @Description: 板块实体
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 上午9:29:15
 *
 */
public class Forum {
	
	private Long id;  //id
	private String name;  //名称
	private String description;  //板块说明
	private int position;   // 顺序
	
	private int topicCount;   //当前板块主题数量
	private int articleCount;   //当前板块文章数量
	private Topic lastTopic;    //发表的最后一个主题
	
	private Set<Topic> topices = new HashSet<Topic>();  //当前板块下的主题集合
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getTopicCount() {
		return topicCount;
	}
	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}
	
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public Topic getLastTopic() {
		return lastTopic;
	}
	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}
	public Set<Topic> getTopices() {
		return topices;
	}
	public void setTopices(Set<Topic> topices) {
		this.topices = topices;
	}
	@Override
	public String toString() {
		return "Forum [id=" + id + ", name=" + name + ", description="
				+ description + ", position=" + position + ", topicCount="
				+ topicCount + ", articleCount=" + articleCount
				+ ", lastTopic=" + lastTopic + ", topices=" + topices + "]";
	}
	
	
	
	

}
