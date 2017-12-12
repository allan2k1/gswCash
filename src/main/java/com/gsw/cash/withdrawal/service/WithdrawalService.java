package com.gsw.cash.withdrawal.service;

import com.gsw.cash.money.dto.MoneyDto;

public interface WithdrawalService {
	
	public MoneyDto withdrawal(int value);
}
