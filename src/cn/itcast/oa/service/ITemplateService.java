package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Template;


/**
 * 
 * @Title: ITemplateService
 * @Description: 模板管理Service接口
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月17日 上午10:16:46
 */
public interface ITemplateService {

	public List<Template> findAll();


}
