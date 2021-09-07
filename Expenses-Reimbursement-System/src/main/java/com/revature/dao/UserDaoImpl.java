package com.revature.dao;

import com.revature.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private static UserDao userDao;

    //postgresql driver
    private UserDaoImpl(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //singleton to only have one instance
    public static UserDao getInstance(){
        if(userDao == null){
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    /**
     * The insertUser adds a new user to the ers_users table
     * @param user
     */
    @Override
    public void insertUser(User user) {
        try(Connection conn = DriverManager.getConnection(ConnectionInfo.url,ConnectionInfo.username,ConnectionInfo.password)){
            String sql = "INSERT INTO ers_users VALUES (DEFAULT, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            //we need this line to fill the ? input
            ps.setString(1, user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFirstName());
            ps.setString(4,user.getLastName());
            ps.setString(5,user.getEmail());
            ps.setInt(6,user.getRol());
            ps.executeUpdate();


        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The findUser executes a query to look for a especific user with his username in the ers_user table
     * and returns the elements of that user from the database.
     * @param username
     * @return the user that it was looking for (user)
     */

    @Override
    public User findUser(String username) {
        User user = null;

        try(Connection conn = DriverManager.getConnection(ConnectionInfo.url,ConnectionInfo.username,ConnectionInfo.password)){
            String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            //this is iterating through the records
            while(rs.next()) {
                user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7));
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * The getAllUser returns a list of all the user inside of the ers_user table
     * @return getList (all of the users inside of the tables)
     */
    @Override
    public List<User> getAllUser() {
        List<User> getList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(ConnectionInfo.url,ConnectionInfo.username,ConnectionInfo.password)) {
            String sql = "SELECT * FROM ers_users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                getList.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7)));
            }




        }catch(SQLException e) {
            e.printStackTrace();
        }


        return getList;
    }


}
