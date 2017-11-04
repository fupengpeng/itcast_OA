package cn.itcast.oa.interceptor;

import java.util.List;

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
@SuppressWarnings(value = {"serial","unchecked"})
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
		
//		if (url.endsWith("UI")) {
//			//如果访问url以UI结尾，就去除
//			url = url.substring(0,url.length() - 2);
//		}
		
		System.out.println("访问的url  == " + url);
		//从session中获取登录用户
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		
		//判断用户是否登录
		if (user == null) {
			//一、用户未登录
			if ("/user_login".equals(url)) {
				//如果用户正在访问登录功能，放行，去登录
				System.out.println("未登录，登录请求，放行");
				ai.invoke();
			}else {
				//如果用户不是访问登录功能 ，则跳转到登录页面
				System.out.println("未登录，访问其它页面，跳转进行登录");
				return "loginUI";
			}
		}else {
//			//二、用户已登录
//			//获取到查询到的权限allUrl
//			
////			List<String> allUrl = (List<String>) ServletActionContext.getServletContext().getAttribute("allUrl");
////			
////			//判断用户所要访问的url是否属于权限的allUrl
////			if (allUrl.contains(url)) {
////				//是，则进行下一步，判断用户是否拥有此权限，拥有此权限，才可以访问，没有的话是不能访问的。
////				boolean b = user.hasPrivilegeByUrl(url);
////				//如果用户访问的是要验证的权限
////				if (b) {
////					//如果用户有权限，则放行
////					ai.invoke();
////				}else {
////					//如果用户没有权限，则跳转到没有权限的提示页面
////					return "noPrivilegeUI";
////					
////				} 
////			}else {
////				//如果用户访问的是不要验证的权限
////				ai.invoke();
////			}
		}
		
		
		System.out.println("自定义拦截器执行");
		String invoke = ai.invoke();
		return invoke;
	}

}
