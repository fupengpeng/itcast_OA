package cn.itcast.oa.dao;

import cn.itcast.oa.base.IBaseDao;
import cn.itcast.oa.domain.User;


/**
 * 
 * @Title: IUserDao
 * @Description: 用户管理Dao接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月25日 下午5:22:04
 */
public interface IUserDao extends IBaseDao<User> {

	public int findByLoginName(String loginName);

	public User getById(User model);

}
