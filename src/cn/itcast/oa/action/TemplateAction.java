package cn.itcast.oa.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sun.mail.util.BASE64EncoderStream;

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
	
	private InputStream downloadFile; // 用于文件下载的输入流
	
	private String fileName;  //下载时的模板名称

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
		// 删除时，除了删除数据库中的记录以外，还删除记录下保存的文件
		templateService.delete(model);

		return "toList";
	}

	/**
	 * 跳转到修改模板页面
	 */
	public String editUI() {
		// 根据id查询模板对象用于页面回显
		Template template = templateService.getById(model);
		getValueStack().push(template);
		// 查询流程定义列表，用于填充所用的流程下拉列表
		List<ProcessDefinition> pdList = processDefinitionService
				.findLastList();
		getValueStack().set("pdList", pdList);
		return "editUI";
	}

	/**
	 * 修改模板
	 */
	public String edit() {
		// 先查询，在修改
		Template template = templateService.getById(model);
		template.setName(model.getName());
		template.setProcessDefinitionKey(model.getProcessDefinitionKey());

		// 判断用户是否上传文件
		if (resource != null) {
			// 用户上传了文件
			String filePath = uploadFile(resource);

			// 删除原来的文件
			String path = template.getFilePath();
			File file = new File(path);
			if (file.exists()) {
				file.delete();
			}
			
			template.setFilePath(filePath); //设置新文件的路径
		}

		templateService.update(template);

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

		String filePath = uploadFile(resource);
		model.setFilePath(filePath);
		templateService.save(model);

		return "toList";
	}

	/**
	 * 下载模板对应的文件
	 */
	public String download() {
		downloadFile = templateService.getInputStreamById(model);
		Template template = templateService.getById(model);
		fileName = template.getName() + ".doc";
		return "download";
	}

	/**
	 * 
	 * @Title: uploadFile
	 * @Description: 文件上传
	 * @param file
	 * @return String
	 */
	private String uploadFile(File file) {
		// 将上传的文件保存到uploadFiles目录中
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/WEB-INF/uploadFiles");
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String dateStr = sdf.format(new Date());
		dateStr = realPath + dateStr;
		File dateFile = new File(dateStr);
		if (!dateFile.exists()) {
			dateFile.mkdirs();
		}
		String filePath = dateStr + UUID.randomUUID().toString() + ".doc";
		File dest = new File(filePath);
		resource.renameTo(dest);
		return filePath;
	}
	
	

	public File getResource() {
		return resource;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	public InputStream getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}
	
	

}
