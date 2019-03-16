package data;
import classes.post;
import classes.user;

import java.lang.*;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class adminData {
    //JDBC driver name and dtabase URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/assignment2web";

    //database credentials
    static final String USER ="webAppUser";
    static final String PASS="Eddiez78_Curse";
    public void createUser(String username, String email, String password)
    {
        user newUser = new user();
        newUser.setUsername(username);
        newUser.seteMail(email);
        newUser.setPassword(password);
    }
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

    public ArrayList ListUsers(){


        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        List<user> users = new ArrayList<>();

        try {
            //regester JDBC
            Class.forName("com.mysql.jdbc.Driver");

            //open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            sql = "Select * FROM user;";

            ResultSet rs = stmt.executeQuery(sql);
            //make the list



            while (rs.next())
            {
                user AUser = new user();
                AUser.setPassword(rs.getString(1));
                AUser.setUsername(rs.getString(2));
                AUser.setRole2(rs.getString(3));
                AUser.seteMail(rs.getString(4));

                users.add(AUser);
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

    return (ArrayList) users;
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
    public user searchUser(String username)
    {
        user yourUser = new user();

    }
    public void updateUser(String curUname, String NewUName, String NewPasswaard,String NewEmail)
    {
        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        try {
            //regester JDBC
            Class.forName("com.mysql.jdbc.Driver");

            //open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            sql = "Select * FROM user;";

            ResultSet rs = stmt.executeQuery(sql);
            //Update the user
            sql = "";
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
    public void deleateUser(String username){

    }
    public ArrayList serachPosts(String pTitle)
    {
        List<post> posts = new ArrayList<>();
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
            sql = "Select * FROM posts WHERE Title = "+ pTitle+";";

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
