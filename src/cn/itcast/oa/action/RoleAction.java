package cn.itcast.oa.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Role;


/**
 * 
 * @Title: RoleAction
 * @Description: 岗位管理Action
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年9月25日 下午1:45:56
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

}
