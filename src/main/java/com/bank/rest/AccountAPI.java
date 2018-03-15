package com.bank.rest;

import com.bank.entity.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountAPI {

    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("accountList");
        mv.addObject("accounts", accountService.listAll());
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(Account account){
        ModelAndView mv = new ModelAndView("account");
        mv.addObject("account", account);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("account");
        mv.addObject("account", accountService.findById(id));
        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        accountService.delete(id);

        return listAll();
    }

    @PostMapping("/save")
    public ModelAndView save(Account account){
        accountService.save(account);
        return listAll();
    }

}
