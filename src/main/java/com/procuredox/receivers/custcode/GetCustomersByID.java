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
import java.util.ArrayList;

public class GetCustomersByID {
    private static final Logger log = LoggerFactory.getLogger(GetCustomersByID.class);
    private AppResources rb = AppResources.getInstance();
    final Utils utils = Utils.getInstance();
    final MyDataSourceFactory factory= MyDataSourceFactory.getInstance();
    private final DataSource mysqlDS = factory.getMySQLDataSource();
    private PreparedStatement sqlStmt;
    private java.sql.Connection sqlConn;
    private ResultSet sqlRs;

    public Response getCustomersByID(String vendorId){
        try {
            ArrayList<Customer> customers = new ArrayList<>();
            String sqlQuery = "call partners_by_vendorId(?)";
            sqlConn = mysqlDS.getConnection();
            sqlStmt = sqlConn.prepareStatement(sqlQuery);
            sqlStmt.setString(1, vendorId);
            sqlRs = sqlStmt.executeQuery();
            while(sqlRs.next()){
                customers.add(new Customer(sqlRs.getString(1), sqlRs.getString(2)));
            }
            return Response.status(Response.Status.OK).entity(customers).build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }
    }
}
