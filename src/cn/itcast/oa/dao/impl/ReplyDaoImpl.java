package cn.itcast.oa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IReplyDao;
import cn.itcast.oa.domain.Reply;


/**
 * 
 * @Title: ReplyDaoImpl
 * @Description: 回复管理Dao接口实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午11:20:37
 *
 */
@Repository
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements IReplyDao {
	
	/**
	 * 说明：BaseDaoImpl类已经实现了IBaseDao，而IRoleDao接口又继承了了一次IBaseDao接口，可以省略
	 *     IRoleDao接口，但不能省略。原因：IBaseDao接口
	 */
	
}
