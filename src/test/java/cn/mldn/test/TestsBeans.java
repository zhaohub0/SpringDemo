package cn.mldn.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.dao.IAnnotationDAO;
import cn.mldn.dao.impl.AnnotationDAOImpl;
import cn.mldn.service.IAnnotationService;
import cn.mldn.service.IMessageService;
import cn.mldn.service.impl.AnnotationServiceImpl;
import cn.mldn.vo.Bean01;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;
import cn.mldn.vo.TestBean;
import junit.framework.TestCase;

public class TestsBeans {

	private static ApplicationContext ctx = null ;
	static {	// 静态代码块优先于所有的代码执行，目的是为了静态属性初始化
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	/**
	 * 测试简单bean初始化
	 */
	@Test
	public void testGetInfo() {
		IMessageService msgService = ctx.getBean("msg", IMessageService.class);
		Logger.getLogger(this.getClass()).info(msgService.getInfo());
		TestCase.assertEquals(msgService.getInfo(), "www.mldn.cn");
	}
	/**
	 * 测试构造方法注入属性值
	 */
	@Test
	public void testBean() {
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		Logger.getLogger(TestsBeans.class).info(testBean);
	}
	/**
	 * 测试属性注入bean初始化
	 */
	@Test
	public void testDept() {
		Dept dept = ctx.getBean("dept", Dept.class);
		Logger.getLogger(TestsBeans.class).info(dept);
	}
	/**
	 * 测试引入对象注入bean初始化
	 */
	@Test
	public void testEmp() {
		Emp emp = ctx.getBean("emp", Emp.class);
		Logger.getLogger(TestsBeans.class).info(emp);
	}
	/**
	 * 测试P命名空间bean初始化
	 */
	@Test
	public void testEmp1() {
		Emp emp1 = ctx.getBean("emp1", Emp.class);
		Logger.getLogger(TestsBeans.class).info(emp1);
	}
	/**
	 * 测试集合注入bean初始化
	 */
	@Test
	public void testBean01() {
		Bean01 bean01 = ctx.getBean("bean01", Bean01.class);
		Logger.getLogger(TestsBeans.class).info(bean01);
	}
	/**
	 * 测试注解bean初始化
	 */
	@Test
	public void testAnotationService() {
		//这里的annotationDAOImpl类上加了Service标签，默认id为类首字母大写
		IAnnotationService IDao = ctx.getBean("annotationServiceImpl",AnnotationServiceImpl.class);
		Dept vo = new Dept();
		vo.setDeptno(10);
		vo.setDname("张三");
		IDao.info(vo);
	}
	@Test
	public void testResource() {
		AnnotationServiceImpl imp = new AnnotationServiceImpl();
	}
	
}
