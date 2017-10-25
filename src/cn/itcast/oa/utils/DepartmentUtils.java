package cn.itcast.oa.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import cn.itcast.oa.domain.Department;


/**
 * 
 * @Title: DepartmentUtils
 * @Description: 将部门列表处理成树形结构的工具类
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月25日 下午2:57:15
 */
public class DepartmentUtils {
	
	/**
	 * 
	 * @Description: 给一个描述
	 * @author fupengpeng
	 * @date 2017年10月25日 下午5:04:24
	 * @param topList  顶级部门列表 
	 * @param removeId  删除部门id
	 * @return List<Department>
	 */
	public static List<Department> getTreeList(List<Department> topList , Long removeId) {
		List<Department> treeList = new ArrayList<Department>();
		walkTree(topList, treeList, "　┣",removeId);
		return treeList;
	}
	
	/**
	 * 
	 * @Description: 组织树形部门数据
	 * @author fupengpeng
	 * @date 2017年10月25日 下午3:01:09
	 */
	public static void walkTree(Collection<Department> topList ,
			List<Department> treeList, String prefix, Long removeId) {
		for (Department d : topList) {
			if (removeId != null && d.getId().equals(removeId)) {
				continue;
			}
			Department copy = new Department();
			copy.setId(d.getId());
			copy.setName(prefix + d.getName());
			//顶点
			treeList.add(copy);
			//子树
			Set<Department> children = d.getChildren();
			walkTree(children,treeList,"　　" + prefix , removeId);
		}
		
	}
	

}
