package cn.itcast.oa.dao;

import java.util.List;

import cn.itcast.oa.base.IBaseDao;
import cn.itcast.oa.domain.ApproveInfo;


/**
 * 
 * @Title: IApproveInfoDao
 * @Description: 审批Dao接口
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月22日 下午1:44:06
 */
public interface IApproveInfoDao extends IBaseDao<ApproveInfo> {

	public List<ApproveInfo> findApproveInfoListByApplicationId(Long applicationId);

}
