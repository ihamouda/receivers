package com.procuredox.receivers;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

/**
 * Created by ihamouda on 2017-06-24.
 */
public class MyDataSourceFactory {
    private static final String MYSQL_DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static AppResources rb = AppResources.getInstance();
    private static final String MYSQL_DB_URL = "jdbc:mysql://" + rb.getRb().getString("dbUrl") + "/"
            + rb.getRb().getString("dbName");
    private static final String MYSQL_DB_USERNAME = rb.getRb().getString("dbUser");
    private static final String MYSQL_DB_PASSWORD = rb.getRb().getString("dbPassword");

    private static MyDataSourceFactory instance = new MyDataSourceFactory();

    private MyDataSourceFactory() {

    }

    public static MyDataSourceFactory getInstance() {
        return instance;
    }

    public static DataSource getMySQLDataSource() {
        MysqlDataSource mysqlDS = null;
        mysqlDS = new MysqlDataSource();
        mysqlDS.setURL(MYSQL_DB_URL);
        mysqlDS.setUser(MYSQL_DB_USERNAME);
        mysqlDS.setPassword(MYSQL_DB_PASSWORD);
        return mysqlDS;
    }
}
