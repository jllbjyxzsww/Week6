package com.itheima.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itheima.mapper.CustomerMapper;
import com.itheima.po.Customer;
import com.itheima.utils.MybatisUtils;

public class CustomerService {
	
	public static void findCustomerById() throws IOException {
//		 InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
//		 SqlSessionFactory  sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
//		 SqlSession sqlSession = sqlSessionFactory.openSession();
		SqlSession sqlSession = MybatisUtils.getSession();
		// namespace+id
		// Customer customer =
		// sqlSession.selectOne("com.itheima.mapper.CustomerMapper.findCustomerById",1);
		CustomerMapper Mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = Mapper.findCustomerById(1);
		System.out.println(customer.toString());
		sqlSession.close();

	}
	public static List<Customer> findCustomer() throws IOException {
		SqlSession sqlSession = MybatisUtils.getSession();
		CustomerMapper Mapper = sqlSession.getMapper(CustomerMapper.class);
		List<Customer> customers= Mapper.findCustomer();
		System.out.println(customers.toString());
		sqlSession.close();
		return customers;

	}

	// 插入客户
	public static void insertcustomer(Customer  customer) throws IOException {
		SqlSession sqlSession = MybatisUtils.getSession();
		int count = sqlSession.insert("com.itheima.mapper.CustomerMapper.insertCustomer", customer);
		sqlSession.commit();
		sqlSession.close();
		System.out.println("成功插入了" + count + "个客户");

	}
	
	// 删除客户
		public static void delCustomerById(Integer id) throws IOException {
			SqlSession sqlSession = MybatisUtils.getSession();
			CustomerMapper Mapper = sqlSession.getMapper(CustomerMapper.class);
			Mapper.delCustomerById(id);
			sqlSession.commit();
			sqlSession.close();
			System.out.println("删除了一个客户");

		}

	

}
