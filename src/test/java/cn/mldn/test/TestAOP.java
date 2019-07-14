package cn.mldn.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.service.IAOPService;
import cn.mldn.service.IAnnotationAOPService;

public class TestAOP {
	private static Logger log = null;
	private static ApplicationContext ctx = null;
	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		log = Logger.getLogger(TestAOP.class);
	}
	/**
	 * 测试AOP基本配置
	 */
	@Test
	public void testAOP01(){
		IAOPService aops = ctx.getBean("aOPServiceImpl",IAOPService.class);
		aops.add("123");
	}
	/**
	 * 测试AOP带参数传递
	 */
	@Test
	public void testAOP02(){
		IAOPService aops = ctx.getBean("aOPServiceImpl",IAOPService.class);
		log.info(aops.add("123"));
	}
	/**
	 * 测试AOP接收返回值
	 */
	@Test
	public void testAOP03(){
		IAOPService aops = ctx.getBean("aOPServiceImpl",IAOPService.class);
		log.info(aops.add("123"));
	}
	/**
	 * 测试AOP接收异常
	 */
	@Test
	public void testAOP04(){
		IAOPService aops = ctx.getBean("aOPServiceImpl",IAOPService.class);
		log.info(aops.add("123"));
	}
	/**
	 * 测试AOP环绕通知
	 */
	@Test
	public void testAOP05(){
		IAOPService aops = ctx.getBean("aOPServiceImpl",IAOPService.class);
		log.info(aops.add("123"));
	}
	
	/**
	 * 测试AOP注解配置
	 */
	@Test
	public void testAOP06(){
		IAnnotationAOPService aops = ctx.getBean("annotationAOPServiceImpl",IAnnotationAOPService.class);
		aops.add("123");
	}
}
