package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.ITopicDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.ITopicService;


/**
 * 
 * @Title: TopicServiceImpl
 * @Description: 主题管理Service接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午9:49:09
 *
 */
@Service
@Transactional
public class TopicServiceImpl implements ITopicService {
	
	@Resource
	private ITopicDao topicDao;

	public List<Topic> findTopicByForum(Forum model) {
		return topicDao.findTopicByForum(model);
	}

	
	/**
	 * 发表主题
	 */
	public void save(Topic model) {
		topicDao.save(model);
		//设置主题板块的其他信息
		Forum forum = model.getForum();  // 
		forum.setTopicCount(forum.getTopicCount() + 1 );  //当前主题所在板块主题数量加1 
		forum.setArticleCount(forum.getArticleCount() + 1);  //当前主题所在版块文章数量加1 
		forum.setLastTopic(model);   //设置板块的最后发表主题为当前主题
	}


	/**
	 * 根据id查询主题
	 */
	public Topic getById(Topic model) {
		return topicDao.getById(model.getId());
	}


	public Topic getById(Long topicId) {
		return topicDao.getById(topicId);
	}
	
	
}
