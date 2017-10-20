package cn.itcast.oa.action;

import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Book;


/**
 * @Title: BookAction
 * @Description: BaseAction测试
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月20日 上午11:48:17
 */
@Controller
public class BookAction extends BaseAction<Book> {

	@Override
	public String execute() throws Exception {
		// 
		System.out.println("model = " + model);
		bookService.save(model);
		
		return NONE;
	}

	
	
}
