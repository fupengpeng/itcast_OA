package cn.itcast.oa.dao.impl;


import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IForumDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;


/**
 * 
 * @Title: ForumDaoImpl
 * @Description: 板块Dao接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 下午3:49:28
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements IForumDao {

	/**
	 * 查询板块列表，按照position属性进行排序
	 */
	@Override
	public List<Forum> findAll() {
		String hql = "FROM Forum f ORDER BY f.position";
		System.out.println("---------------------");
		List<Forum> list = this.getSession().createQuery(hql).list();
		System.out.println("============================");
		System.out.println("list = " + list.toString());
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=");
		for (Forum forum : list) {
			System.out.println("1-1-1-1-1-1-1-1-1-1-1--1");
			System.out.println("forum  == " + forum.toString());
			System.out.println("4=4=4=4=4=4=4=4=4=4=4=4=4=4");
			Set<Topic> topics = forum.getTopices();
			System.out.println("7a7a7a7a7a7a7a7a7a7a7a7a7a7");
			for (Topic topic : topics) {
				System.out.println("f0f0f0f0f0f0f0f0f00f0f0f");
				Reply reply = topic.getLastReply();
				System.out.println("-f-f-f-f-f-f-f-f-f-f-f-f-f-");
				System.out.println("reply  = " + reply.toString());
				
				System.out.println("topic  = " + topic.toString());
			}
			System.out.println("forum = " + forum.toString());
		}
		return list;
	}
	
	

}
