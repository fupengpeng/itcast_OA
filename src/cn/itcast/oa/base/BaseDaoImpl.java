package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements IBaseDao<T> {
	//使用注解注入属性
	@Resource
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	public BaseDaoImpl(){
		//获得实体类型
		//应用此类时，子类(声明时有明确泛型)继承此类。通过子类对象调用getClass()方法获取当前类，再调用getGenericSuperclass()获取其实际带泛型的父类即此类(有明确泛型的此类，泛型来源于子类)
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();  //获取真正的父类
		//通过带实际泛型的此类parameterizedType对象调用getActualTypeArguments()方法，获取其实际泛型，返回数组(因为一个类可以有多个泛型)
		Type[] types = parameterizedType.getActualTypeArguments();
		//遍历此泛型数组，得到第一个元素，即此类的实际泛型(此类只有一个泛型，故获取第0个元素就可以)
		clazz = (Class<T>) types[0];
	}

	public void save(T entity) {
		getSession().save(entity);
		
	}

	public void delete(Long id) {
		// 
		getSession().delete(getSession().get(clazz, id));
	}

	
	public void update(T entity) {
		// 
		getSession().update(entity);
	}
	
	public List<T> findAll() {
		// 
		String hql = "FORM" + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	public T getById(Long id) {
		//
		
		return (T) getSession().get(clazz, id);
	}

	public List<T> getByIds(Long[] ids) {
		// 命名参数
		String hql = "FORM" + clazz.getSimpleName() + "WHERE id in(:ids)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("ids", ids);  //一次赋值多个
		return null;
	}

	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

}
