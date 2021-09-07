package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.UDate;

import java.util.List;

public interface FmService {


    List<Reimbursement> getAId(Integer FMId);
    List<Reimbursement>getARe();
    void updateReimId(UDate uDate);


}
