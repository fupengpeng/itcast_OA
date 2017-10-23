package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;


/**
 * 
 * @Title: IDepartmentService
 * @Description: 部门管理Service接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月21日 下午3:24:11
 */
public interface IDepartmentService {

	public List<Department> findAll();

	public void delete(Department model);

	public Department getById(Long parentId);

	public void save(Department model);
	


}
