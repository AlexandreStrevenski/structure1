package com.bank.service;

import com.bank.entity.Account;
import com.bank.repository.AccountDAO;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.List;

public class AccountService {


    public static void main(String[] args) {
        new AccountService().registerAccount();
    }

    public void registerAccount(){
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());

        // Jdbi implements your interface based on annotations
        List<Account> userNames = jdbi.withExtension(AccountDAO.class, dao -> {
            dao.createTable();

            dao.insert(new Account(1L, 222L));
            dao.insert(new Account(2L, 102030L));

            return dao.listAccounts();
        });

        userNames.forEach(account -> System.out.println(account.getNumber()));
    }

}
