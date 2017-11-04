package cn.itcast.oa.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.IPrivilegeService;

/**
 * 
 * @Title: OAInitListener
 * @Description: 项目启动时加载权限数据的监听器
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月2日 上午10:34:47
 *
 */
public class OAInitListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public OAInitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//1.获取spring容器
    	WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
    	
    	//2.从spring容器中获取IPrivilegeService
    	IPrivilegeService service = (IPrivilegeService) applicationContext.getBean("privilegeServiceImpl");
    	
    	//3.使用IPrivilegeService，查询权限数据， 
    	List<Privilege> topList = service.findTopList();
    	
    	//4.将查询到的权限数据放入到Application作用域
    	sce.getServletContext().setAttribute("privilegeTopList", topList);
    	//
    	System.out.println("---------------------------------");
    	
    	
    	//查询所有要进行校验的权限url
    	List<String> allUrl = service.findAllUrl();
    	sce.getServletContext().setAttribute("allUrl", allUrl);
    	
    	
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
