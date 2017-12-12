package com.gsw.cash.client.service;

import java.util.List;

import com.gsw.cash.client.model.Client;

public interface ClientService {
	
	public Client create(Client client);
	
	public void delete(long id);
	
	public Client edit(Client client);
	
	public List<Client> list();
	
	public Client findClientById(Long id);
}
