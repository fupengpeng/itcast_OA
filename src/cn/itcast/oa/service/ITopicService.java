package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;


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

}
