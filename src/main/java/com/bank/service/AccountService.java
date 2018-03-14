package com.bank.service;

import com.bank.entity.Account;
import com.bank.repository.AccountDAO;
import com.bank.repository.JDBI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {


    public List<Account> listAll() {
        return JDBI.instance().withExtension(AccountDAO.class, dao -> dao.listAccounts());
    }

    public Optional<Account> findById(Long id) {
        return JDBI.instance().withExtension(AccountDAO.class, dao -> dao.findById(id));
    }

    public void delete(Long id) {
        JDBI.instance().useExtension(AccountDAO.class, dao -> dao.delete(id));
    }
}
