package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.UDate;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

public class FmServiceImplTest {


    @Mock
    public FmService fmService;

    @BeforeEach
    void setup(){MockitoAnnotations.initMocks(this);}

    @Test
    public void testGetAId() {
        Integer id=5;
        Double amount=243.21;
        Timestamp submitted=null;
        Timestamp resolved=null;
        String description="gas from travel";
        String receipt="test2.png";
        Integer author=2;
        Integer resolver=2;
        Integer status=3;
        Integer type=2;
        Reimbursement reim1 = new Reimbursement(id,amount,submitted,resolved,description,receipt,author,
                resolver,status,type);

        Reimbursement reim2 = new Reimbursement(9,943.21,null,null,"travel fee","test.png",2,3,2);
        List<Reimbursement> expectedResult = new ArrayList<>();
        expectedResult.add(reim1);
        expectedResult.add(reim2);

        Mockito.when(fmService.getAId(5)).thenReturn(expectedResult);
        List<Reimbursement> actualResult = fmService.getAId(5);

        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void testGetARe() {
        Integer id=7;
        Double amount=832.21;
        Timestamp submitted=null;
        Timestamp resolved=null;
        String description="motel fee";
        String receipt="test2.png";
        Integer author=7;
        Integer resolver=3;
        Integer status=2;
        Integer type=1;
        Reimbursement reim1 = new Reimbursement(id,amount,submitted,resolved,description,receipt,author,
                resolver,status,type);

        Reimbursement reim2 = new Reimbursement(8,943.21,null,null,"restaurant fee","test.png",3,3,3);
        List<Reimbursement> expectedResult = new ArrayList<>();
        expectedResult.add(reim1);
        expectedResult.add(reim2);

        Mockito.when(fmService.getARe()).thenReturn(expectedResult);
        List<Reimbursement> actualResult = fmService.getARe();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testUpdateReimId() {
        Integer idReim = 3;
        Timestamp resolved = null;
        Integer resolver = 5;
        Integer status = 3;

        UDate uDate1 = new UDate(idReim,resolved,resolver,status);

        UDate uDate2 = new UDate(4,null,6,2);



        fmService.updateReimId(uDate1);
        Mockito.verify(fmService,Mockito.times(1)).updateReimId(uDate1);

        fmService.updateReimId(uDate2);
        Mockito.verify(fmService,Mockito.times(1)).updateReimId(uDate2);
    }
}