package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IForumDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.IForumService;


/**
 * 
 * @Title: ForumServiceImpl
 * @Description: 板块Service接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月7日 下午3:46:43
 *
 */
@Service
@Transactional
public class ForumServiceImpl implements IForumService {
	@Resource
	private IForumDao forumDao;

	public List<Forum> findAll() {
		return forumDao.findAll();
	}

	public Forum getById(Forum model) {
		return forumDao.getById(model.getId());
	}

	public Forum getById(Long forumId) {
		return forumDao.getById(forumId);
	}
	
	
	
}
