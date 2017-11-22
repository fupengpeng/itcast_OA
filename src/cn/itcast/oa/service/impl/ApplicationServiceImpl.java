package cn.itcast.oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.stereotype.Service;

import cn.itcast.oa.dao.IApplicationDao;
import cn.itcast.oa.dao.IDepartmentDao;
import cn.itcast.oa.domain.Application;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.service.IApplicationService;
import cn.itcast.oa.service.IDepartmentService;
import cn.itcast.oa.utils.HQLHelper;

/**
 * 
 * @Title: ApplicationServiceImpl
 * @Description: 申请管理Service实现
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月22日 上午10:15:56
 */
@Service
@Transactional
@SuppressWarnings("resource")
public class ApplicationServiceImpl implements IApplicationService{
	@Resource
	private IApplicationDao applicationDao;

	/**
	 * 分页
	 */
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		return applicationDao.getPageBean(hh, currentPage);
	}

	/**
	 * 根据申请的id获取当前申请对应的文件输入流
	 */
	public InputStream getInputStreamById(Long applicationId) {
		Application application = applicationDao.getById(applicationId);
		String filePath = application.getFilePath();
		InputStream in = null;
		try {
			in = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return in;
	}

	/**
	 * 根据id查询数据
	 */
	public Application getById(Long applicationId) {
		return applicationDao.getById(applicationId);
	}
	
	
}
