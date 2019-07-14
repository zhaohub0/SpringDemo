package cn.mldn.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import cn.mldn.dao.IAnnotationDAO;
import cn.mldn.service.IAnnotationService;
import cn.mldn.vo.Dept;

/*	
 * Service注解表示配置了一个spring bean,如果不写value值，
 * 则默认id为类名首字母小写,写上value值则指定beanid,value=可以省略
 * 
 * @Repository、@Service @Controller@Component 作用等同，
 * 分别表示分层结构中的持久层、业务层、和控制层和比较中立的工具层，最好分层注解，以提高程序的可读性
 */
@Service(value="annotationServiceImpl")
/*
 * 如果不写上@Scope注解，则默认对象创建是单例模式，有些类为了保证线程安全，
 * 需要手动设置其对象创建方式为prototype（每次创建新的对象）
 * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。每次获取的时候才会调用方法创建对象；
 * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器中拿，
 * request：同一次请求创建一个实例
 * session：同一个session创建一个实例
 */
@Scope("prototype")
public class AnnotationServiceImpl implements IAnnotationService {
	/*
	 * @Resource注解表示自动匹配注入对象。
	 * (1)、@Resource后面没有任何内容，默认通过name属性去匹配bean，找不到再按type去匹配
	 * (2)、指定了name或者type则根据指定的类型去匹配bean
	 * (3)、指定了name和type则根据指定的name和type去匹配bean，任何一个不匹配都将报错
	 * 		区分一下@Autowired和@Resource两个注解的区别：
	 * (1)、@Autowired默认按照byType方式进行bean匹配，@Resource默认按照byName方式进行bean匹配
	 * (2)、@Autowired是Spring的注解，@Resource是J2EE的注解，这个看一下导入注解的时候这两个注解的包名就一清二楚了
	 * 
	 * (按照此种注解方式注入对象不需要写上setter方法，原因：反射时打开了属性的访问权限)
	 */
	@Resource(name="annotationDAOImpl")
//	@Autowired
	private IAnnotationDAO annotationDaoImpl;
	
	@Override
	public void info(Dept vo) {
		// TODO Auto-generated method stub
		annotationDaoImpl.info(vo);

	}

}
