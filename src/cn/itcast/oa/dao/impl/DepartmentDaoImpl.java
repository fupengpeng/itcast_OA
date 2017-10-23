package cn.itcast.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IDepartmentDao;
import cn.itcast.oa.domain.Department;


/**
 * 
 * @Title: DepartmentDaoImpl
 * @Description: 部门管理Dao接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月21日 下午3:33:27
 */
@Repository
@SuppressWarnings("unchecked")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		IDepartmentDao {

	/**
	 * 查询顶级部门列表
	 */
	public List<Department> findTopList() {
		String hql = "FROM Department d WHERE d.parent IS NULL";
		return this.getSession().createQuery(hql).list();
	}

	/**
	 * 查询指定部门的子部门列表
	 */
	public List<Department> findChildren(Long parentId) {
		String hql = "FROM Department d WHERE d.parent.id=?";
		return this.getSession().createQuery(hql).setParameter(0, parentId).list();
	}


}
