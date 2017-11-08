package cn.itcast.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.ITopicDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;


/**
 * 
 * @Title: TopicDaoImpl
 * @Description: 主题管理Dao接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午9:51:48
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements ITopicDao {
	/**
	 * 说明：BaseDaoImpl类已经实现了IBaseDao，而IRoleDao接口又继承了了一次IBaseDao接口，可以省略
	 *     IRoleDao接口，但不能省略。原因：IBaseDao接口
	 */
	
	/**
	 * 根据板块查询主题列表
	 */
	
	public List<Topic> findTopicByForum(Forum model) {
		//查询所有列，        表          itcast_topic       （  如果是type是2，则按2处理，否则  按 1  处理        ）     2和1按降序排列       剩下的1 按 postTime降序排列
		//select * from itcast_topic order by (case type when 2 then 2 else 1 end ) desc , postTime desc; 
		
		String hql = "FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 1 END ) DESC , t.postTime DESC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		return query.list();
	}
	
	
	
}
