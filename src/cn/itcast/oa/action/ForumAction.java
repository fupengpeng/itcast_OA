package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;


/**
 * 
 * @Title: ForumAction
 * @Description: 板块Action----查询
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 下午3:38:54
 *
 */
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {
	
	/**
	 * 查询板块列表
	 */
	public String list(){
		List<Forum> list = forumService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	/**
	 * 查询主题列表(单个板块)
	 */
	public String show(){
		
		
		return "forumShow";
	}
}
