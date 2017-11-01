package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: User
 * @Description: 用户实体
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月20日 下午5:01:12
 */
public class User {
	private Long id;
	private String loginName;  //登录名(唯一)
	private String name;  //用户名
	private int gender;  //用户性别
	private String phone;  //用户电话
	private String email;  //用户邮箱
	private String description;  //用户说明
	private String password;  //用户登录密码
	private Department department;  //隶属部门
	private Set<Role> roles = new HashSet<Role>();  //隶属岗位(角色)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
