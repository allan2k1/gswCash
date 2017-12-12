package com.gsw.cash.withdrawal.service;

import org.springframework.stereotype.Service;

import com.gsw.cash.money.dto.MoneyDto;

@Service
public class WithdrawalServiceImpl implements WithdrawalService {
	
	public MoneyDto withdrawal(int value) {

		MoneyDto money = new MoneyDto();

		if (value >= 0) {

			if (value >= 100) {
				money.setHundred(value / 100);
				value = value % 100;
			}

			if (value >= 50) {
				money.setFifty(value / 50);
				value = value % 50;
			}

			if (value >= 20) {
				money.setTwenty(value / 20);
				value = value % 20;
			}

			if (value >= 10) {
				money.setTen(value / 10);
				value = value % 10;
			}
			
			if (value > 0) {
				money.setRemnant(value);
				money.setError("We haven't notes of " + value + ", the remnant returned to your account");
			}
		}

		return money;
	}
}
