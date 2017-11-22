package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Application;
import cn.itcast.oa.domain.TaskView;
import cn.itcast.oa.domain.User;


/**
 * 
 * @Title: IFlowService
 * @Description: 流转Service接口
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月21日 上午11:11:23
 */
public interface IFlowService {

	public void submit(Application app);

	public List<TaskView> findTaskList(User currentUser);
	
	
}
