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
        dataSource.setServerName("us-cdbr-iron-east-05.cleardb.net");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("heroku_e1256ca7c2d986f");
        dataSource.setUser("b28e00a90fbfc1");
        dataSource.setPassword("4b310ced");

        DataSource ds = dataSource;
        Jdbi jdbi = Jdbi.create(ds);

        jdbi.installPlugin(new SqlObjectPlugin());

        List<Account> accounts = jdbi.withExtension(AccountDAO.class, dao -> dao.listAccounts());

        return accounts;
    }
}
