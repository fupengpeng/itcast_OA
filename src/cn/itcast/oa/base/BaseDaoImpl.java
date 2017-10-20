package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



/**
 * 
 * @Title: BaseDaoImpl
 * @Description: 通用Dao接口实现类
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年10月20日 上午8:34:27
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements IBaseDao<T> {
	//使用注解注入属性
	@Resource
	private SessionFactory sessionFactory;
	//传入对象实例
	private Class<T> clazz;
	//无参构造
	public BaseDaoImpl(){
		//获得实体类型
		//应用此类时，子类(声明时有明确泛型)继承此类。通过子类对象调用getClass()方法获取当前类，再调用getGenericSuperclass()获取其实际带泛型的父类即此类(有明确泛型的此类，泛型来源于子类)
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();  //获取真正的父类
		//通过带实际泛型的此类parameterizedType对象调用getActualTypeArguments()方法，获取其实际泛型，返回数组(因为一个类可以有多个泛型)
		Type[] types = parameterizedType.getActualTypeArguments();
		//遍历此泛型数组，得到第一个元素，即此类的实际泛型(此类只有一个泛型，故获取第0个元素就可以)
		clazz = (Class<T>) types[0];
	}
	
	/**
	 * 增加
	 */
	public void save(T entity) {
		getSession().save(entity);
		
	}

	/**
	 * 删除
	 */
	public void delete(Long id) {
		// 
		getSession().delete(getSession().get(clazz, id));
	}

	/**
	 * 修改
	 */
	public void update(T entity) {
		// 
		getSession().update(entity);
	}
	
	/**
	 * 查询所有
	 */
	public List<T> findAll() {
		// 
		String hql = "FROM " + clazz.getSimpleName();    //hibernate查询实体类名对应的表数据
		return getSession().createQuery(hql).list();
	}

	/**
	 * 根据id查询
	 */
	public T getById(Long id) {
		//
		return (T) getSession().get(clazz, id);
	}
	/**
	 * 根据id查询多个数据
	 */
	public List<T> getByIds(Long[] ids) {
		// 命名参数
		String hql = "FROM " + clazz.getSimpleName() + " WHERE id in(:ids)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("ids", ids);  //一次赋值多个
		return query.list();
	}

	/**
	 * 
	 * @Description: 获取session对象
	 * @author fupengpeng
	 * @@return
	 * @date 2017年10月20日 上午8:42:08
	 */
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

}
