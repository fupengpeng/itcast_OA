package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Privilege
 * @Description: 权限实体
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月1日 上午10:23:29
 *
 */
public class Privilege {
	private Long id;
	private String name;  //权限名称
	private String url;  //权限对应的请求url
	private Privilege parent;  //上级权限
	private Set<Privilege> children = new HashSet<Privilege>();  //下级权限
	private Set<Role> roles = new HashSet<Role>();  //当前权限对应的角色集合
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
