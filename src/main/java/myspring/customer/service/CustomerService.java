package myspring.customer.service;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerService {
	public List<CustomerVO> getCustomerList();
	public CustomerVO getCustomer(int id);
}
