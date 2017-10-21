package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.util.ValueStack;

import cn.itcast.oa.base.BaseAction;
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
public class RoleAction extends BaseAction<Role> {
	
	/**
	 * 查询岗位列表
	 */
	public String list(){
		List<Role> list = roleService.findAll();  //调用BaseDaoImpl的fandAll方法获取数据
		ValueStack vs = getValueStack();  //调用父类getValueStack方法获取值栈
		vs.set("list", list);  //给值栈设置数据
		return "list"; 
	}
	
	/**
	 * 根据id来删除岗位
	 */
	public String delete(){
		roleService.delete(model);  //调用BaseDaoImpl的delete方法删除数据
		
		return "toList";
	}
	/**
	 * 修改前，跳转到修改页面
	 */
	public String editUI(){
		//根据id查询岗位，用于回显
		Role role = roleService.getById(model.getId());  //根据id获取到要修改的数据对象
		getValueStack().push(role);  //给值栈设置数据
		return "editUI";
	}
	/**
	 * 根据id修改角色数据
	 */
	public String edit(){
		//先查询  ，再修改
		Role role = roleService.getById(model.getId());  //根据id获取到要修改的数据对象
		
		//修改role的属性值
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		//更改
		roleService.update(role);
		return "toList";
	}
	/**
	 * 跳转添加页面
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
	
}
