package cn.mldn.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import cn.mldn.dao.IAnnotationDAO;
import cn.mldn.vo.Dept;

//此注解表示该对象由spring创建
@Repository
public class AnnotationDAOImpl implements IAnnotationDAO{

	/**
	 * 输出dept
	 */
	@Override
	public void info(Dept vo) {
		// TODO Auto-generated method stub
		Logger.getLogger(this.getClass()).info(vo);
		
	}

}
