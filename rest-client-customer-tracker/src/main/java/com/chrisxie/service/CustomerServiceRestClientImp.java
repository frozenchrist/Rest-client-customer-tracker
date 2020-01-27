package com.chrisxie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chrisxie.model.Customer;

@Service
public class CustomerServiceRestClientImp implements CustomerService {

	private RestTemplate restTemplate;
	
	private String crmRestUrl;
	
	@Autowired
	 public CustomerServiceRestClientImp(RestTemplate restTemplate,
			@Value("${crm.rest.url}")String restUrl) {

		this.restTemplate = restTemplate;

		this.crmRestUrl = restUrl;
	}
	
	@Override
	public List<Customer> getCustomerList() {

		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmRestUrl,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {
				});
	
		List<Customer> customerList = responseEntity.getBody();
		
		return customerList;
		
	}

	@Override
	public Customer getCustomer(int customerId) {

		return restTemplate.getForObject(crmRestUrl + "/" + customerId,
				Customer.class);
		
	}

	@Override
	public void saveCustomer(Customer customerTosSave) {

		int customerId = customerTosSave.getId();
		
		if (customerId == 0) {
			
			restTemplate.postForEntity(crmRestUrl, customerTosSave, String.class);
			
		}else {
			
			restTemplate.put(crmRestUrl, customerTosSave);
			
		}

		
		
	}

	@Override
	public void deleteCustomer(int customerId) {

		restTemplate.delete(crmRestUrl + "/" + customerId);
		

	}

}
