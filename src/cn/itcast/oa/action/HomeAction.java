package cn.itcast.oa.action;

import org.springframework.stereotype.Controller;


/**
 * 
 * @Title: HomeAction
 * @Description: 主页Action
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月2日 上午8:41:58
 *
 */
@Controller
public class HomeAction {
	/**
	 * 跳转到首页面
	 */
	public String index(){
		
		return "index";
	}
	
	/**
	 * 跳转到top.jsp页面
	 */
	public String top(){
		
		return "top";
	}
	
	/**
	 * 跳转到left.jsp页面
	 */
	public String left(){
		
		return "left";
	}
	
	/**
	 * 跳转到right.jsp页面
	 */
	public String right(){
		
		return "right";
	}
	
	/**
	 * 跳转到bottom.jsp页面
	 */
	public String bottom(){
		
		return "bottom";
	}

}
