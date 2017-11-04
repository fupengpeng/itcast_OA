package cn.itcast.oa.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IPrivilegeDao;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.IPrivilegeService;

/**
 * 
 * @Title: PrivilegeServiceImpl
 * @Description: 权限管理Service接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月1日 上午11:33:48
 *
 */
@Service
@Transactional
public class PrivilegeServiceImpl implements IPrivilegeService {
	
	@Resource
	private IPrivilegeDao privilegeDao;

	/**
	 * 查询所有权限
	 */
	public List<Privilege> findAll() {
		return privilegeDao.findAll();
	}

	/**
	 * 根据选定的权限id数组查询多个权限
	 */
	public List<Privilege> getByIds(Long[] privilegeIds) {
		return privilegeDao.getByIds(privilegeIds);
	}

	/**
	 * 查询顶级权限
	 */
	public List<Privilege> findTopList() {
		return privilegeDao.findTopList();
	}

	/**
	 * 查询所有权限对应的url
	 */
	public List<String> findAllUrl() {
		return privilegeDao.findAllUrl();
	}

	
	


}
