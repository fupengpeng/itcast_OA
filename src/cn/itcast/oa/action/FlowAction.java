package cn.itcast.oa.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Encoder;
import cn.itcast.oa.domain.Application;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Template;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.IApplicationService;
import cn.itcast.oa.service.IFlowService;
import cn.itcast.oa.service.ITemplateService;
import cn.itcast.oa.utils.HQLHelper;

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
	@Resource
	private IApplicationService applicationService;

	private Long templateId; // 属性驱动，模板id
	private File resource; // 用于文件上传
	private String status; // 申请状态
	private int currentPage = 1; // 当前页码
	private Long applicationId; // 属性驱动，申请id 
	private InputStream inputStream; // 用于文件下载的输入流
	private String fileName; // 下载用的文件名
	

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
		
		System.out.println("app = " + app.toString());
		flowService.submit(app);

		return "toMyApplicationList";
	}

	/**
	 * 
	 * @Title: myApplicationList
	 * @Description: 我的申请查询列表
	 * @return String
	 */
	public String myApplicationList() {
		//准备数据：模板列表
		List<Template> list = templateService.findAll();
		ActionContext.getContext().getValueStack().set("templateList", list);
		
		//查询分页数据：我的申请
		HQLHelper hh = new HQLHelper(Application.class);
		
		//查询当前登录人的申请记录
		hh.addWhere(" o.applicant = ? ", getCurrentUser());
		
		if (templateId != null) {
			//按照模板检索
			hh.addWhere(" o.template.id = ? ", templateId);
		}
		if (status != null && status.trim().length() > 0) {
			//按照申请状态检索
			hh.addWhere(" o.status = ? ", status);
		}
		
		//添加排序--按照申请时间降序
		hh.addOrderBy(" o.applyTime ", false);
		
		PageBean pb = applicationService.getPageBean(hh,currentPage);
		ActionContext.getContext().getValueStack().push(pb);
		
		return "myApplicationList";
	}

	/**
	 * 
	 * @Description: 查看申请信息(下载申请文件)
	 * @Title: download 
	 * @return
	 * String
	 */
	public String download() {
		inputStream = applicationService.getInputStreamById(applicationId);
		Application app = applicationService.getById(applicationId);
		fileName = app.getTitle() + ".doc";
		String agent = ServletActionContext.getRequest().getHeader("user-agent");
		try {
			fileName = this.encodeDownloadFilename(fileName, agent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "download";
	}

	/**
	 * 
	 * @Description: 查看流转记录(审批信息)
	 * @Title: historyApprovedList 
	 * @return
	 * String
	 */
	public String historyApprovedList() {
		// 2.根据申请的id查询对应的审批列表
		
		
		
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

	/**
	 * 下载文件时，针对不同浏览器，进行附件名的编码
	 * @param filename  下载文件名
	 * @param agent  客户端浏览器(通过request.getHeader("user-agent")获得)
	 * @return 编码后的下载附件名
	 * @throws IOException
	 */
	public String encodeDownloadFilename(String filename, String agent)
			throws IOException {
		if (agent.contains("Firefox")) { // 火狐浏览器
			filename = "=?UTF-8?B?"
					+ new BASE64Encoder().encode(filename.getBytes("utf-8"))
					+ "?=";
		} else { // IE及其他浏览器
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	


	
	
}
