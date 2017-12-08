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

public class GetCustCodesByID {
    private static final Logger log = LoggerFactory.getLogger(GetCustCodesByID.class);
    private AppResources rb = AppResources.getInstance();
    final Utils utils = Utils.getInstance();
    final MyDataSourceFactory factory= MyDataSourceFactory.getInstance();
    private final DataSource mysqlDS = factory.getMySQLDataSource();
    private PreparedStatement sqlStmt;
    private java.sql.Connection sqlConn;
    private ResultSet sqlRs;

    public Response getCustCodes(String vendorId, String search){
        try{
            ArrayList<CustCode> codes = new ArrayList<>();
            String sqlQuery = "call custcode_search_byid(?,?)";
            sqlConn = mysqlDS.getConnection();
            sqlStmt = sqlConn.prepareStatement(sqlQuery);
            sqlStmt.setString(1, vendorId);
            sqlStmt.setString(2, search);
            sqlRs = sqlStmt.executeQuery();
            while (sqlRs.next()){
                codes.add(new CustCode(sqlRs.getString(1), sqlRs.getString(2), sqlRs.getString(3)));
            }
            return Response.status(Response.Status.OK).entity(codes).build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Success(false, e.getMessage())).build();
        }
    }
}
