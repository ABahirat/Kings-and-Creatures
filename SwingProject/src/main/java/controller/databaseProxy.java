package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/******* Source for code: http://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database ******/

/**Usage:
     String sql = "SELECT * FROM `stackoverflow`";
     try {
         PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
         ... go on ...
         ... go on ...
         ... DONE ....
     } catch (SQLException e) {
         e.printStackTrace();
     } finally {
         mysqlConnect.disconnect();
     }

 **/

/**
 * Created by Ameya on 4/26/17.
 */
public class databaseProxy {

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/KAC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250";

    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;


    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;

    }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
