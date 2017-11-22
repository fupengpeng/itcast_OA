package cn.itcast.oa.domain;

import org.jbpm.api.task.Task;


/**
 * 
 * @Title: TaskView
 * @Description: 包装申请信息和任务信息
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月22日 下午2:49:33
 */
public class TaskView {
	
	private Application application;
	private Task task;
	
	public TaskView(){}
	public TaskView(Application application, Task task) {
		super();
		this.application = application;
		this.task = task;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	
	
	
}
