package cn.mldn.service.impl;

import org.apache.log4j.Logger;

import cn.mldn.service.IAOPService;

public class AOPServiceImpl implements IAOPService {

	@Override
	public boolean add(String mid){
		//这里测试的是面向切面proxy方法接收异常信息
//		if(true) {
//			throw new RuntimeException("抛出一个异常");
//		}
		Logger.getLogger(AOPServiceImpl.class).info("业务层add方法调用，mid=" + mid);
		return false;
	}

}
