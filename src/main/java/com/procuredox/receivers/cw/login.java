package com.procuredox.receivers.cw;

import com.procuredox.receivers.AppResources;
import com.procuredox.receivers.MyDataSourceFactory;
import com.sun.org.apache.bcel.internal.generic.RET;

import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by ihamouda on 2017-06-26.
 */
public class login {
    private static AppResources rb = AppResources.getInstance();
    private static MyDataSourceFactory factory = MyDataSourceFactory.getInstance();
    private final int HTTP_200 = 200;
    private final DataSource mysqlDS = factory.getMySQLDataSource();
    private PreparedStatement sqlStmt;
    private Connection sqlConn;
    private ResultSet sqlRs;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Context HttpHeaders headers, UserCredentials credentials){
        try{
            MultivaluedMap<String, String> rh = headers.getRequestHeaders();
            String auth = rh.entrySet()
                    .stream()
                    .filter(e -> e.getKey().equals(rb.getRb().getString("cw_auth_header")))
                    .collect(Collectors.toList()).get(0).toString();
            if(auth == null){
                return Response.status(Response.Status.UNAUTHORIZED).entity("<p>No API Key<p>").build();
            }
            String authVal = rh.entrySet()
                    .stream()
                    .filter(e -> e.getValue().equals(rb.getRb().getString("cw_auth_value")))
                    .collect(Collectors.toList()).get(0).toString();
            if(authVal == null){
                return Response.status(Response.Status.UNAUTHORIZED).entity("<p>API Key incorrect</p>").build();
            }
            sqlConn = mysqlDS.getConnection();
            sqlStmt = sqlConn.prepareStatement("select cwlogin(?,?)");
            sqlStmt.setInt(1,credentials.getCwid());
            sqlStmt.setInt(2,credentials.getUid());
            sqlRs = sqlStmt.executeQuery();
            while (sqlRs.next()){
                if(sqlRs.getString(1).equals("NO")){

                }else{

                }
            }
        }catch (SQLException e){

        }catch (Exception e){

        }
        return Response.status(Response.Status.OK).build();
    }
}
