package cn.itcast.oa.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.stereotype.Service;

import cn.itcast.oa.dao.ITemplateDao;
import cn.itcast.oa.domain.Template;
import cn.itcast.oa.service.ITemplateService;

/**
 * 
 * @Title: TemplateServiceImpl
 * @Description: 模板管理Service实现
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月17日 上午10:17:54
 */
@Service
@Transactional
public class TemplateServiceImpl implements ITemplateService{
	@Resource
	private ITemplateDao templateDao;

	/**
	 * 查询所有模板列表
	 */
	public List<Template> findAll() {
		return templateDao.findAll();
	}
	

}
