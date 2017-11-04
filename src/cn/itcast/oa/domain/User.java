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
	private String loginName; // 登录名(唯一)
	private String name; // 用户名
	private int gender; // 用户性别
	private String phone; // 用户电话
	private String email; // 用户邮箱
	private String description; // 用户说明
	private String password; // 用户登录密码
	private Department department; // 隶属部门
	private Set<Role> roles = new HashSet<Role>(); // 隶属岗位(角色)

	/**
	 * 判断当前用户是否有给定的权限
	 */
	public boolean hasPrivilegeByName(String name) {
		// 如果登录用户是超级管理员，就直接返回true
		if (isAdmin()) {
			System.out.println("----------超级管理员");
			return true;
		}
		// 遍历当前用户对象的角色
		for (Role role : roles) {
			Set<Privilege> privileges = role.getPrivileges();
			// 遍历角色对应的权限
			for (Privilege p : privileges) {
				String pName = p.getName();
				System.out.println("------pName = " + pName + "   -----name = " + name);
				if (pName.equals(name)) {
					System.out.println("---相同，展示此权限----pName = " + pName);
					return true;
				}
			}
		}
		return false;
	}



	/**
	 * 判断当前用户是否有给定的权限url
	 * 
	 * @param url
	 * @return
	 */
	public boolean hasPrivilegeByUrl(String url) {
		// 如果登录用户是超级管理员，就直接返回true
		if (isAdmin()) {
			System.out.println("----------超级管理员");
			return true;
		}
		// 遍历当前用户对象的角色
		for (Role role : roles) {
			Set<Privilege> privileges = role.getPrivileges();
			// 遍历角色对应的权限
			for (Privilege p : privileges) {
				String pUrl = p.getUrl();
				System.out.println("---------------pUrl = " + pUrl);
				System.out.println("-------------url = " + url);
				if (url.equals(pUrl)) {
					System.out.println("----------------url = " + url);
					System.out.println("----------------普通管理员");
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * 判断当前用户是否是超级管理员
	 */
	public boolean isAdmin() {
		return "admin".equals(loginName);
	}
	

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
