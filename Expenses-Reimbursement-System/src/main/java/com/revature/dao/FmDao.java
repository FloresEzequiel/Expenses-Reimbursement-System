package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.UDate;

import java.util.List;

public interface FmDao {

    List<Reimbursement> getAllReId(Integer FMId);
    List<Reimbursement>getAllRe();
    void updateReim(UDate uDate);



}
