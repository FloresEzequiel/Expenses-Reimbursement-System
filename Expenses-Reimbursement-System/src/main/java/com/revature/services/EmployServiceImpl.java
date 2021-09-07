package com.revature.services;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.models.Reimbursement;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployServiceImpl implements EmployService{

    EmployeeDao employeeDao;

    public EmployServiceImpl(){
        employeeDao = EmployeeDaoImpl.getInstance();
    }


    @Override
    public List<Reimbursement> getAllReimbursements(Integer EmployId) {

        return employeeDao.getAllReimbursements(EmployId);
    }

    @Override
    public void createReimbursementTicket(Reimbursement reimbursement) {

        employeeDao.createReimbursement(reimbursement);
    }


}
