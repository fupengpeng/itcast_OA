package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @Title: Department
 * @Description: 部门实体
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月20日 下午5:00:38
 */
public class Department {
	private Long id;
	private String name;  //部门名称
	private String description;  //部门说明
	private Department parent;  //上级部门
	private Set<Department> children = new HashSet<Department>();  //下级部门
	private Set<User> users = new HashSet<User>();  //部门所拥有用户
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	public Set<Department> getChildren() {
		return children;
	}
	public void setChildren(Set<Department> children) {
		this.children = children;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
