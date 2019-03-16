package data;
import java.lang.*;
import java.sql.SQLException;
import java.sql.*;
public class LoginDatabase {
    //JDBC driver name and dtabase URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/assignment2web";

    //database credentials
    static final String USER ="webAppUser";
    static final String PASS="Eddiez78_Curse";
    public boolean validUserLogin(String userName, String passward) {
        boolean isValidUser = false;
        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            //regester JDBC
            Class.forName("com.mysql.jdbc.Driver");

            //open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            sql = "SELECT * FROM users WHERE Username= \"" +
                    userName + "\" AND Pword = \"" + passward + "\"";

            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                isValidUser = true;
            }

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

    return isValidUser;

    }

}
