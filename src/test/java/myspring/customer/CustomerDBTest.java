package myspring.customer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.service.CustomerService;
import myspring.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-customer.xml")
public class CustomerDBTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void service() {
		CustomerVO customer = customerService.getCustomer(1);
		System.out.println(customer);
	}

	
	@Test 
	public void mapper() {
		CustomerVO customer = customerMapper.selectCustomerById(1);
	}
	
	@Test @Disabled
	public void session() {
		CustomerVO customer = sqlSession.selectOne("CustomerNS.selectCustomerById" ,1);
		System.out.println(customer);
	}
	
	@Test @Disabled
	public void sessionFactory() {
		System.out.println(sessionFactory.getClass().getName());
	}
	
	@Test @Disabled
	public void conn() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB Product Name : " + metaData.getDatabaseProductName());
			System.out.println("DB URL : " + metaData.getURL());
			System.out.println("DB Username : " + metaData.getUserName());
			System.out.println("DB Driver Name : " + metaData.getDriverName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // conn()
}
