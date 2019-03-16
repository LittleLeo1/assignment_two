package data;
import java.lang.*;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.post;
public class postStuff {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/assignment2web";

    //database credentials
    static final String USER ="webAppUser";
    static final String PASS="Eddiez78_Curse";
    public String addAPost(post APost){
        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        String postAdded ="";

        try {
            //regester JDBC
            Class.forName("com.mysql.jdbc.Driver");

            //open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String title = APost.getTitle();
            String body = APost.getBody();
            String setting = APost.getSetting();
            String date = APost.getDate();
            String user = APost.getUser();

            stmt = conn.createStatement();
            sql = "INSERT into posts VALUES ( " + title+"," + body + "," + setting + "," + date + ","+ user+");";
            if (APost.goodPost()) {
                ResultSet rs = stmt.executeQuery(sql);
                rs.close();
                postAdded = "Post added";
            }
            else
            {
                postAdded = "Failed to add";
            }

            //close the connection

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
    return postAdded;
    }
    public ArrayList getPosts ()
    {
        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        List<post> posts = new ArrayList<>();

        try {
            //regester JDBC
            Class.forName("com.mysql.jdbc.Driver");

            //open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            sql = "Select * FROM posts FETCH FIRST 10 ROWS ONLY;";

            ResultSet rs = stmt.executeQuery(sql);
            //make the list



            while (rs.next())
            {
                post post = new post();
                post.setTitle(rs.getString(1));
                post.setBody(rs.getString(2));
                post.setSetting(rs.getString(3));
                post.setDate(rs.getString(4));
                post.setUser(rs.getString(5));

                posts.add(post);
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
        return (ArrayList) posts;

    }

}
