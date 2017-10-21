package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import cn.itcast.oa.service.IBookService;
import cn.itcast.oa.service.IDepartmentService;
import cn.itcast.oa.service.IRoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @Title: BaseAction
 * @Description: 通用父类Action
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年9月25日 上午9:42:04
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	@Resource
	protected IBookService bookService;
	@Resource
	protected IRoleService roleService;
	@Resource
	protected IDepartmentService departmentService;
	
	protected T model;
	//在构造方法中获取model类型
	public BaseAction()  {
		// 获得实体类型
		// 应用此类时，子类(声明时有明确泛型)继承此类。通过子类对象调用getClass()方法获取当前类，再调用getGenericSuperclass()获取其实际带泛型的父类即此类(有明确泛型的此类，泛型来源于子类)
		ParameterizedType parameterizedType = (ParameterizedType) this
				.getClass().getGenericSuperclass(); // 获取真正的父类
		// 通过带实际泛型的此类parameterizedType对象调用getActualTypeArguments()方法，获取其实际泛型，返回数组(因为一个类可以有多个泛型)
		Type[] types = parameterizedType.getActualTypeArguments();
		// 遍历此泛型数组，得到第一个元素，即此类的实际泛型(此类只有一个泛型，故获取第0个元素就可以)
		Class<T> clazz = (Class<T>) types[0];
		try {
			model = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	/**
	 * 
	 * @Description: 获取值栈
	 * @author fupengpeng
	 * @@return
	 * @date 2017年10月21日 上午9:23:07
	 */
	protected ValueStack getValueStack() {
		return ActionContext.getContext().getValueStack();
	}

}
