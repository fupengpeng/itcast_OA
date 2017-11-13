package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.utils.HQLHelper;


/**
 * 
 * @Title: IReplyService
 * @Description: 回复管理Service接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月8日 上午11:16:08
 *
 */
public interface IReplyService {

	public void save(Reply model);

	public List<Reply> getReplyByTopic(Topic model);

	public PageBean getPageBean(int currentPage, Topic model);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
