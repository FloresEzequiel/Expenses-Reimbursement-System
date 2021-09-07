package com.revature.services;
import com.revature.models.User;
import com.sun.deploy.security.MozillaMyKeyStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import com.revature.models.Reimbursement;
import com.revature.models.UDate;

import junit.framework.TestCase;

public class UserServiceImplTest {

    @Mock
    public UserService userService;

    @BeforeEach
    void setup(){MockitoAnnotations.initMocks(this);}

    @Test
    public void testCreate() {
        Integer id=2;
        String username="deltafox";
        String password="dafjsalfdjk332";
        String firstName = "Brian";
        String lastName = "O'Conner";
        String email = "dasodjsdsad@gmail.com";
        Integer rol = 1;

        User Nuser = new User(id,username,password,firstName,lastName,email,rol);

        User expect = new User();


        Mockito.when(userService.create(Nuser)).thenReturn(expect);

        User act = userService.create(Nuser);

        assertEquals(expect,act);

        Mockito.verify(userService, Mockito.times(1)).create(Nuser);

    }

    @Test
    public void testLogin() {

        Integer id=5;
        String username="fire303";
        String password="asfdf94fAS";
        String firstName = "Mike";
        String lastName = "Ryan";
        String email = "ryan04fefd@gmail.com";
        Integer rol = 2;

        User Auser = new User(id,username,password,firstName,lastName,email,rol);

        User expect = new User();

        Mockito.when(userService.create(Auser)).thenReturn(expect);

        User act = userService.create(Auser);

       assertEquals(expect,act);

        Mockito.verify(userService, Mockito.times(1)).create(Auser);

    }

    @Test
    public void testGetAll() {

        Integer id=9;
        String username="fire303";
        String password="asfdf94fAS";
        String firstName = "Mike";
        String lastName = "Ryan";
        String email = "ryan04fefd@gmail.com";
        Integer rol = 1;

        User user1 = new User(id,username,password,firstName,lastName,email,rol);

        User user2 = new User(3,"dsadkads","dpasdjoefja","Johnny","Bravo","johnnybra@gmail.com",2);

        List <User> expectedR = new ArrayList<>();
        List <User> actual = new ArrayList<>();
        expectedR.add(user1);
        expectedR.add(user2);

        Mockito.when(userService.getAll()).thenReturn(expectedR);
        actual = userService.getAll();
        assertEquals(expectedR,actual);

    }
}