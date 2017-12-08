package com.procuredox.receivers.custcode;

import com.procuredox.receivers.AppResources;
import com.procuredox.receivers.MyDataSourceFactory;
import com.procuredox.receivers.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import javax.ws.rs.core.Response;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetCustCodeByID {
    private static final Logger log = LoggerFactory.getLogger(SetCustCodeByID.class);
    private AppResources rb = AppResources.getInstance();
    final Utils utils = Utils.getInstance();
    final MyDataSourceFactory factory= MyDataSourceFactory.getInstance();
    private final DataSource mysqlDS = factory.getMySQLDataSource();
    private PreparedStatement sqlStmt;
    private java.sql.Connection sqlConn;
    private ResultSet sqlRs;

    public Response setCustCodeByID(SetCustCodeByIDRequest custcode){
        try{
            sqlConn = mysqlDS.getConnection();
            if(custcode.getCustCodeId() == null){
                String sqlQuery = "select check_cust_code_byid_exists(?,?)";
                sqlStmt = sqlConn.prepareStatement(sqlQuery);
                sqlStmt.setString(1, custcode.getvendorId());
                sqlStmt.setString(2, custcode.getCustCode());
                sqlRs = sqlStmt.executeQuery();
                while (sqlRs.next()){
                    if (sqlRs.getString(1) != null){
                        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, "Code for this vendor already exists")).build();
                    }
                }
                sqlQuery = "call insert_cust_code_byid(?,?,?)";
                sqlStmt = sqlConn.prepareStatement(sqlQuery);
                sqlStmt.setString(1, custcode.getvendorId());
                sqlStmt.setString(2, custcode.getCustCode());
                sqlStmt.setString(3, custcode.getBuyerId());
                sqlStmt.execute();
            } else {
                String sqlQuery = "update custcode set buyer_id = ? where custcode_id = ?";
                sqlStmt = sqlConn.prepareStatement(sqlQuery);
                sqlStmt.setString(1, custcode.getBuyerId());
                sqlStmt.setString(2, custcode.getCustCodeId());
                sqlStmt.execute();
            }
            return Response.status(Response.Status.OK).entity(new Success(true, "")).build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }
    }
}
