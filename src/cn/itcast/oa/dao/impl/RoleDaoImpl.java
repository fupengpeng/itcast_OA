package cn.itcast.oa.dao.impl;


import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IRoleDao;
import cn.itcast.oa.domain.Role;


/**
 * 
 * @Title: RoleDaoImpl
 * @Description: 岗位管理Dao接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年9月25日 下午2:02:44
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao {
	/**
	 * 说明：BaseDaoImpl类已经实现了IBaseDao，而IRoleDao接口又继承了了一次IBaseDao接口，可以省略
	 *     IRoleDao接口，但不能省略。原因：IBaseDao接口
	 */
}
