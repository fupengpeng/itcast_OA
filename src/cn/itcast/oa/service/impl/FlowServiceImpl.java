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
import org.jbpm.api.ProcessInstanceQuery;
import org.jbpm.api.TaskQuery;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IApplicationDao;
import cn.itcast.oa.dao.IApproveInfoDao;
import cn.itcast.oa.domain.Application;
import cn.itcast.oa.domain.ApproveInfo;
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
	
	@Resource
	private IApproveInfoDao approveInfoDao;

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

	/**
	 * 审批处理
	 */
	public void approve(ApproveInfo ai, String taskId) {
		//3-1.根据taskId获取执行id(executionId)
		Task task = processEngine.getTaskService().getTask(taskId); //根据任务id获取当前任务
		String executionId = task.getExecutionId(); //获取执行的id
		
		//1.保存一个审批实体
		approveInfoDao.save(ai);
		
		//2.办理任务
		processEngine.getTaskService().completeTask(taskId);
		
		//3.控制流程(结束当前流程实例)
		
		//3-2.根据执行id(executionId)查询此流程实例是否执行完毕
		ProcessInstanceQuery query = processEngine.getExecutionService().createProcessInstanceQuery();
		query.processInstanceId(executionId); //添加过滤条件
		ProcessInstance pi = query.uniqueResult(); //
		//3-3.判断任务执行完毕后，审批是否通过
		System.out.println("ai.getApproval() = " + ai.getApproval());
		if (ai.getApproval()) {
			//3-3-1.审批通过
			//判断当前节点是否是最后一个节点，如果是，则设置申请状态为"已通过",不是则进行下一步
			if (pi == null) {
				//4.修改申请状态
				//当前办理任务是最后一个任务，则设置申请状态为"已通过"
				ai.getApplication().setStatus(Application.STATUS_APPROVED);
			}
			
		}else {
			//3-3-2.审批不通过
			//判断流程实例是否结束，没有结束则结束流程，已结束，则直接下一步 。修改申请状态
			if (pi != null) {
				//流程还没有结束，需要手动结束
				processEngine.getExecutionService().endProcessInstance(executionId, ProcessInstance.STATE_ENDED);
				//4.修改申请状态
				//申请状态改为"未通过"
				ai.getApplication().setStatus(Application.STATUS_UNAPPROVED);
				
			}
		}
		
	}

}
