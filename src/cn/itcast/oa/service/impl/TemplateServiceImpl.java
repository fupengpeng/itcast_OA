package cn.itcast.oa.service.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

	/**
	 * 保存模板对象
	 */
	public void save(Template model) {
		templateDao.save(model);
	}

	/**
	 * 根据id删除模板对象
	 */
	public void delete(Template model) {
		templateDao.delete(model.getId());
		
		
	}

	/**
	 * 根据id查询模板对象
	 */
	public Template getById(Template model) {
		return templateDao.getById(model.getId());
	}

	/**
	 * 修改模板
	 */
	public void update(Template template) {
		templateDao.update(template);
	}

	
	/**
	 * 根据模板id获取此模板对应的文件输入流
	 */
	public InputStream getInputStreamById(Template model) {
		Template template = templateDao.getById(model.getId());
		String filePath = template.getFilePath();
		InputStream in = null;
		try {
			in = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return in;
	}

	public Template getById(Long templateId) {
		return templateDao.getById(templateId);
	}



}
