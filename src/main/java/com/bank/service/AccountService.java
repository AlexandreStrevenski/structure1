package com.bank.service;

import com.bank.entity.Account;
import com.bank.repository.AccountDAO;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class AccountService {


    public List<Account> listAll() {
        MysqlDataSource dataSource = new MysqlDataSource();

        // Set dataSource Properties
        dataSource.setServerName("heroku_d7f2b7276b5c14e");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("nsei");
        dataSource.setUser("b1672d0035f823");
        dataSource.setPassword("e87fb1fe");

        DataSource ds = dataSource;
        Jdbi jdbi = Jdbi.create(ds);

        jdbi.installPlugin(new SqlObjectPlugin());

        List<Account> accounts = jdbi.withExtension(AccountDAO.class, dao -> {
            dao.createTable();
            dao.insert(new Account(1L, 222L));
            dao.insert(new Account(2L, 102030L));

            return dao.listAccounts();
        });

        return accounts;
    }
}
