package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Book;

public interface IBookService {
	
	/**
	 * 
	 * Description: 给一个描述
	 * @param entity
	 */
	public void save(Book entity);
	/**
	 * 
	 * Description: 根据id查询
	 * @param id
	 */
	public void delete(Long id);
	/**
	 * 
	 * Description: 根据id修改
	 * @param entity
	 */
	public void update(Book entity);
	/**
	 * 
	 * Description: 根据id查询对象
	 * @param id
	 * @return
	 */
	public Book getById(Long id);
	/**
	 * 
	 * Description: 根据id数组查询多个对象
	 * @param ids
	 * @return
	 */
	public List<Book> getByIds(Long[] ids);
	/**
	 * 
	 * Description: 查询所有
	 * @return
	 */
	public List<Book> findAll();

}
