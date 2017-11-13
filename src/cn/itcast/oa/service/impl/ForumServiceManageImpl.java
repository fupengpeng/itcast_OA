package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IForumManageDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.service.IForumManageService;
import cn.itcast.oa.utils.HQLHelper;


/**
 * 
 * @Title: ForumServiceManageImpl
 * @Description: 板块管理Service实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 上午9:49:38
 *
 */
@Service
@Transactional
public class ForumServiceManageImpl implements IForumManageService {
	@Resource
	private IForumManageDao forumManageDao;

	/**
	 * 查询板块列表
	 */
	public List<Forum> findAll() {
		return forumManageDao.findAll();
	}

	/**
	 * 根据id删除板块
	 */
	public void delete(Forum model) {
		forumManageDao.delete(model.getId());
	}

	/**
	 * 保存板块
	 */
	public void save(Forum model) {
		forumManageDao.save(model);
		
	}

	
	/**
	 * 根据id查询板块
	 */
	public Forum getById(Forum model) {
		return forumManageDao.getById(model.getId());
	}

	/**
	 * 根据id修改板块信息
	 */
	public void update(Forum forum) {
		forumManageDao.update(forum);
	}

	public void moveUp(Forum model) {
		forumManageDao.moveUp(model);
	}

	public void moveDewn(Forum model) {
		forumManageDao.moveDown(model);
		
	}

	/**
	 * 分页查询
	 */
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		return forumManageDao.getPageBean(hh, currentPage);
	}

}
