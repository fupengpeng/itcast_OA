package cn.itcast.oa.dao.impl;

import java.io.File;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.ITemplateDao;
import cn.itcast.oa.domain.Template;



/**
 * 
 * @Title: TemplateDaoImpl
 * @Description: 模板管理Dao接口实现
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月17日 上午10:20:35
 */
@Repository
@SuppressWarnings("unchecked")
public class TemplateDaoImpl extends BaseDaoImpl<Template> implements ITemplateDao{

	/**
	 * 重写删除方法，删除模板对象时，也删除对应的文件
	 */
	public void delete(Long id) {
		Template template = super.getById(id);
		String filePath = template.getFilePath();  //获取模板对象保存的路径
		//删除此路径下的文件
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
		
		super.delete(id);  //删除数据库中的数据
	}

	
	
	
}
