package com.infytel.service;

import java.util.List;

import com.infytel.dto.CustomerDTO;

public interface CustomerService {
	// Method to get all the Customer record from the db
    public List<CustomerDTO> getAll();
    // Method to update a Customer record from the db
    public void update(Long phoneNo, String address);

}
