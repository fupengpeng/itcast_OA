package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IBookDao;
import cn.itcast.oa.domain.Book;
import cn.itcast.oa.service.IBookService;


/**
 * 
 * @Title: BookServiceImpl
 * @Description: IBookService实现
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月20日 上午9:00:25
 */
@Service
@Transactional
public class BookServiceImpl implements IBookService {
	
	@Resource
	private IBookDao bookDao;
	@Resource
	private ProcessEngine processEngine;

	public void delete(Long id) {
		System.out.println("------------"+processEngine);
		bookDao.delete(id);
	}

	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	public Book getById(Long id) {
		// TODO Auto-generated method stub
		return bookDao.getById(id);
	}

	public List<Book> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return bookDao.getByIds(ids);
	}

	public void save(Book book) {
		// TODO Auto-generated method stub
		bookDao.save(book);
	}

	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
	}


}
