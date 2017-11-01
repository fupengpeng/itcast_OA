package cn.itcast.oa.dao;

import java.util.List;

import cn.itcast.oa.base.IBaseDao;
import cn.itcast.oa.domain.Privilege;


/**
 * 
 * @Title: IPrivilegeDao
 * @Description: 权限管理Dao接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月1日 上午11:33:18
 *
 */
public interface IPrivilegeDao extends IBaseDao<Privilege> {

	public List<Privilege> findTopList();
}
