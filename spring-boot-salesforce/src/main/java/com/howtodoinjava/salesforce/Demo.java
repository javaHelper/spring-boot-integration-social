package com.howtodoinjava.salesforce;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.howtodoinjava.salesforce.model.AuthenticationResponse;

public class Demo {
	public static void main(String[] args) {
		HttpHeaders h = new HttpHeaders();
		h.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
		 
		params.add("username", "prateek1@abc.com");
		params.add("password", "Agilenova@123");
		params.add("client_secret", "AE02C59CF9A4FCDE3644AD532800C5757423CE59B97E617FC9920166E286D6A8");
		params.add("client_id", "3MVG9n_HvETGhr3DN5wDlAycmd1VbNrWgNpxWoF5mTDg0bnSQ5lM9Em3UXqXhlGcLyQVyaMWb1XXYEJHmYIn2");
		params.add("grant_type","password");
		 
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, h);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthenticationResponse> response = restTemplate.postForEntity("https://login.salesforce.com/services/oauth2/token", request, AuthenticationResponse.class);
		System.out.println(response.getBody());
		
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.setContentType(MediaType.APPLICATION_JSON);
		headers1.set("Authorization", "Bearer " + response.getBody().getAccess_token());
		MultiValueMap<String, String> params1= new LinkedMultiValueMap<String, String>();
		
		HttpEntity<MultiValueMap<String, String>> request1 = new HttpEntity<MultiValueMap<String, String>>(params1, headers1);
		RestTemplate restTemplate1 = new RestTemplate();
		ResponseEntity<String> caseResponse = restTemplate1.exchange("https://ap16.salesforce.com/services/data/v46.0/query?q=SELECT AssetId,CaseNumber,ContactPhone,IsEscalated,Origin,Reason,Status,Type FROM Case", 
				HttpMethod.GET, request1, String.class);
		System.out.println(caseResponse);
	}
}
