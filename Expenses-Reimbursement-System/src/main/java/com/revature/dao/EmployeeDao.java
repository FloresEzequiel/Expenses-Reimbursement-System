package com.revature.dao;

import com.revature.models.Reimbursement;

import java.util.List;

public interface EmployeeDao {
    List<Reimbursement> getAllReimbursements(Integer EmployId);
    void createReimbursement(Reimbursement reimbursement);

}
