package cn.itcast.oa.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IUserDao;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.IUserService;


/**
 * 
 * @Title: UserServiceImpl
 * @Description: 用户管理Service实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月25日 下午5:26:00
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public void delete(User model) {
		userDao.delete(model.getId());
	}

	public void save(User model) {
		userDao.save(model);
		
	}

	public User getById(Long id) {
		return userDao.getById(id);
	}


}
