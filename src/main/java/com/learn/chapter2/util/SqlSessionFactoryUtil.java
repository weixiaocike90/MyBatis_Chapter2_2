package com.learn.chapter2.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {

	private static SqlSessionFactory sqlSessionFactory = null;
	
	private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;
	
	//私有化构造函数
	private SqlSessionFactoryUtil() {
		
	}
	
	//构造SqlSessionFactory
	public static SqlSessionFactory initSqlSessionFactoy() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		synchronized (CLASS_LOCK) {
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}
		}
		
		return sqlSessionFactory;
	}
	
	public static SqlSession openSqlSession() {
		if(sqlSessionFactory == null) {
			initSqlSessionFactoy();
		}
		
		return sqlSessionFactory.openSession();
	}
	
}
