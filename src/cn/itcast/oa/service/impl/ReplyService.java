package cn.itcast.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IReplyDao;
import cn.itcast.oa.service.IReplyService;


/**
 * 
 * @Title: ReplyService
 * @Description: 回复管理Service接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午11:17:38
 *
 */
@Service
@Transactional
public class ReplyService implements IReplyService {
	
	@Resource
	private IReplyDao replyDao;

}
