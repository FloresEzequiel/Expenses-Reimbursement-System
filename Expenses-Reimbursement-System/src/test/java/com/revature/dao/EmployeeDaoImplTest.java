package com.revature.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

import com.revature.models.Reimbursement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;


public class EmployeeDaoImplTest  {

    @Mock
    public EmployeeDao employeeDao;

    @BeforeEach
    void setup(){MockitoAnnotations.initMocks(this);}


    @Test
    public void testGetAllReimbursements() {
        Integer id=3;
        Double amount=32.21;
        Timestamp submitted=null;
        Timestamp resolved=null;
        String description="travel fees";
        String receipt="test.png";
        Integer author=1;
        Integer resolver=2;
        Integer status=3;
        Integer type=2;
        Reimbursement re1 = new Reimbursement(id,amount,submitted,resolved,description,
                receipt,author,resolver,status,type);
        Reimbursement re2 = new Reimbursement(6,987.87,null,null,"hotel fees",
                "test.png",1,2,2,1);
        Reimbursement re3 = new Reimbursement(8,87.87,null,null,"gas fees",
                "test.png",3,2,1,2);
        List<Reimbursement> expect = new ArrayList<>();
        expect.add(re1);
        expect.add(re2);
        expect.add(re3);
        Mockito.when(employeeDao.getAllReimbursements(3)).thenReturn(expect);

        List<Reimbursement> act = employeeDao.getAllReimbursements(3);
        assertEquals(expect,act);

    }

    @Test
    public void testCreateReimbursement() {
        Integer id=1;
        Double amount=203.21;
        Timestamp submitted=null;
        Timestamp resolved=null;
        String description="motel fee";
        String receipt="test.png";
        Integer author=1;
        Integer resolver=1;
        Integer status=3;
        Integer type=2;

        Reimbursement reimbursement1 = new Reimbursement(id,amount,submitted,resolved,description,receipt,author,resolver,status,type);
        employeeDao.createReimbursement(reimbursement1);

        Mockito.verify(employeeDao,Mockito.times(1)).createReimbursement(reimbursement1);

    }
}