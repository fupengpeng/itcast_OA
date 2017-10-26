package cn.itcast.oa.dao.impl;


import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IUserDao;
import cn.itcast.oa.domain.User;


/**
 * 
 * @Title: UserDaoImpl
 * @Description: 用户管理Dao接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月25日 下午5:23:35
 */
@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {


}
