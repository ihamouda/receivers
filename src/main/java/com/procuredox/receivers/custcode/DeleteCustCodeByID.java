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

public class DeleteCustCodeByID {
    private static final Logger log = LoggerFactory.getLogger(DeleteCustCodeByID.class);
    private AppResources rb = AppResources.getInstance();
    final Utils utils = Utils.getInstance();
    final MyDataSourceFactory factory= MyDataSourceFactory.getInstance();
    private final DataSource mysqlDS = factory.getMySQLDataSource();
    private PreparedStatement sqlStmt;
    private java.sql.Connection sqlConn;
    private ResultSet sqlRs;

    public Response deleteCustCodeByID(DeleteCustCodeByIDRequest custCode){
        try{
            sqlConn = mysqlDS.getConnection();
            sqlStmt = sqlConn.prepareStatement("call delete_cust_code_byid(?,?)");
            sqlStmt.setString(1, custCode.getvendorId());
            sqlStmt.setString(2, custCode.getCustCodeId());
            sqlStmt.execute();
            return Response.status(Response.Status.OK).entity(new Success(true, "")).build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }
    }
}
