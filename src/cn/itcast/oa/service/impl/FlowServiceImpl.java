package cn.itcast.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.TaskQuery;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IApplicationDao;
import cn.itcast.oa.domain.Application;
import cn.itcast.oa.domain.TaskView;
import cn.itcast.oa.domain.Template;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.IFlowService;

/**
 * 
 * @Title: FlowServiceImpl
 * @Description: 流转Service接口实现
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月21日 上午11:12:09
 */
@Service
@Transactional
public class FlowServiceImpl implements IFlowService {

	@Resource
	private IApplicationDao applicationDao;

	@Resource
	private ProcessEngine processEngine;

	/**
	 * 提交申请
	 */
	public void submit(Application app) {
		// 保存一个申请记录
		applicationDao.save(app);
		// 启动一个流程实例
		// 初始化流程变量
		Map<String, Application> map = new HashMap<String, Application>();
		map.put("application", app);
		// 设置流程变量
		ProcessInstance pi = processEngine.getExecutionService()
				.startProcessInstanceByKey(
						app.getTemplate().getProcessDefinitionKey(), map);
		// 办理提交申请的任务
		TaskQuery query = processEngine.getTaskService().createTaskQuery();
		query.processInstanceId(pi.getId()); // 获取当前流程实例下唯一的一个任务
		Task task = query.uniqueResult();
		String taskId = task.getId();
		System.out.println("taskId = " + taskId);
		processEngine.getTaskService().completeTask(taskId);

	}

	/**
	 * 查询我的任务列表
	 */
	public List<TaskView> findTaskList(User currentUser) {
		//根据登录用户名查询对应的任务列表
		List<Task> taskList = processEngine.getTaskService().findPersonalTasks(currentUser.getLoginName());
		
		//从流程变量中获取对应的申请Application实体
		List<TaskView> list = new ArrayList<TaskView>();
		for (Task task : taskList) {
			//遍历任务列表
			Application application = (Application) processEngine.getTaskService().getVariable(task.getId(), "application");
			TaskView tv = new TaskView(application,task);
			list.add(tv);
		}
		
		
		return list;
	}

}
