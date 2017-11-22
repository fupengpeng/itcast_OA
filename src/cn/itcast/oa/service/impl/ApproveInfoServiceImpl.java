package cn.itcast.oa.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.stereotype.Service;

import cn.itcast.oa.dao.IApproveInfoDao;
import cn.itcast.oa.domain.ApproveInfo;
import cn.itcast.oa.service.IApproveInfoService;

/**
 * 
 * @Title: ApproveInfoServiceImpl
 * @Description: 审批管理Service实现
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月22日 下午1:42:46
 */
@Service
@Transactional
@SuppressWarnings("resource")
public class ApproveInfoServiceImpl implements IApproveInfoService{
	@Resource
	private IApproveInfoDao approveInfoDao;

	/**
	 * 根据申请id查询对应的审批集合
	 */
	public List<ApproveInfo> findApproveInfoListByApplicationId(
			Long applicationId) {
		return approveInfoDao.findApproveInfoListByApplicationId(applicationId);
	}
	
	
	
	
}
