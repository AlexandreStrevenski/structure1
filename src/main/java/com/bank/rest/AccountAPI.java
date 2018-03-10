package com.bank.rest;

import com.bank.entity.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountAPI {

    @Autowired
    private AccountService accountService;

    @GetMapping("/listAll")
    public ResponseEntity<List<Account>> listAll(){
        return new ResponseEntity<>(accountService.listAll(), HttpStatus.OK);
    }

}
