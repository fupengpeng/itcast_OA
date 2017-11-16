package cn.itcast.oa.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.service.IProcessDefinitionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @Title: ProcessDefinitionAction
 * @Description: 流程定义管理Action
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月16日 下午3:51:34
 */
@Controller
@Scope("prototype")
public class ProcessDefinitionAction extends ActionSupport{
	
	private String key;  // 属性驱动，流程定义的key
	
	private File resource; //用于文件上传
	
	@Resource
	private IProcessDefinitionService processDefinitionService;
	
	/**
	 * 查询流程定义列表
	 */
	public String list(){
		
		List<ProcessDefinition> list = processDefinitionService.findLastList();
		ActionContext.getContext().getValueStack().set("list", list);
		
		return "list";
	}
	
	/**
	 * 根据key删除流程定义
	 */
	public String delete(){
		//传递key删除流程定义
//		try {
//			key = new String(key.getBytes("iso-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		processDefinitionService.deleteByKey(key);
		return "toList";
	}
	
	/**
	 * 跳转到流程定义部署页面
	 */
	public String addUI(){
		
		return "addUI";
	}
	
	/**
	 * 部署流程定义
	 */
	public String add(){
		//使用上传的文件部署流程定义。
		processDefinitionService.deploy(resource);
		return "toList";
	}
	
	/**
	 * 查询流程图
	 */
	public String showImage(){
		//查询数据库，获取流程图，将流程图下载下来，在页面展示
		
		return "showImage";
	}

	public File getResource() {
		return resource;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	
	
	
}
