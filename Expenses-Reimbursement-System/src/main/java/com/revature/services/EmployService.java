package com.revature.services;

import com.revature.models.Reimbursement;

import java.util.List;

public interface EmployService {



    List<Reimbursement> getAllReimbursements(Integer EmployId);
    void createReimbursementTicket(Reimbursement reimbursement);

}
