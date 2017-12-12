package com.gsw.cash.money.dto;

public class MoneyDto {
	
	private int hundred;
	
	private int fifty;
	
	private int twenty;
	
	private int ten;
	
	private int remnant;
	
	private String error;

	public int getHundred() {
		return hundred;
	}

	public void setHundred(int hundred) {
		this.hundred = hundred;
	}

	public int getFifty() {
		return fifty;
	}

	public void setFifty(int fifty) {
		this.fifty = fifty;
	}

	public int getTwenty() {
		return twenty;
	}

	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}

	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}

	public int getRemnant() {
		return remnant;
	}

	public void setRemnant(int remnant) {
		this.remnant = remnant;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
