package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Response;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class UserController {


    private static UserController userController;
    UserService userService;
    private UserController(){
        userService = new UserServiceImpl();
    }

    public static UserController getInstance(){
        if(userController == null)
            userController = new UserController();

        return userController;
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        User user = new ObjectMapper().readValue(requestBody,User.class);
        User tempUser = userService.login(user);
        if(tempUser != null){
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("userObj",tempUser);

            out.println(new ObjectMapper().writeValueAsString(new Response("login successful", true, tempUser)));
        }else{
            out.println(new ObjectMapper().writeValueAsString(new Response("invalid username or password", false, null)));
        }

    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        User user = new ObjectMapper().readValue(requestBody,User.class);

        //try to create user
        User tempUser = userService.create(user);

        if(tempUser != null){
            //if user was created
            out.println(new ObjectMapper().writeValueAsString(new Response("user has been created", true, tempUser)));
        }else{
            //if username already exists in the system
            out.println(new ObjectMapper().writeValueAsString(new Response("username already exists in the system", false, null)));

        }
    }

    public void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        User user = (User) req.getSession().getAttribute("userObj");

        if(user != null){
            out.println(new ObjectMapper().writeValueAsString(new Response("session Found",true,user)));
        }else{
            out.println(new ObjectMapper().writeValueAsString(new Response("No session found",false,null)));
        }
    }
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        req.getSession().setAttribute("userObj", null);

        out.println(new ObjectMapper().writeValueAsString(new Response("session terminated",true,null)));
    }

    public void getAllUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println(new ObjectMapper().writeValueAsString(new Response("retrieved all",true,userService.getAll())));
    }


}
