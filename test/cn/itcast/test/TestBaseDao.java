package cn.itcast.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.oa.domain.Book;
import cn.itcast.oa.service.IBookService;

/**
 * 
 * @Title: TestBaseDao
 * @Description: 测试basedao
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月20日 上午9:03:48
 */
public class TestBaseDao {
	
	/**
	 * 测试findAll操作
	 */
	@Test
	public void test6(){
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		List<Book> list = bookService.findAll();
		for(Book book : list){
			System.out.println(book);
		}
	}
	
	/**
	 * 测试getByIds操作
	 */
	@Test
	public void test5(){
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		Long[] ids = new Long[]{2L,3L,4L};
		List<Book> list = bookService.getByIds(ids);
		for(Book book : list){
			System.out.println(book);
		}
	}
	
	/**
	 * 测试getById操作
	 */
	@Test
	public void test4(){
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		Book book = bookService.getById(2L);
		System.out.println(book);
	}
	
	/**
	 * 测试update操作
	 */
	@Test
	public void test3(){
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		Book book = new Book();
		book.setId(2L);
		book.setName("php");
		
		bookService.update(book);
	}
	
	/**
	 * 测试delete操作
	 */
	@Test
	public void test2(){
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		bookService.delete(1L);
	}
	
	/**
	 * 测试save操作
	 */
	@Test
	public void test1(){
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		Book book = new Book();
		book.setName("Basic");
		
		bookService.save(book);
	}
}
