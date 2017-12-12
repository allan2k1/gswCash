package com.gsw.cash.withdrawal.service;

import static org.easymock.EasyMock.createNiceMock;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gsw.cash.money.dto.MoneyDto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WithdrawalServiceTest {
	
	private WithdrawalService withdrawalService;
	
	@Before
    public void setUp() throws Exception {
		withdrawalService = createNiceMock(WithdrawalService.class);
		withdrawalService = new WithdrawalServiceImpl();
    }

	@Test
	public void saqueServiceTeste() {
		MoneyDto notas = withdrawalService.withdrawal(320);
		
		assertEquals(notas.getHundred(), 3);
		assertEquals(notas.getTwenty(), 1);
	}	
}
