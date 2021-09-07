package com.revature.frontcontroller;

import com.revature.controller.EmployeeController;
import com.revature.controller.FinanceManagerController;
import com.revature.controller.UserController;
import com.revature.models.User;
import com.revature.services.FmService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="dispatcher", urlPatterns = "/api/*")
public class dispatcher extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI();
        System.out.println(URI);

        switch (URI){

            case "/api/login":
                if(req.getMethod().equals("POST")){
                    UserController.getInstance().login(req, resp);
                }
                break;
            case "/api/create" :
                if(req.getMethod().equals("POST")){
                    UserController.getInstance().create(req,resp);
                }
                break;

            case "/api/check-session":
                if(req.getMethod().equals("GET")){
                    UserController.getInstance().checkSession(req,resp);
                }
                break;
            case "/api/logout":
                if(req.getMethod().equals("GET")){
                    UserController.getInstance().logout(req,resp);
                }
                break;
            case "/api/Users":
                if(req.getMethod().equals("GET")){
                    UserController.getInstance().getAllUsers(req,resp);
                }
                break;
            case "/api/employee":
                switch (req.getMethod()){
                    case "GET":
                        EmployeeController.getInstance().getEveryReimb(req,resp);
                        break;
                    case "POST":
                        EmployeeController.getInstance().createReim(req,resp);
                        break;
                }

                break;

            case "/api/finance":
                switch (req.getMethod()){
                    case "GET":
                        FinanceManagerController.getInstance().getAllReimWithId(req,resp);
                        break;
                    case "POST":
                        FinanceManagerController.getInstance().updateR(req,resp);
                        break;

                }
                break;
            case "/api/financeA":
                if(req.getMethod().equals("GET")){
                    FinanceManagerController.getInstance().getAllR(req,resp);
                }
                break;


        }


    }
}
