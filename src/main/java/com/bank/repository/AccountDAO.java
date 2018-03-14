package com.bank.repository;

import com.bank.entity.Account;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {

    @SqlUpdate("CREATE TABLE account (id INTEGER PRIMARY KEY, number INTEGER)")
    void createTable();

    @SqlUpdate("INSERT INTO account(id, number) VALUES (:id, :number)")
    void insert(@BindBean Account account);

    @SqlQuery("SELECT * FROM account ORDER BY id")
    @RegisterBeanMapper(Account.class)
    List<Account> listAccounts();

    @SqlQuery("SELECT * FROM account where id = :id")
    @RegisterBeanMapper(Account.class)
    Optional<Account> findById(@Bind("id") Long id);

    @SqlUpdate("DELETE FROM account where id = :id")
    void delete(@Bind("id") Long id);


    /*T save(T entity);

    Optional<T> findById(ID id);

    Boolean exists(ID id);

    List<T> findAll();

    Long count();

    void delete(ID id);*/
}
