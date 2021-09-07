package com.revature.dao;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import com.revature.models.User;

public class UserDaoImplTest {

    @Mock
    public UserDao userDao;

    @BeforeEach
    void setup(){MockitoAnnotations.initMocks(this);}


    @Test
    public void testInsertUser() {

        Integer id=9;
        String username="alfapopwq";
        String password="fasdfdsaf";
        String firstName = "Mike";
        String lastName = "Thomas";
        String email = "dasodjsdsad@gmail.com";
        Integer rol = 1;

        User newUser = new User(id,username,password,firstName,lastName,email,rol);

        userDao.insertUser(newUser);

        Mockito.verify(userDao, Mockito.times(1)).insertUser(newUser);


    }

    @Test
    public void testFindUser() {
        Integer id = 12;
        String username = "brian30323";
        String password = "briuandsadsad";
        String firstName= "Brian";
        String lastName = "Griffin";
        String email = "brian324324@gmail.com";
        Integer rol = 2;


        User user1 = new User(id,username,password,firstName,lastName,email,rol);
        //User user2 = new User(4,"koderwsa","fdadad32re","Jimmy","Smith","adafergewfe@gmail.com",2);
        List<User> expectedR = new ArrayList<>();
        List<User> actual = new ArrayList<>();
        expectedR.add(user1);
       // expectedR.add(user2);
        User add= new User();
        Mockito.when(userDao.findUser("brian30323")).thenReturn(expectedR.get(0));
          add = userDao.findUser("brian30323");
        actual.add(add);
         assertEquals(expectedR,actual);

    }

    @Test
    public void testGetAllUser() {

        Integer id = 12;
        String username = "brian30323";
        String password = "briuandsadsad";
        String firstName= "Brian";
        String lastName = "Griffin";
        String email = "brian324324@gmail.com";
        Integer rol = 2;

        User user1 = new User(id,username,password,firstName,lastName,email,rol);
        User user2 = new User(4,"koderwsa","fdadad32re","Jimmy","Smith","adafergewfe@gmail.com",2);
        List<User> expectedR = new ArrayList<>();
        List<User> actual = new ArrayList<>();
        expectedR.add(user1);
        expectedR.add(user2);

        Mockito.when(userDao.getAllUser()).thenReturn(expectedR);

        actual = userDao.getAllUser();

        assertEquals(expectedR,actual);

    }
}