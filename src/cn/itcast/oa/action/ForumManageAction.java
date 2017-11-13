package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.utils.HQLHelper;


/**
 * 
 * @Title: ForumAction
 * @Description: 板块管理Action----增删改
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 上午9:34:50
 *
 */
@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {
	/**
	 * 查询板块列表
	 */
	public String list(){
//		List<Forum> list = forumManageService.findAll();
//		getValueStack().set("list", list);
		HQLHelper hh = new HQLHelper(Forum.class);
		hh.addOrderBy(" o.position", true);
		PageBean pb = forumManageService.getPageBean(hh,currentPage);
		getValueStack().push(pb);
		return "list";
	}
	
	/**
	 * 根据id删除板块
	 */
	public String delete(){
		forumManageService.delete(model);
		return "toList";
	}
	
	/**
	 * 跳转到添加板块页面
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * 添加板块
	 */
	public String add(){
		forumManageService.save(model);
		return "toList";
	}
	
	/**
	 * 跳转到修改板块页面
	 */
	public String editUI(){
		Forum forum = forumManageService.getById(model);
		getValueStack().push(forum);
		return "editUI";
	}
	
	/**
	 * 修改板块
	 */
	public String edit(){
		Forum forum = forumManageService.getById(model);
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		forumManageService.update(forum);
		return "toList";
	}
	
	/**
	 * 上移
	 */
	public String moveUp(){
		//select f.* from itcast_forum f where f.position < 11 order by f.position desc limit 0,1;
		forumManageService.moveUp(model);
		return "toList";
	}
	
	/**
	 * 下移
	 */
	public String moveDown(){
		forumManageService.moveDewn(model);
		return "toList";
	}
}
