package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IRoleDao;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.IRoleService;


/**
 * 
 * @Title: RoleServiceImpl
 * @Description: 岗位管理Service接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年9月25日 下午1:50:03
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Resource
	private IRoleDao roleDao;

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public void delete(Role model) {
		roleDao.delete(model.getId());
		
	}

	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	public void update(Role role) {
		roleDao.update(role);
		
	}

	public void save(Role model) {
		roleDao.save(model);
	}

	public List<Role> getByIds(Long[] roleIds) {
		
		return roleDao.getByIds(roleIds);
	}

	
}
