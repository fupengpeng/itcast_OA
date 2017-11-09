package cn.itcast.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IReplyDao;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;


/**
 * 
 * @Title: ReplyDaoImpl
 * @Description: 回复管理Dao接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午11:20:37
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements IReplyDao {


	/**
	 * 说明：BaseDaoImpl类已经实现了IBaseDao，而IRoleDao接口又继承了了一次IBaseDao接口，可以省略
	 *     IRoleDao接口，但不能省略。原因：IBaseDao接口
	 */
	
	/**
	 * 根据主题查询对应的回复列表
	 */
	public List<Reply> getReplyByTopic(Topic model) {
		String hql = "FROM Reply r WHERE r.topic = ? ORDER BY r.postTime";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		return query.list();
	}
	
}
