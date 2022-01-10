
package gym.system;

import java.sql.*;
import java.util.logging.*;


public class dbConn {
    
    static String dbname = "dbname";
    static String dbpass = "dbpass";
    public static Connection DBConnection() {
        
         Connection conn = null;


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
             //cmd :SQLPLUS / AS SYSDBA
             // ALTER USER HR ACCOUNT UNLOCK;
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE",dbname,dbpass);
            System.out.println("success connection");

        } catch (Exception ex) {
            System.out.println(ex.toString());
            System.out.println("Connection Error");
        }
     
        return conn;
    }
}
