package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IReplyDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.IReplyService;


/**
 * 
 * @Title: ReplyService
 * @Description: 回复管理Service接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午11:17:38
 *
 */
@Service
@Transactional
public class ReplyService implements IReplyService {
	
	@Resource
	private IReplyDao replyDao;

	/**
	 * 发表回复
	 */
	public void save(Reply model) {
		replyDao.save(model);
		
		Forum forum = model.getTopic().getForum();
		forum.setArticleCount(forum.getArticleCount() + 1); // 板块文章数量
		
		Topic topic = model.getTopic();
		topic.setReplyCount(topic.getReplyCount() + 1 );  // 主题回复数量加1
		topic.setLastReply(model);  // 主题回复最后的一个回复为当前回复
		topic.setLastUpdateTime(topic.getPostTime());  // 主题回复最后的更新时间为回复时间
		
		
	}

	
	/**
	 * 根据主题查询对应的回复列表
	 */
	public List<Reply> getReplyByTopic(Topic model) {
		return replyDao.getReplyByTopic(model);
	}

}
