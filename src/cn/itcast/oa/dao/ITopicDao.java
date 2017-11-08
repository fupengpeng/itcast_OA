package cn.itcast.oa.dao;

import java.util.List;

import cn.itcast.oa.base.IBaseDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;


/**
 * 
 * @Title: ITopicDao
 * @Description: 主题管理Dao接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午9:50:51
 *
 */
public interface ITopicDao extends IBaseDao<Topic> {

	public List<Topic> findTopicByForum(Forum model);

}
