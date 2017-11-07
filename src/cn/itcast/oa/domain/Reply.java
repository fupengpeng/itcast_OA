package cn.itcast.oa.domain;




/**
 * 
 * @Title: Reply
 * @Description: 回复
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 下午2:16:27
 *
 */
public class Reply extends Article {
	
	
	private Topic topic;  //回复的主题
	private int deleted;  //是否删除标识
	
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "Reply [topic=" + topic + ", deleted=" + deleted + "]";
	}
	
	
}
