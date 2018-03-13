package com.bank.service;

import com.bank.entity.Account;
import com.bank.repository.AccountDAO;
import com.bank.repository.JDBI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {


    public List<Account> listAll() {

        List<Account> accounts = JDBI.instance().withExtension(AccountDAO.class, dao -> dao.listAccounts());

        return accounts;
    }
}
