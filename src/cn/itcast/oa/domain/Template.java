package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Template
 * @Description: 模板实体
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月17日 上午9:39:47
 */
public class Template {
	
	private Long id;
	private String name;  //模板名称 
	private String processDefinitionKey;  //此模板关联的流程定义的key
	private String filePath;  //此模板对应的文件的存储路径
//	private Set<Application> applications = new HashSet<Application>();    //申请模板对应的申请
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}
	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
