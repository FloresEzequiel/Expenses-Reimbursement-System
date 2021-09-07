package com.revature;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.models.Reimbursement;
import com.revature.models.UDate;
import com.revature.models.User;
import com.revature.services.*;
import org.jasypt.util.text.BasicTextEncryptor;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) throws IOException {


       // UserDao doa = new UserDaoImpl();
    // EmployeeDao dd = new EmployeeDaoImpl();

        FmService ff = new FmServiceImpl();
        UserService ll = new UserServiceImpl();
        EmployService st = new EmployServiceImpl();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //ff.getARe();

        //System.out.println(ff.getARe());

       //System.out.println(ff.getAId(1));

        //ff.updateReimId(new UDate(4,timestamp,1,2));

        //encryption



        //fire9493


        //st.createReimbursementTicket(new Reimbursement(null,456.21,null,null,"hotel fees","",2,1,1));

      //  ll.create(new User(null,"robmi59fd","5394jfa3","Robert","Miller","robmiller765@gmail.com",2));
      // ll.create(new User(null,"ryasmt","ryan943","ryan","smith","beaterzeke@gmail.com",2));

       // ll.create(new User(null,"mike32343","johnson40adsde","Riley","Johnson","johnRil@gmail.com",1));

       // ll.login(new User("lol","lol45432"));


        //BufferedImage bImage = ImageIO.read(new File("test.png"));
       // ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //ImageIO.write(bImage, "png", bos );
       // byte [] data = bos.toByteArray();

       // byte[] data= Base64.encode(bos.toByteArray());
        //String s = Base64.toBase64String(data);

       // System.out.println(data);

        //System.out.println(s);


    }
}
