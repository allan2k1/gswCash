package com.gsw.cash.client.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gsw.cash.client.model.Client;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {

	@Autowired
	private ClientRepository clientRepository;
		
	@Test
	public void findClientByName() throws Exception {
		this.clientRepository.save(new Client("Allan", "43059616876", 700.00, "allan2k1", "123456", "allan@hotmail.com"));
		Client cliente = this.clientRepository.findOne(1L);
		assertEquals(cliente.getLogin(), "allan2k1");
	}
	
}
