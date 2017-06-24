package com.procuredox.receivers;

import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ihamouda on 2017-06-24.
 */
public class Utils {
    final static Logger logger = Logger.getLogger(Utils.class);
    final AppResources rb = AppResources.getInstance();
    final MyDataSourceFactory factory= MyDataSourceFactory.getInstance();
    private final DataSource mysqlDS = factory.getMySQLDataSource();
    private PreparedStatement sqlStmt;
    private java.sql.Connection sqlConn;
    private ResultSet sqlRs;
    private static Utils instance = new Utils();
    private Utils(){

    }
    public static Utils getInstance(){
        return instance;
    }

    public Integer  getBatchNumber() throws Exception{
            Integer batchNumber = null;
            sqlConn = mysqlDS.getConnection();
            sqlStmt = sqlConn.prepareStatement("SELECT batchnumber() as batch_number");
            sqlRs = sqlStmt.executeQuery();
            while (sqlRs.next()){
                batchNumber = sqlRs.getInt("batch_number");
            }
            sqlRs.close();
            sqlStmt.close();
            sqlConn.close();
            return batchNumber;
    }
}
