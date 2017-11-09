package cn.itcast.oa.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;


/**
 * 
 * @Title: ReplyAction
 * @Description: 回复管理Action
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午11:12:29
 *
 */
@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {
	
	private Long topicId;  //属性驱动，主题id

	
	/**
	 * 跳转到回复页面
	 */
	public String addUI(){
		Topic topic = topicService.getById(topicId);
		getValueStack().push(topic);
		return "addUI";
	}
	
	/**
	 * 发表回复
	 */
	public String add(){
		Topic topic = topicService.getById(topicId);
		model.setTopic(topic);  // 回复关联主题
		
		model.setDeleted(0);  //默认为未删除
		model.setIpAddress(getIpAddress());  // 设置用户ip地址
		model.setPostTime(new Date());  // 设置回复时间为当前时间
		model.setAuthor(getLoginUser());  // 设置回复用户
		
		replyService.save(model);
		
		
		return "toReplyList";
	}
	
	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
}
