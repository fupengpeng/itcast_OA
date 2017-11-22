package cn.itcast.oa.service;

import java.io.InputStream;
import java.util.List;

import cn.itcast.oa.domain.Application;
import cn.itcast.oa.domain.ApproveInfo;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.utils.HQLHelper;

/**
 * 
 * @Title: IApproveInfoService
 * @Description: 审批管理Service接口
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月22日 下午1:41:31
 */
public interface IApproveInfoService {

	public List<ApproveInfo> findApproveInfoListByApplicationId(Long applicationId);
	
	
}
