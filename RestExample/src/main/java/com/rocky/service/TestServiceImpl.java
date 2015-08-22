package com.rocky.service;

import java.util.HashMap;
import java.util.Map;

import com.rocky.vo.Account;

public class TestServiceImpl implements TestService {

	Map<String, Account> accounts = new HashMap<String, Account>();

	public void init() {

		Account newAccount1 = new Account();
		newAccount1.setId(1);
		newAccount1.setName("Alvin Reyes");

		Account newAccount2 = new Account();
		newAccount2.setId(2);
		newAccount2.setName("Rachelle Ann de Guzman Reyes");

		accounts.put("1", newAccount1);
		accounts.put("2", newAccount2);

	}

	public TestServiceImpl() {
		
		System.out.println("----Constructor----");
		init();
	}
	
	public Account getAccount(String id) {
		Account c = accounts.get(id);
		return c;
	}
}
