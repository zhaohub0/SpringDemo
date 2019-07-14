package cn.mldn.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.mldn.service.IAnnotationAOPService;
@Service
public class AnnotationAOPServiceImpl implements IAnnotationAOPService{

	@Override
	public boolean add(String mid) {
		Logger.getLogger(AnnotationAOPServiceImpl.class).info("业务调用，mid=" + mid);
		return false;
	}

}
