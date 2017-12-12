package com.gsw.cash.client.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gsw.cash.client.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	
}
