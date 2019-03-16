package data;
import java.lang.*;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

import classes.user;
public class addUser {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/assignment2web";

    //database credentials
    static final String USER ="webAppUser";
    static final String PASS="Eddiez78_Curse";

    public void addAUser(user AUser){
        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            //regester JDBC
            Class.forName("com.mysql.jdbc.Driver");

            //open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String userName = AUser.getUsername();
            String email = AUser.getMail();
            String passward =AUser.getPassword();
            String role =AUser.getRole();


            stmt = conn.createStatement();
            sql = "INSERT into user VALUES ( " + passward +"," + userName + "," + role + "," + email +");";

            ResultSet rs = stmt.executeQuery(sql);

            //close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end of final try
        }//end of try

    }


}
