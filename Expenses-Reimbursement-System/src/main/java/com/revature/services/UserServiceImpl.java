package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.User;
import org.jasypt.util.text.BasicTextEncryptor;
import java.util.List;

import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UserServiceImpl implements UserService{

    UserDao userDao;
    public UserServiceImpl(){
        userDao = UserDaoImpl.getInstance();

    }


    @Override
    //User
    public User create(User user) {

        //check if username exists in the system
        User tempUser = userDao.findUser(user.getUsername());
        if(tempUser != null){
            return null;
        }


        //encripts password using jasypt
        String passEncr="alfafox";
        //password from user
        String pass= user.getPassword();

        BasicTextEncryptor TEncryptor = new BasicTextEncryptor();
        TEncryptor.setPassword(passEncr);
        //encripts  the user password
        String encrpass = TEncryptor.encrypt(pass);
        //adds the encripted password to user
        user.setPassword(encrpass);


        //sends password and email to the user
        String usNa = user.getUsername();
        String ema = user.getEmail();

        //user email
        String to = ema;

        // company email
        String from = "ryan50534535@gmail.com";
        final String username = "ryan50534535@gmail.com";//your gmail username
        final String password = "rafasdasad";//your gmail password

        //using gmail to send mail
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // get the session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // set subject in the email sent
            message.setSubject("Welcome to the The Reimbursement App");

            // Put the content of your message
            message.setText("Hello there, I hope your are doing well. Your user has been successfully created, your Username is: " +
                    usNa+" and your Password is: "+pass);

            // Send message
            Transport.send(message);



        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        userDao.insertUser(user);
       return userDao.findUser(user.getUsername());

    }

    @Override
    public User login(User user) {
        //checks the username in the system
        User tempUser = userDao.findUser(user.getUsername());
        if(tempUser == null){
            return null;
        }


        //catchphrase
        String passEncr="alfafox";
        //encryption
        BasicTextEncryptor TEncryptor = new BasicTextEncryptor();
        TEncryptor.setPassword(passEncr);
        //get password from the data base
        String passU= tempUser.getPassword();
        //password decrypted
        String decrpass =TEncryptor.decrypt(passU);

        //check if password is incorrect

        if(!decrpass.equals(user.getPassword())){
           // System.out.println(tempUser.getPassword());
           // System.out.println((user.getPassword()));
            return null;
        }
        //System.out.println("paswordMatc");
       // System.out.println(tempUser);


        return tempUser;

    }

    @Override
    public List<User> getAll() {
        return userDao.getAllUser();
    }
}
