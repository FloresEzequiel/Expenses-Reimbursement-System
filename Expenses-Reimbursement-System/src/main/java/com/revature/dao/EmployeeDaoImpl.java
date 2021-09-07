package com.revature.dao;

import com.revature.models.Reimbursement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    private static EmployeeDao employeeDao;

    private EmployeeDaoImpl(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static EmployeeDao getInstance(){
        if(employeeDao == null){
            employeeDao = new EmployeeDaoImpl();
        }
        return employeeDao;
    }


    /**
     * The getAllReimbursements method does a query to the ers_reimbursement table and retrieves
     * all the reimbursements of the user that has the same EmployId that we give it.
     * @param EmployId
     * @return arraylist with all the reimbursements data
     */
    @Override
    public List<Reimbursement> getAllReimbursements(Integer EmployId) {
       List<Reimbursement> reimList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(ConnectionInfo.url,ConnectionInfo.username,ConnectionInfo.password)){
            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, EmployId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reimList.add(
                        new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
                                rs.getTimestamp(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                                rs.getInt(8), rs.getInt(9),rs.getInt(10))
                );
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return  reimList;
    }

    /**
     * This method inserts a new reimbursement entry into the ers_reimbursement table with the data the user enters.
     * @param reimbursement
     */
    @Override
    public void createReimbursement(Reimbursement reimbursement) {
        try(Connection conn = DriverManager.getConnection(ConnectionInfo.url,ConnectionInfo.username,ConnectionInfo.password)){

            String sql = "INSERT INTO ers_reimbursement VALUES (DEFAULT, ?, DEFAULT, ?, ?, ?, ?, NULL, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            //we need this line to fill the ? input
            ps.setDouble(1, reimbursement.getAmount());
            ps.setTimestamp(2, reimbursement.getResolved());
            ps.setString(3,reimbursement.getDescription());
            ps.setString(4,reimbursement.getReceipt());
            ps.setInt(5,reimbursement.getAuthor());
//            ps.setInt(7,reimbursement.getResolver());
            ps.setInt(6,reimbursement.getStatus());
            ps.setInt(7,reimbursement.getType());
            ps.executeUpdate();


        }catch(SQLException e) {
            e.printStackTrace();
        }



    }
}
