package com.gsw.cash.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsw.cash.client.model.Client;
import com.gsw.cash.client.service.ClientService;

@RequestMapping(value="/client")
@RestController
public class ClientController {
	
	@Autowired
	public ClientService clientService;
	
	@PostMapping
	public void criarCliente(@RequestBody Client client){
		clientService.create(client);
	}
	
	@DeleteMapping(value = "/{id}")
	public void detetarCliente(@PathVariable("id") final Long id){
		clientService.delete(id);
	}
	
	@PutMapping
	public void editarCliente(@RequestBody Client cliente){
		clientService.edit(cliente);
	}
	
	@GetMapping
	public List<Client> listarCliente(){
		return clientService.list();
	}

}
