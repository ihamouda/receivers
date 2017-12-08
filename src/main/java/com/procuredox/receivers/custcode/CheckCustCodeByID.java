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

public class CheckCustCodeByID {
    private static final Logger log = LoggerFactory.getLogger(CheckCustCodeByID.class);
    private AppResources rb = AppResources.getInstance();
    final Utils utils = Utils.getInstance();
    final MyDataSourceFactory factory= MyDataSourceFactory.getInstance();
    private final DataSource mysqlDS = factory.getMySQLDataSource();
    private PreparedStatement sqlStmt;
    private java.sql.Connection sqlConn;
    private ResultSet sqlRs;

    public Response checkCustCodeByID(String vendorId, String custCode){
        try{
            String sqlQuery = "select check_cust_code_byid_exists(?,?)";
            sqlConn = mysqlDS.getConnection();
            sqlStmt = sqlConn.prepareStatement(sqlQuery);
            sqlStmt.setString(1, vendorId);
            sqlStmt.setString(2, custCode);
            sqlRs = sqlStmt.executeQuery();
            if (!sqlRs.isBeforeFirst()){
                return Response.status(Response.Status.OK).entity(new CheckCustCodeByIDResponse(false)).build();
            }else {
                while (sqlRs.next()){
                    if (sqlRs.getString(1) == null || sqlRs.getString(1).isEmpty()){
                        return Response.status(Response.Status.OK).entity(new CheckCustCodeByIDResponse(false)).build();
                    }
                }
                return Response.status(Response.Status.OK).entity(new CheckCustCodeByIDResponse(true)).build();
            }
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }
    }
}
