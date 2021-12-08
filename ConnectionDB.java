package com.ike.service.affiliateSise.utils;


import com.ike.service.affiliateSise.utils.constants.Constants;
import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class ConnectionDB {


    public ConnectionDB() {
        this.connect();
    }

    private Constants constants;
    private Connection con;

    public Connection connect(){

        String connectionUrl = "jdbc:sqlserver://"+Constants.JDBCURL+";databaseName="+Constants.DB+";useUnicode=true;characterEncoding=UTF-8";
        try  {
            con = DriverManager.getConnection(connectionUrl,Constants.USER,Constants.PASSWORD);
        } catch (Exception throwables) {
            log.info("Error de conexion");
            return con;
        }

        return con;
    }

    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            log.info("Error de conexion");
        }
    }
}
