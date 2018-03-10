package com.bank.service;

import com.bank.entity.Account;
import com.bank.repository.AccountDAO;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");


    public void save(Account account){
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");

        jdbi.useExtension(AccountDAO.class, dao -> dao.insert(account));

    }

    public void registerAccount(){
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());


        // Jdbi implements your interface based on annotations
        List<Account> accounts = jdbi.withExtension(AccountDAO.class, dao -> {
            dao.createTable();

            dao.insert(new Account(1L, 222L));
            dao.insert(new Account(2L, 102030L));

            return dao.listAccounts();
        });

        accounts.forEach(account -> System.out.println(account.getNumber()));

    }

    public List<Account> listAll() {
        List<Account> accounts = jdbi.withExtension(AccountDAO.class, dao -> dao.listAccounts());
        return accounts;
    }
}
