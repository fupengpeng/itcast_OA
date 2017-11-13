package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.utils.HQLHelper;


/**
 * 
 * @Title: ITopicService
 * @Description: 主题管理Service接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午9:47:57
 *
 */
public interface ITopicService {

	public List<Topic> findTopicByForum(Forum model);

	public void save(Topic model);

	public Topic getById(Topic model);

	public Topic getById(Long topicId);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
