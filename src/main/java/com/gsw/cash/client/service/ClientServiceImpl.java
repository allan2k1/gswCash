package com.gsw.cash.client.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsw.cash.client.model.Client;
import com.gsw.cash.client.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepo;
	
	public Client create(Client client){
		return clientRepo.save(client);
	}
	
	public void delete(long id){
		clientRepo.delete(id);
	}
	
	public Client edit(Client client){
		return clientRepo.save(client);
	}

	public List<Client> list() {
		Iterable<Client> iterator = clientRepo.findAll();
		return StreamSupport
		    .stream(iterator.spliterator(), false)
		    .collect(Collectors.toList());
	 }
	
	public Client findClientById(Long id) {
		return clientRepo.findOne(id);
	}
}
