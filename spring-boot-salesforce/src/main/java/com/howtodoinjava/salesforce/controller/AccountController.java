package com.howtodoinjava.salesforce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.salesforce.model.Account;
import com.howtodoinjava.salesforce.service.AccountService;

@RestController
public class AccountController {

	@Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> accounts(OAuth2Authentication principal) {
        return accountService.accounts(principal);
    }
}
