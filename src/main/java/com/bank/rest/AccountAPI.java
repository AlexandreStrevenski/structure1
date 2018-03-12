package com.bank.rest;

import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountAPI {

    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("/account");
        mv.addObject("accounts", accountService.listAll());

        return mv;
    }
}
