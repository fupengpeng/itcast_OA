package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.User;



/**
 * 
 * @Title: IUserService
 * @Description: 用户管理Service接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月25日 下午5:24:46
 */
public interface IUserService {

	public List<User> findAll();

	public void delete(User model);

	public void save(User model);

	public User getById(Long id);

	public void update(User user);

	public int findByLoginName(String loginName);

}
