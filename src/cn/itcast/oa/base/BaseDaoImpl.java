package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.oa.domain.Book;
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
	@Resource
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	public BaseDaoImpl() {
		//获得实体类型
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();//获得真正的父类
		Type[] types = genericSuperclass.getActualTypeArguments();
		clazz = (Class<T>) types[0];
	}
	
	public void save(T entity) {
		getSession().save(entity);
	}
	
	public void delete(Long id) {
		getSession().delete(getSession().get(clazz, id));
	}
	
	public void update(T entity) {
		getSession().update(entity);
	}

	public List<T> findAll() {
		String hql = "FROM " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	public T getById(Long id) {
		return (T) getSession().get(clazz, id);
	}
	
	public List<T> getByIds(Long[] ids) {
		String hql = "FROM " + clazz.getSimpleName() + " WHERE id in (:ids)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("ids", ids);//一次赋值多个
		return query.list();
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
