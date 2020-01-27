package com.chrisxie.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chrisxie.model.Customer;
import com.chrisxie.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	private List<Customer> tempCustomers = new LinkedList<>();
	
	@PostConstruct
	public void tempListPopulator() {
		
		tempCustomers.add(new Customer(0, "chris", "xie", "xc@123.com"));
		
		tempCustomers.add(new Customer(1, "lu", "niu", "ln@123.com"));
		
	}
	
	
	
	@GetMapping("/home")
	public String showHomePage(Model model) {
		
		List<Customer> customerList = customerService.getCustomerList();
		
		model.addAttribute("customerList", customerList);
		
		return "home-page";
		
	}
	
	@GetMapping("/addCustomer")
	public String showCustomerForm(Model model) {
		
		model.addAttribute("newCustomer", new Customer());
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect:/home";
	}
	
	
	@GetMapping("/updateCustomer")
	public String showUpdatePage(@RequestParam int customerId, Model model) {
		
		model.addAttribute("newCustomer", customerService.getCustomer(customerId));
		
		
		return "customer-form";
	}
	
	
	@GetMapping("/deleteCustomer")
public String deleteCustomer(@RequestParam int customerId) {
		
		customerService.deleteCustomer(customerId);
		
		return "redirect:/home";
	}
}
