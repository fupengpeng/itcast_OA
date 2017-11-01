package cn.itcast.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IPrivilegeDao;
import cn.itcast.oa.dao.IRoleDao;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;


/**
 * 
 * @Title: PrivilegeDaoImpl
 * @Description: 权限管理Dao接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月1日 上午11:33:04
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements IPrivilegeDao {
	/**
	 * 说明：BaseDaoImpl类已经实现了IBaseDao，而IRoleDao接口又继承了了一次IBaseDao接口，可以省略
	 *     IRoleDao接口，但不能省略。原因：IBaseDao接口
	 */
	
	
	/**
	 * 查询顶级权限
	 */
	public List<Privilege> findTopList() {
		String hql = "FROM Privilege p WHERE p.parent IS NULL";
		return this.getSession().createQuery(hql).list();
	}
	
}
