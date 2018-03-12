package com.bank.rest;

import com.bank.entity.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AccountAPI {

    @Autowired
    private AccountService accountService;

    @GetMapping("/listAll")
    public ResponseEntity<List<Account>> listAll(){
        return new ResponseEntity<>(accountService.listAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/account");
        mv.addObject("accounts", getAccounts());

        return mv;
    }

    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1L, 1020203L));
        accounts.add(new Account(2L,3323232L));
        accounts.add(new Account(3L,83838L));

        return accounts;
    }
}
