package cn.mldn.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

import cn.mldn.util.ResourceUtil;

public class TestResource {

	private static Logger log = null;
	private static ApplicationContext ctx = null;
	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		log = Logger.getLogger(TestResource.class);
	}
	/**
	 * 测试spring中的资源读取基本类
	 */
	@Test
	public void testResource01() {
		String s = "一段测试字符串";
		Resource resource = null;
		//读取字节数组资源
		resource = new ByteArrayResource(s.getBytes());
		//读取文件资源
//		resource = new FileSystemResource("E:"+File.separator+"test.txt");
		//读取ClassPath路径下的资源文件
//		resource = new ClassPathResource("applicationContext.xml");
		//读取URL返回的资源
		try {
			resource = new UrlResource("http://www.baidu.com");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//利用Scanner输出
		if(resource.exists()) {
			Scanner scanner = null;
			try {
				scanner = new Scanner(resource.getInputStream());
				while(scanner.hasNext()) {
					System.out.println(scanner.nextLine());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				scanner.close();
			}
			
		}			
	}
	/**
	 * 测试spring中的资源读取ResourceLoader解耦和类,根据字符串参数值创建不同的Resource实现类
	 */
	@Test
	public void testResource02() {
		//读取字节数组资源
		String s1 = "一段测试字符串";
		//读取文件资源（字符串以file:开头）
		String s2 = "file:E:" + File.separator + "test.txt";
		//读取ClassPath路径下的资源文件（字符串以classpath:开头）
		String s3 = "classpath:applicationContext.xml";
		//读取URL返回的资源（字符串以http://开头）
		String s4 = "http://www.baidu.com";
		ResourceLoader loader = new DefaultResourceLoader();
		//根据字符串参数值创建不同的Resource实现类
		Resource resource = loader.getResource(s1);
		
		//使用Scanner输出
		if(resource.exists()) {
			Scanner scanner = null;
			try {
				scanner = new Scanner(resource.getInputStream());
				while(scanner.hasNext()) {
					System.out.println(scanner.nextLine());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				scanner.close();
			}
			
		}			
	}
	/**
	 * 测试application配置Bean方式实例化Resource
	 */
	@Test
	public void testResource03() {
		ResourceUtil resUtil = ctx.getBean("resourceUtil",ResourceUtil.class);
		try {
			resUtil.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
