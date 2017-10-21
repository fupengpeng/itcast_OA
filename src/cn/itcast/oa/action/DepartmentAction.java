package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;


/**
 * 
 * @Title: DepartmentAction
 * @Description: 部门管理Action
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月21日 下午3:19:38
 */
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	
	/**
	 * 查询部门列表
	 */
	public String list(){
		List<Department> list = departmentService.findAll();
		getValueStack().set("list", list);    //查询出来是列表，就是用set方法，查询出来是对象，则使用push方法
		return "list";
	} 
	
	/**
	 * 根据id删除部门
	 */
	public String delete(){
		departmentService.delete(model);
		return "toList";
	}
	
	/**
	 * 跳转到部门添加页面
	 */
	public String addUI(){
		//准备部门列表数据，用于select列表展示
		List<Department> list = departmentService.findAll();
		getValueStack().set("departmentList", list);    //查询出来是列表，就是用set方法，查询出来是对象，则使用push方法
		
		return "addUI";
	}

}
