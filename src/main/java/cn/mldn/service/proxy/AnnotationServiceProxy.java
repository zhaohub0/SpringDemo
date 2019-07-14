package cn.mldn.service.proxy;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 代理方法，用于aop操作
 * @author Administrator
 *
 */
//声明代理方法
@Aspect
//声明springbean（这里用的是组件注解）
@Component
public class AnnotationServiceProxy {
	
	/**
	 * 方法执行前调用
	 */
	@Before("execution(* cn.mldn.service..*.*(..))")
	public void beforeInvoke() {
		Logger.getLogger(AnnotationServiceProxy.class).info("自定义的beforeInvoke方法，在切面方法执行前调用");
	}
	/**
	 * 方法执行后调用
	 */
	@After("execution(* cn.mldn.service..*.*(..))")
	public void afterInvoke() {
		Logger.getLogger(AnnotationServiceProxy.class).info("自定义的afterInvoke方法，在切面方法执行后调用");
	}
	
	/**
	 * 方法执行前调用,带参数
	 */
	@Before(value = "execution(* cn.mldn.service..*.*(..)) and args (id)", argNames="id")
	public void beforeInvokeParameter(Object o) {
		Logger.getLogger(AnnotationServiceProxy.class).info("自定义的beforeInvokeParameter方法，在切面方法执行前调用，参数o=" + o);
	}
	
	/**
	 * 方法执行后调用,带返回值
	 */
	@AfterReturning(value = "execution(* cn.mldn.service..*.*(..))",argNames = "v",returning = "v")
	public void afterInvokeReturning(Object o) {
		Logger.getLogger(AnnotationServiceProxy.class).info("自定义的afterInvokeReturning方法，在切面方法执行后调用,返回值=" + o);
	}
	
	/**
	 * 方法执行后调用,接收异常
	 * @throws Exception 
	 */
	@AfterThrowing(value = "execution(* cn.mldn.service..*.*(..))",argNames = "e",throwing = "e")
	public void afterInvokeThrowing(Object o){
		Logger.getLogger(AnnotationServiceProxy.class).info("自定义的afterInvokeThrowing方法，在切面方法执行后调用,返回异常=" + o);
	}
	/**
	 * 环绕通知，可以接收参数，修改传递参数， 和获取返回结果
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "execution(* cn.mldn.service..*.*(..))")
	public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable{
		//接收用户传递参数信息
		Logger.getLogger(AnnotationServiceProxy.class).info("arroundInvoke接收到的参数=" + Arrays.toString(point.getArgs()));
		//正常传递用户参数
//		Object o = point.proceed(point.getArgs());
		//传递自己修改后的参数(此处的返回值为原方法返回值)，返回正常结果
		Object obj = point.proceed(new Object[] {"arroundInvoke自己定义的参数"});
		//输出返回结果
		Logger.getLogger(AnnotationServiceProxy.class).info("arroundInvoke返回的结果="+ obj);
		//此处可以修改原方法的返回值(正常返回应为obj)
		return true;
	}
	
}
