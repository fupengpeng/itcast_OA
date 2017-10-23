package cn.itcast.oa.dao;

import java.util.List;

import cn.itcast.oa.base.IBaseDao;
import cn.itcast.oa.domain.Department;


/**
 * 
 * @Title: IDepartmentDao
 * @Description: 部门管理Dao接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月21日 下午3:31:01
 */
public interface IDepartmentDao extends IBaseDao<Department> {

	List<Department> findTopList();

	List<Department> findChildren(Long parentId);

}
