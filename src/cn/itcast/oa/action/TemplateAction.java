package cn.itcast.oa.action;

import java.io.File;
import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Template;

/**
 * 
 * @Title: TemplateAction
 * @Description: 模板管理Action
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月17日 上午10:15:05
 */
@Controller
@Scope("prototype")
public class TemplateAction extends BaseAction<Template> {

	private File resource; // 用于文件上传

	/**
	 * 查询模板列表
	 */
	public String list() {
		List<Template> list = templateService.findAll();
		getValueStack().set("list", list);
		return "list";
	}

	/**
	 * 根据id删除模板
	 */
	public String delete() {

		return "toList";
	}

	/**
	 * 跳转到修改模板页面
	 */
	public String editUI() {

		return "editUI";
	}

	/**
	 * 修改模板
	 */
	public String edit() {

		return "toList";
	}

	/**
	 * 跳转到添加模板页面
	 */
	public String addUI() {
		// 准备数据，流程定义列表
		List<ProcessDefinition> pdList = processDefinitionService
				.findLastList();
		getValueStack().set("pdList", pdList);
		return "addUI";
	}

	/**
	 * 添加模板
	 */
	public String add() {
		// 将上传的文件保存到uploadFiles目录中
		
		
		return "toList";
	}

	/**
	 * 下载模板对应的文件
	 */
	public String download() {

		return "download";
	}

	public File getResource() {
		return resource;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

}
