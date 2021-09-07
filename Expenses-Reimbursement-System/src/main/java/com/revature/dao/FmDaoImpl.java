package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.UDate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FmDaoImpl implements FmDao{
    private static FmDao fmDao;

    private FmDaoImpl(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //singleton to only have one instance
    public static FmDao getInstance(){
        if(fmDao==null){
            fmDao = new FmDaoImpl();
        }
        return fmDao;
    }

    /**
     * The getAllReId method executes a SQL  query where it retrieves all reimbursement data that contains the same id (FMId)
     * that the user entered.
     * @param FMId
     * @return reimList (arrayList that contains all the reimbursement that has the same id pass to the method)
     */
    @Override
    public List<Reimbursement> getAllReId(Integer FMId) {
        List<Reimbursement> reimList = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(ConnectionInfo.url,ConnectionInfo.username,ConnectionInfo.password)){
            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_resolver = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, FMId);
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
     * The getAllRe retrieves all the reimbursements in the ers_reimbursement table and stores them
     * in the arraylist: reimList.
     * @return reimList (contains all the reimbursement in the table)
     */
    @Override
    public List<Reimbursement> getAllRe() {
        List<Reimbursement> reimList = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(ConnectionInfo.url,ConnectionInfo.username,ConnectionInfo.password)){
            String sql = "SELECT * FROM ers_reimbursement;";
            PreparedStatement ps = conn.prepareStatement(sql);
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
     * The updateRein updates a current element in the database, specifically the ers_reimbursement table
     * @param uDate
     */
    @Override
    public void updateReim(UDate uDate) {

        try(Connection conn = DriverManager.getConnection(ConnectionInfo.url,ConnectionInfo.username,ConnectionInfo.password)){
            String sql = "UPDATE ers_reimbursement SET reimb_resolved= ?, reimb_resolver =?, reimb_type_status_id = ? WHERE reimb_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            //we need this line to fill the ? input

            ps.setTimestamp(1, uDate.getResolved());
            ps.setInt(2,uDate.getResolver());
            ps.setInt(3,uDate.getStatus());
            ps.setInt(4,uDate.getIdReim());


            ps.executeUpdate();


        }catch(SQLException e) {
            e.printStackTrace();
        }


    }
}
