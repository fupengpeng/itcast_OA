package cn.itcast.oa.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.jbpm.api.ProcessDefinition;


/**
 * 
 * @Title: IProcessDefinitionService
 * @Description: 流程定义管理Service接口
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月16日 下午4:00:56
 */
public interface IProcessDefinitionService {

	public List<ProcessDefinition> findLastList();

	public void deploy(File resource);

	public void deleteByKey(String key);

	public InputStream getImageInputStream(String id);


}
