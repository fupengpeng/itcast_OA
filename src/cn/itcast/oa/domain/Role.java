package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @Title: Role
 * @Description: 岗位(角色)实体
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月20日 下午5:00:57
 */
public class Role {
	private Long id;
	private String name;  //岗位(角色)名称
	private String description;  //岗位(角色)说明
	private Set<User> users = new HashSet<User>();  //岗位(角色)对应用户
	private Set<Privilege> privileges = new HashSet<Privilege>();  //岗位(角色)对应的权限
	
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
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	
}
