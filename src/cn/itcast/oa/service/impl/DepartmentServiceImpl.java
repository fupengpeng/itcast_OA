package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IDepartmentDao;
import cn.itcast.oa.dao.IRoleDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.IDepartmentService;


/**
 * 
 * @Title: DepartmentServiceImpl
 * @Description: 部门管理Service实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月21日 下午3:23:54
 */
@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
	
	@Resource
	private IDepartmentDao departmentDao;

	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	public void delete(Department model) {
		departmentDao.delete(model.getId());
	}

	public Department getById(Long parentId) {
		// TODO Auto-generated method stub
		return departmentDao.getById(parentId);
	}

	public void save(Department model) {
		// TODO Auto-generated method stub
		departmentDao.save(model);
	}

	public void update(Department model) {
		// TODO Auto-generated method stub
		departmentDao.update(model);
	}
	
	


}
