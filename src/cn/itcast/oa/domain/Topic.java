package cn.itcast.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Topic
 * @Description: 主题
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 下午2:16:01
 *
 */
public class Topic extends Article{
	
	private String title;   //主题标题
	private Date lastUpdateTime;    //最后更新时间
	private int type;    //主题类型
	private Forum forum;  //隶属于那个板块
	private Set<Reply> replies = new HashSet<Reply>();   // 主题回复
	private int replyCount;  //回复数量
	private Reply lastReply;    //当前主题对应的最后一个回复
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	@Override
	public String toString() {
		return "Topic [title=" + title + ", lastUpdateTime=" + lastUpdateTime
				+ ", type=" + type + ", forum=" + forum + ", replies="
				+ replies + ", replyCount=" + replyCount + ", lastReply="
				+ lastReply + "]";
	}
	
	
	
	
	
	
}
