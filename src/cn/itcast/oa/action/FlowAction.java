package cn.itcast.oa.action;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.Application;
import cn.itcast.oa.domain.Template;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.IFlowService;
import cn.itcast.oa.service.ITemplateService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @Title: FlowAction
 * @Description: 流转Action
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月21日 上午10:55:36
 */
@Controller
@Scope("prototype")
public class FlowAction extends ActionSupport {

	@Resource
	private ITemplateService templateService;
	@Resource
	private IFlowService flowService;

	private Long templateId; // 属性驱动，模板id

	private File resource; // 用于文件上传

	/**
	 * 
	 * @Title: templateList
	 * @Description: 起草申请(模板列表)
	 * @return String
	 */
	public String templateList() {
		List<Template> list = templateService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "templateList";
	}

	/**
	 * 
	 * @Title: submitUI
	 * @Description: 跳转到提交申请页面
	 * @return String
	 */
	public String submitUI() {
		return "submitUI";
	}

	/**
	 * 
	 * @Title: submit
	 * @Description: 提交申请
	 * @return String
	 */
	public String submit() {
		// 处理上传文件
		String filePath = uploadFile(resource);

		// 保存一个申请记录
		Template template = templateService.getById(templateId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String title = template.getName() + "_" + getCurrentUser().getName()
				+ "_" + sdf.format(new Date());
		Application app = new Application();
		app.setTitle(title); // 申请标题--(模板名称-申请人名称-日期)
		app.setStatus(Application.STATUS_RUNNING); // 申请状态
		app.setApplyTime(new Date()); // 申请时间
		app.setFilePath(filePath); // 文件存储路径
		app.setTemplate(template); // 使用的申请模板
		app.setApplicant(getCurrentUser()); // 申请人

		flowService.submit(app);

		return "ToMyApplicationList";
	}

	/**
	 * 
	 * @Title: myApplicationList
	 * @Description: 我的申请查询列表
	 * @return String
	 */
	public String myApplicationList() {

		return "myApplicationList";
	}

	/**
	 * 
	 * @Title: download
	 * @Description: 查看申请信息(下载申请文件)
	 * @return String
	 */
	public String download() {

		return "download";
	}

	/**
	 * 
	 * @Title: historyApprovedList
	 * @Description: 查看流转记录(审批信息)
	 * @return String
	 */
	public String historyApprovedList() {

		return "historyApprovedList";
	}

	/**
	 * 
	 * @Title: myTaskList
	 * @Description: 待我审批(我的任务列表)
	 * @return String
	 */
	public String myTaskList() {

		return "myTaskList";
	}

	/**
	 * 
	 * @Title: approveUI
	 * @Description: 跳转到审批页面
	 * @return String
	 */
	public String approveUI() {

		return "approveUI";
	}

	/**
	 * 
	 * @Title: approve
	 * @Description: 审批处理
	 * @return String
	 */
	public String approve() {

		return "toMyTaskList";
	}

	/**
	 * 
	 * @Title: getCurrentUser
	 * @Description: 获取当前登录用户
	 * @return User
	 */
	public User getCurrentUser() {
		return (User) ServletActionContext.getRequest().getSession()
				.getAttribute("loginUser");
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
//		resource.renameTo(dest);
		file.renameTo(dest);
		return filePath;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public File getResource() {
		return resource;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}
	


	
	
}
