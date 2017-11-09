package cn.itcast.oa.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;


/**
 * 
 * @Title: TopicAction
 * @Description: 主题管理Action
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午11:05:12
 *
 */
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {
	
	private Long forumId;
	


	/**
	 * 跳转到发表主题页面
	 */
	public String addUI(){
		//根据板块id获取板块其它信息用于显示
		Forum forum = forumService.getById(forumId);
		getValueStack().push(forum);
		
		return "addUI";
	}
	
	/**
	 * 发表主题
	 */
	public String add(){
		//添加主题之后，板块的相关属性也需要修改
		Forum forum = forumService.getById(forumId);
		model.setForum(forum);  // 主题关联板块
		model.setIpAddress(getIpAddress());  // 设置客户端ip地址
		model.setPostTime(new Date());  //当前主题发表时间
		model.setLastUpdateTime(model.getPostTime());  // 设置最后更新时间为发表主题时间   
		model.setReplyCount(0);  // 设置当前主题的回复数量
		model.setType(0);    // 主题类型为普通类型
		
		model.setAuthor(getLoginUser());    // 设置主题作者为当前登录用户
		model.setLastReply(null);  // 默认没有回复
		
		topicService.save(model);
		
		return "toTopicList";
	}
	
	/**
	 * 显示单个主题（回复列表）
	 */
	public String show(){
		//根据id查询主题
		Topic topic = topicService.getById(model);
		getValueStack().push(topic);
		//根据主题查询对应的回复列表
		List<Reply> replyList = replyService.getReplyByTopic(model);
		getValueStack().set("replyList", replyList);
		
		return "show";
	}
	
	
	
	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
}
