package com.revature.services;

import com.revature.dao.EmployeeDao;
import com.revature.models.Reimbursement;
//import junit.framework.TestCase;

import org.mockito.Mock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

//import static org.junit.jupiter.api.Assertions.assertEquals;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class EmployServiceImplTest{ //extends TestCase

    @Mock
    public EmployService employService;


    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }


//
    @Test
     void testGetAllReimbursements() {
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


        Reimbursement n1 = new Reimbursement(id,amount,submitted,resolved,description,
                receipt,author,resolver,status,type);
        Reimbursement n2 = new Reimbursement(6,987.87,null,null,"hotel fees",
                "test.png",1,2,2,1);
        List<Reimbursement> expect = new ArrayList<>();
        expect.add(n1);
        expect.add(n2);
//
        Mockito.when(employService.getAllReimbursements(2)).thenReturn(expect);

        List<Reimbursement> act = employService.getAllReimbursements(2);

        assertEquals(expect,act);



    }

    @Test
    public void testCreateReimbursementTicket() {
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


        Reimbursement reimbursement = new Reimbursement(id,amount,submitted,resolved,description,receipt,author,resolver,status,type);

        employService.createReimbursementTicket(reimbursement);

        Mockito.verify(employService, Mockito.times(1)).createReimbursementTicket(reimbursement);

    }
}