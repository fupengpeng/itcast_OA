package cn.itcast.oa.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.utils.DepartmentUtils;


/**
 * 
 * @Title: UserAction
 * @Description: 用户管理Action
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月25日 下午5:12:56
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	private Long departmentId;  // 属性驱动封装  部门id
	private Long[] roleIds;  // 属性驱动封装  岗位id
	
	/**
	 * 
	 * @Description: 用户列表
	 * @author fupengpeng
	 * @date 2017年10月25日 下午5:14:15
	 * @return 
	 */
	public String list() {
		List<User> list = userService.findAll();
		getValueStack().set("userList", list);
		System.out.println("list = " + list);
		return "list";
	}
	/**
	 * 
	 * @Description: 根据id删除用户
	 * @author fupengpeng
	 * @date 2017年10月25日 下午5:15:26
	 * @return 
	 */
	public String delete(){
		userService.delete(model);
		return "toList";
	}
	/**
	 * 
	 * @Description: 跳转至添加用户页面
	 * @author fupengpeng
	 * @date 2017年10月25日 下午5:16:43
	 * @return
	 */
	public String addUI(){
		//准备数据：1.部门树形列表  2.岗位列表(角色)
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, null);
		
		List<Role> roleList = roleService.findAll();
		
		getValueStack().set("treeList", treeList);
		getValueStack().set("roleList", roleList);
		
		return "addUI";
	}
	/**
	 * 
	 * @Description: 添加用户
	 * @author fupengpeng
	 * @date 2017年10月25日 下午5:18:13
	 * @return
	 */
	public String add(){
		if (departmentId != null) {
			Department dept= departmentService.getById(departmentId);
			model.setDepartment(dept);
		}
		if (roleIds != null && roleIds.length > 0) {
			List<Role> roleList = roleService.getByIds(roleIds);
			model.setRoles(new HashSet<Role>(roleList));
		}
		
		userService.save(model);
		System.out.println("model = " + model.toString());
		
		return "toList";
	}
	/**
	 * 
	 * @Description: 跳转至修改用户信息页面
	 * @author fupengpeng
	 * @date 2017年10月25日 下午5:18:17
	 * @return
	 */
	public String editUI(){
		
		User user = userService.getById(model.getId());
		getValueStack().push(user);
		
		return "editUI";
	}
	/**
	 * 
	 * @Description: 修改用户信息
	 * @author fupengpeng
	 * @date 2017年10月25日 下午5:18:21
	 * @return
	 */
	public String edit(){
		
		User user = userService.getById(model.getId());
		getValueStack().push(user);
		
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, null);
		
		List<Role> roleList = roleService.findAll();
		
		getValueStack().set("treeList", treeList);
		getValueStack().set("roleList", roleList);
		
		
		
		return "toList";
	}
	/**
	 * 
	 * @Description: 初始化密码
	 * @author fupengpeng
	 * @date 2017年10月25日 下午5:20:26
	 * @return
	 */
	public String initPassword(){
		
		return "toList";
	}


}
