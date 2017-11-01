package cn.itcast.oa.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.util.ValueStack;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;

/**
 * 
 * @Title: RoleAction
 * @Description: 岗位管理Action
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年9月25日 下午1:45:56
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	private Long[] privilegeIds;  //属性驱动封装，接收权限的id
	

	/**
	 * 查询岗位列表
	 */
	public String list(){
		List<Role> list = roleService.findAll();
		
		ValueStack vs = getValueStack();
		
		vs.set("list", list);
		
		return "list";
	}
	
	/**
	 * 根据id删除岗位
	 */
	public String delete(){
		roleService.delete(model);
		
		return "toList";
	}
	
	/**
	 * 跳转到修改页面
	 */
	public String editUI(){
		//根据id查询岗位，用于回显
		Role role = roleService.getById(model.getId());
		
		getValueStack().push(role);
		
		return "editUI";
	}
	
	/**
	 * 修改岗位
	 */
	public String edit(){
		//先查询，再修改
		Role role = roleService.getById(model.getId());
		
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		roleService.update(role);
		
		return "toList";
	}
	
	/**
	 * 跳转到添加页面
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * 添加岗位
	 */
	public String add(){
		roleService.save(model);
		
		return "toList";
	}
	
	/**
	 * 跳转到设置权限页面
	 */
	public String setPrivilegeUI(){
		//1.根据id查询当前要设置的岗位(角色)名称，用于回显
		Role role = roleService.getById(model.getId());
		getValueStack().push(role);
		//2.查询所有的权限数据，在页面显示
		List<Privilege> privilegeList =  privilegeService.findTopList();  //查询顶级权限
		getValueStack().set("privilegeList", privilegeList);
		
		
		
		//3.查询当前岗位(角色)对应的权限，用于页面回显
		Set<Privilege> privileges = role.getPrivileges();
		if (privileges != null && privileges.size() > 0) {
			privilegeIds = new Long[privileges.size()] ;
			int index = 0;
			for (Privilege p : privileges) {
				privilegeIds[index++] = p.getId();
			}
		}
		
		return "setPrivilegeUI";
	}
	
	/**
	 * 为岗位(角色)设置权限
	 */
	public String setPrivilege(){
		//先查询，再修改
		Role role = roleService.getById(model.getId());
		if (privilegeIds != null && privilegeIds.length > 0) {
			//如果传递过来的权限数组不为空，就根据权限id数组查询对应的多个权限
			List<Privilege> priviList = privilegeService.getByIds(privilegeIds);
			role.setPrivileges(new HashSet<Privilege>(priviList));
		}else {
			//如果没有设置任何权限，就清空角色对应的权限
			role.setPrivileges(null);
		}
		roleService.update(role);
		return "toList";
	}
	
	
	
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
}
