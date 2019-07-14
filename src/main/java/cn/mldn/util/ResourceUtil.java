package cn.mldn.util;

import java.util.Scanner;

import org.springframework.core.io.Resource;

public class ResourceUtil {
	
	private Resource resource;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public void print() throws Exception {	// 直接输出资源的内容
		if (this.resource.exists()) {	// 表示该资源存在
			Scanner scan = new Scanner(this.resource.getInputStream()) ;
			scan.useDelimiter(" ") ;
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
			scan.close(); 
		} 
	}

}
