package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.utils.HQLHelper;


/**
 * 
 * @Title: IForumService
 * @Description: 板块Service接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 下午3:45:20
 *
 */
public interface IForumService {

	public List<Forum> findAll();

	public Forum getById(Forum model);

	public Forum getById(Long forumId);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
