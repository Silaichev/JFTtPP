package com.JFTtPP.myJDBC;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Pool {
    private static final ComboPooledDataSource cpds = new ComboPooledDataSource();

    static {
        try {
            cpds.setDriverClass("com.mysql.jdbc.Driver"             );
            cpds.setJdbcUrl    ("jdbc:mysql://localhost:3306/jfttpp");
            cpds.setUser       ("root");
            cpds.setPassword   ("root112358");

            Properties properties = new Properties();
            properties.setProperty ("user"             , "root"   );
            properties.setProperty ("password"         , "root112358");
            properties.setProperty ("useUnicode"       , "true"      );
            properties.setProperty ("characterEncoding", "UTF8"      );
            cpds.setProperties(properties);

            // set options
            cpds.setMaxStatements             (180);
            cpds.setMaxStatementsPerConnection(180);
            cpds.setMinPoolSize               ( 50);
            cpds.setAcquireIncrement          ( 10);
            cpds.setMaxPoolSize               ( 60);
            cpds.setMaxIdleTime               ( 30);


        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

}
