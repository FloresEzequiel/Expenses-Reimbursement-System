package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.Response;
import com.revature.services.EmployService;
import com.revature.services.EmployServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class EmployeeController {
    private static EmployeeController employeeController;
    EmployService employService;

    private EmployeeController(){
        employService = new EmployServiceImpl();
    }

    public static EmployeeController getInstance(){
        if(employeeController==null){
            employeeController = new EmployeeController();
        }
        return employeeController;
    }

    public void getEveryReimb(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Integer userId = Integer.parseInt(req.getParameter("id"));
        out.println(new ObjectMapper().writeValueAsString(new Response("reimb found",true, employService.getAllReimbursements(userId))));

    }

    public void createReim(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Reimbursement reimbursement = new ObjectMapper().readValue(requestBody,Reimbursement.class);
        employService.createReimbursementTicket(reimbursement);
        out.println(new ObjectMapper().writeValueAsString(new Response("new reimbursement created for user"+reimbursement.getAuthor(),true,null)));
    }



}
