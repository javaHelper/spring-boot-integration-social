package com.howtodoinjava.salesforce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import com.howtodoinjava.salesforce.model.Account;
import com.howtodoinjava.salesforce.queryresult.QueryResultAccount;


@Service
public class AccountService {
	// Value can be checked https://workbench.developerforce.com/
	private static final String REST_VERSION = "46.0";
	
	@Autowired
	private OAuth2RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	private static String restUrl(OAuth2Authentication principal) {
		HashMap<String, Object> details = (HashMap<String, Object>) principal.getUserAuthentication().getDetails();
		HashMap<String, String> urls = (HashMap<String, String>) details.get("urls");
		return urls.get("rest").replace("{version}", REST_VERSION);
	}

	public List<Account> accounts(OAuth2Authentication principal) {
		String url = restUrl(principal) + "query/?q={q}";

		Map<String, String> params = new HashMap<>();
		params.put("q", "SELECT Id, Name, Type, Industry, Rating FROM Account");

		return restTemplate.getForObject(url, QueryResultAccount.class, params).records;
	}
}

