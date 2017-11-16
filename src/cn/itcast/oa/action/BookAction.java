package cn.itcast.oa.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Book;

/**
 * 
 * @Title: BookAction
 * @Description: 描述
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月14日 下午1:01:03
 */
@Controller
@Scope("prototype")
public class BookAction extends BaseAction<Book>{
	public String execute() throws Exception {
		System.out.println(model);
		
		bookService.save(model);
		return NONE;
	}
}
