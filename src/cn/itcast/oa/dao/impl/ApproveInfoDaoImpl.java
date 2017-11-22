package cn.itcast.oa.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IApproveInfoDao;
import cn.itcast.oa.domain.ApproveInfo;

/**
 * 
 * @Title: ApproveInfoDaoImpl
 * @Description: 审批Dao接口实现
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月22日 下午1:45:53
 */
@Repository
@SuppressWarnings("unchecked")
public class ApproveInfoDaoImpl extends BaseDaoImpl<ApproveInfo> implements IApproveInfoDao {

	/**
	 * 根据申请id查询对应的审批集合
	 */
	public List<ApproveInfo> findApproveInfoListByApplicationId(
			Long applicationId) {
		String hql = "FROM ApproveInfo ai WHERE ai.application.id = ? ORDER BY ai.approveTime ASC ";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, applicationId);
		
		return query.list();
	}
	
	
}
