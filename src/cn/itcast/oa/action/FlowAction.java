package cn.itcast.oa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.Template;
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
public class FlowAction extends ActionSupport{
	
	@Resource
	private ITemplateService templateService;
	
	private Long templateId;  //属性驱动，模板id
	
	
	/**
	 * 
	 * @Title: templateList 
	 * @Description: 起草申请(模板列表)
	 * @return
	 * String
	 */
	public String templateList(){
		List<Template> list = templateService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "templateList";
	}
	
	/**
	 * 
	 * @Title: submitUI 
	 * @Description: 跳转到提交申请页面
	 * @return
	 * String
	 */
	public String submitUI(){
		
		
		return "submitUI";
	}
	
	/**
	 * 
	 * @Title: submit 
	 * @Description: 提交申请
	 * @return
	 * String
	 */
	public String submit(){
		
		return "ToMyApplicationList";
	}
	
	/**
	 * 
	 * @Title: myApplicationList 
	 * @Description: 我的申请查询列表
	 * @return
	 * String
	 */
	public String myApplicationList(){
		
		return "myApplicationList";
	}
	
	/**
	 * 
	 * @Title: download 
	 * @Description: 查看申请信息(下载申请文件)
	 * @return
	 * String
	 */
    public String download(){
		
		return "download";
	}
	
    /**
     * 
     * @Title: historyApprovedList 
     * @Description: 查看流转记录(审批信息)
     * @return
     * String
     */
	public String historyApprovedList(){
		
		return "historyApprovedList";
	}
	
	/**
	 * 
	 * @Title: myTaskList 
	 * @Description: 待我审批(我的任务列表)
	 * @return
	 * String
	 */
	public String myTaskList(){
		
		return "myTaskList";
	}
	
	/**
	 * 
	 * @Title: approveUI 
	 * @Description: 跳转到审批页面
	 * @return
	 * String
	 */
	public String approveUI(){
		
		return "approveUI";
	}
	
	/**
	 * 
	 * @Title: approve 
	 * @Description: 审批处理
	 * @return
	 * String
	 */
	public String approve(){
		
		return "toMyTaskList";
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	
	
	
}
