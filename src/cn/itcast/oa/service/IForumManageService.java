package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Forum;


/**
 * 
 * @Title: IForumManageService
 * @Description: 板块管理Service接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 上午9:48:51
 *
 */
public interface IForumManageService {

	public List<Forum> findAll();

	public void delete(Forum model);

	public void save(Forum model);

	public Forum getById(Forum model);

	public void update(Forum forum);

}
