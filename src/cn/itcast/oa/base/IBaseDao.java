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
	 * 
	 * Description: 给一个描述
	 * @param entity
	 */
	public void save(T entity);
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
	public void update(T entity);
	/**
	 * 
	 * Description: 根据id查询对象
	 * @param id
	 * @return
	 */
	public T getById(Long id);
	/**
	 * 
	 * Description: 根据id数组查询多个对象
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Long[] ids);
	/**
	 * 
	 * Description: 查询所有
	 * @return
	 */
	public List<T> findAll();
	

}
