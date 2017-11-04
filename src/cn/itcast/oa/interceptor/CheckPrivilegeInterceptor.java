package cn.itcast.oa.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.itcast.oa.domain.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * 
 * @Title: CheckPrivilegeInterceptor
 * @Description: 进行权限检查的拦截器
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月3日 下午2:02:09
 *
 */
public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	/**
	 * 拦截方法
	 */
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		//方式一：从request中获取请求路径，以便以区分是什么请求
		
		//方式二：
		String actionName = ai.getProxy().getActionName();
		String namespace = ai.getProxy().getNamespace();
		String url = namespace + actionName;
		System.out.println("访问的url  == " + url);
		//从session中获取登录用户
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		
		//判断用户是否登录
		if (user == null) {
			//一、用户未登录
			if ("/user_login".equals(url)) {
				//如果用户正在访问登录功能，放行，去登录
				ai.invoke();
			}else {
				//如果用户不是访问登录功能 ，则跳转到登录页面
				return "loginUI";
			}
		}else {
			//二、用户已登录
			boolean b = user.hasPrivilegeByUrl(url);
			
			if (b) {
				//如果用户有权限，则放行
				ai.invoke();
				
			}else {
				//如果用户没有权限，则跳转到没有权限的提示页面
				return "noPrivilegeUI";
				
			}
			
			
			
			
			
			
			
			
		}
		
		
		System.out.println("自定义拦截器执行");
		return ai.invoke();
	}

}
