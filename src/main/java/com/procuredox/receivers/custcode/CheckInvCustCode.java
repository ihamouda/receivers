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

public class CheckInvCustCode {
    private static final Logger log = LoggerFactory.getLogger(CheckCustCode.class);
    private AppResources rb = AppResources.getInstance();
    final Utils utils = Utils.getInstance();
    final MyDataSourceFactory factory= MyDataSourceFactory.getInstance();
    private final DataSource mysqlDS = factory.getMySQLDataSource();
    private PreparedStatement sqlStmt;
    private java.sql.Connection sqlConn;
    private ResultSet sqlRs;

    public Response checkCustCode(String secKey, String custCode){
        try{
            String sqlQuery = "select check_inv_custcode_exists(?,?)";
            sqlConn = mysqlDS.getConnection();
            sqlStmt = sqlConn.prepareStatement(sqlQuery);
            sqlStmt.setString(1, secKey);
            sqlStmt.setString(2, custCode);
            sqlRs = sqlStmt.executeQuery();
            while (sqlRs.next()){
                if (sqlRs.getInt(1) == 0){
                    sqlRs.close();
                    sqlStmt.close();
                    sqlConn.close();
                    return Response.status(Response.Status.OK).entity(new CheckCustCodeResponse(false)).build();
                }else{
                    sqlRs.close();
                    sqlStmt.close();
                    sqlConn.close();
                    return Response.status(Response.Status.OK).entity(new CheckCustCodeResponse(true)).build();
                }
            }
            return Response.status(Response.Status.OK).entity(new CheckCustCodeResponse(false)).build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }
    }
}
