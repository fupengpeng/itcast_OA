package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;


/**
 * 
 * @Title: IPrivelegeService
 * @Description: 权限管理Service接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月1日 上午11:29:25
 *
 */
public interface IPrivilegeService {

	public List<Privilege> findAll();

	public List<Privilege> getByIds(Long[] privilegeIds);

	public List<Privilege> findTopList();

	public List<String> findAllUrl();



}
