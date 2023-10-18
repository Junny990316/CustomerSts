package myspring.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.vo.CustomerVO;

@Repository("userDao")
public class CustomerDaoImplMapper implements CustomerDao {
	@Autowired
	private CustomerMapper customerMapper;	
	
	@Override
	public CustomerVO read(int id) {
		CustomerVO user  = customerMapper.selectCustomerById(id);
		return user;
	}
	
	public List<CustomerVO> readAll() {
		List<CustomerVO> userList = customerMapper.selectCustomerList();
		return userList;
	}
}










