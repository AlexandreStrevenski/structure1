package com.bank.repository;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.sql.DataSource;

public class JDBI {

    private static Jdbi jdbi = Jdbi.create(getDataSource());

    static {
        jdbi.installPlugin(new SqlObjectPlugin());
    }

    private JDBI(){ }

    public static Jdbi instance(){
        return jdbi;
    }

    public static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("us-cdbr-iron-east-05.cleardb.net");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("heroku_e1256ca7c2d986f");
        dataSource.setUser("b28e00a90fbfc1");
        dataSource.setPassword("4b310ced");

        return dataSource;
    }
}
