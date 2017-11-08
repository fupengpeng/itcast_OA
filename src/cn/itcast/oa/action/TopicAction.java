package cn.itcast.oa.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Topic;


/**
 * 
 * @Title: TopicAction
 * @Description: 主题管理Action
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午11:05:12
 *
 */
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

}
