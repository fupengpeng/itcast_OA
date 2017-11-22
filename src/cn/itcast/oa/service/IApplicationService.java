package cn.itcast.oa.service;

import java.io.InputStream;
import java.util.List;

import cn.itcast.oa.domain.Application;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.utils.HQLHelper;

/**
 * 
 * @Title: IApplicationService
 * @Description: 申请管理Service接口
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月22日 上午10:14:49
 */
public interface IApplicationService {

	public PageBean getPageBean(HQLHelper hh, int currentPage);

	public InputStream getInputStreamById(Long applicationId);

	public Application getById(Long applicationId);
	

}
