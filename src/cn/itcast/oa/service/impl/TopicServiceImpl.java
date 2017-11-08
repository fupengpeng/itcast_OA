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
	
	
}
