package cn.itcast.oa.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IForumManageDao;
import cn.itcast.oa.domain.Forum;


/**
 * 
 * @Title: ForumManageDaoImpl
 * @Description: 板块管理Dao接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 上午9:50:47
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class ForumManageDaoImpl extends BaseDaoImpl<Forum> implements IForumManageDao {

	/**
	 * 重写父类的save方法，加入保存模块时，设置position的值为id值
	 */
	@Override
	public void save(Forum entity) {
		super.save(entity);  // 调用类父类的save方法之后，次对象已经有id值
		entity.setPosition(entity.getId().intValue());  // 设置position的值为id值
		
	}

	/**
	 * 重写查询方法，按照position排序
	 */
	@Override
	public List<Forum> findAll() {
		String hql = "FROM Forum f ORDER BY f.position ASC";
		return this.getSession().createQuery(hql).list();
	}

	
	/**
	 * 上移板块
	 */
	public void moveUp(Forum model) {
		//select f.* from itcast_forum f where f.position < 11 order by f.position desc limit 0,1;
		Forum forum1 = getById(model.getId());
		int p1 = forum1.getPosition();
		String hql = "FROM Forum f WHERE f.position < ? ORDER BY f.position DESC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, p1);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Forum forum2 = (Forum) query.uniqueResult();
		
		forum1.setPosition(forum2.getPosition());
		forum2.setPosition(p1);
	}

	public void moveDown(Forum model) {
		//select * from itcast_forum where position > 8 order by position limit 0,1;
		//要移动的forum对象
		Forum forum1 = getById(model.getId());
		int p1 = forum1.getPosition();
		
		//要移动到的位置的对象
		String hql = "FROM Forum f WHERE f.position > ? ORDER BY f.position";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, p1);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Forum forum2 = (Forum) query.uniqueResult();
		
		//移动
		forum1.setPosition(forum2.getPosition());
		forum2.setPosition(p1);
		
		
	}
	
	
	

}
