package cn.itcast.oa.base;

import java.util.List;

/**
 * 
 * @Title: IBaseDao
 * @Description: 通用Dao接口
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年9月22日 下午5:26:14
 */
public interface IBaseDao<T> {
	/**
	 * 添加
	 */
	public void save(T entity);
	
	/**
	 * 根据id删除
	 */
	public void delete(Long id);
	
	/**
	 * 根据id修改
	 */
	public void update(T entity);
	
	/**
	 * 根据id查询
	 */
	public T getById(Long id);
	
	/**
	 * 一次查询多个对象
	 */
	public List<T> getByIds(Long[] ids);
	
	/**
	 * 查询所有
	 */
	public List<T> findAll();
}
