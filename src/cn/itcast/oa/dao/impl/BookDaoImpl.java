package cn.itcast.oa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IBookDao;
import cn.itcast.oa.domain.Book;
/**
 * 
 * @Title: BookDaoImpl
 * @Description: BookDao , 继承BaseDaoImpl
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年9月23日 上午9:17:32
 */
@Repository
public class BookDaoImpl extends BaseDaoImpl<Book> implements IBookDao {

}
