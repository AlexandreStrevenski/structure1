package com.bank.repository;

import com.bank.entity.Account;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface AccountDAO {

    @SqlUpdate("CREATE TABLE account (id INTEGER PRIMARY KEY, number INTEGER)")
    void createTable();

    @SqlUpdate("INSERT INTO account(id, number) VALUES (:id, :number)")
    void insert(@BindBean Account account);

    @SqlQuery("SELECT * FROM account ORDER BY id")
    @RegisterBeanMapper(Account.class)
    List<Account> listAccounts();
}
