package com.revature.services;

import com.revature.dao.FmDao;
import com.revature.dao.FmDaoImpl;
import com.revature.models.Reimbursement;
import com.revature.models.UDate;

import java.sql.Timestamp;
import java.util.List;

public class FmServiceImpl implements FmService{
    FmDao fmDao;

    public FmServiceImpl(){
        fmDao = FmDaoImpl.getInstance();
    }

    @Override
    public List<Reimbursement> getAId(Integer FMId) {

        return fmDao.getAllReId(FMId);
    }

    @Override
    public List<Reimbursement> getARe() {
        return fmDao.getAllRe();
    }

    @Override
    public void updateReimId(UDate uDate) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        uDate.setResolved(timestamp);

        fmDao.updateReim(uDate);

        System.out.println(uDate);
    }
}
