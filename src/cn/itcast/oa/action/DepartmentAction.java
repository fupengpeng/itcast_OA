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
	
	private Long parentId;  //属性驱动封装对象
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

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
	
	/**
	 * 填入数据，实现添加操作
	 */
	public String add(){
		System.out.println("parentId = " + parentId);
		if (parentId != null) {
			Department parent = departmentService.getById(parentId);
			model.setParent(parent);  //设置添加的部门的上级部门
		}else {
			model.setParent(null);			
		}
		departmentService.save(model);
		return "toList";
	}
	
	/**
	 * 跳转到修改页面
	 */
	public String editUI(){
		List<Department> list = departmentService.findAll();  //修改时所要显示的部门列表信息获取
		Department department = departmentService.getById(model.getId());  //要修改的用户数据获取
		getValueStack().set("departmentList", list);
		getValueStack().push(department);
		if (department.getParent() != null) {
			parentId = department.getParent().getId();  //设置parentId的值，用于修改部门数据时，默认展示的上级部门名称
		}
		return "editUI";
	}
	
	/**
	 * 修改部门信息
	 */
	public String edit(){
		//先查询导数据，再进行数据修改
		Department department = departmentService.getById(model.getId());
		
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		
		System.out.println("parentId = " + parentId);
		if (parentId != null) {
			Department parent = departmentService.getById(parentId);
			department.setParent(parent);  //设置添加的部门的上级部门
		}else {
			department.setParent(null);			
		}
		departmentService.update(department);
		return "toList";
	}
}
