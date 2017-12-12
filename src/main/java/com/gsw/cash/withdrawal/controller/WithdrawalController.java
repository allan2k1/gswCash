package com.gsw.cash.withdrawal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsw.cash.client.model.Client;
import com.gsw.cash.client.service.ClientService;
import com.gsw.cash.money.dto.MoneyDto;
import com.gsw.cash.withdrawal.service.WithdrawalService;

@RequestMapping(value="/withdrawal")
@RestController
public class WithdrawalController {
	
	@Autowired
	public WithdrawalService withdrawalService;
	
	@Autowired
	public ClientService clientService;
	
	@PostMapping(value = "/{id}/{value}")
	public MoneyDto withdrawal(@PathVariable("value") final int value, @PathVariable("id") final Long id){
		
		Client client = clientService.findClientById(id);
		
		MoneyDto money = withdrawalService.withdrawal(value);
		
		client.setBalance((client.getBalance() + money.getRemnant()) - value);
		
		clientService.edit(client);
		
		return money;
	}

}
