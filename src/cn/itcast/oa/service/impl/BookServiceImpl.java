package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

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
	
	public void save(Book entity) {
		// TODO Auto-generated method stub
		bookDao.save(entity);
		
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		bookDao.delete(id);
	}

	public void update(Book entity) {
		// TODO Auto-generated method stub
		bookDao.update(entity);
	}

	public Book getById(Long id) {
		// TODO Auto-generated method stub
		return bookDao.getById(id);
	}

	public List<Book> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return bookDao.getByIds(ids);
	}

	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}
	


}
