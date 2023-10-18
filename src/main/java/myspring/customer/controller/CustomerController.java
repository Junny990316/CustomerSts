package myspring.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.customer.service.CustomerService;
import myspring.customer.vo.CustomerVO;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	public CustomerController() {
		System.out.println(this.getClass().getName() + " 생성자 호출 됨");
	}
	
	@RequestMapping("/customerList.do")
	public ModelAndView userList() {
		List<CustomerVO> customerVOList = customerService.getCustomerList();
		return new ModelAndView("customerList", "customerList", customerVOList);
	}
	
	@RequestMapping("/getCustomer.do")
	public String getCustomer(@RequestParam("id") int id, Model model) {
		CustomerVO customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "customerInfo";
	}
}
