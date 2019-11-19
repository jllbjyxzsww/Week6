package com.itheima.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/itheima/mapper/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}
