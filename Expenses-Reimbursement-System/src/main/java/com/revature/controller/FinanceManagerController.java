package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Response;
import com.revature.models.UDate;
import com.revature.services.FmService;
import com.revature.services.FmServiceImpl;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class FinanceManagerController {
    private static FinanceManagerController financeManagerController;
    FmService fmService;

    private FinanceManagerController(){
        fmService = new FmServiceImpl();
    }
    public static FinanceManagerController getInstance(){
        if(financeManagerController==null){
            financeManagerController = new FinanceManagerController();
        }
        return financeManagerController;
    }

    public void getAllReimWithId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Integer userId = Integer.parseInt(req.getParameter("id"));
        out.println(new ObjectMapper().writeValueAsString(new Response("reimb found",true,fmService.getAId(userId))));
    }

    public void getAllR(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println(new ObjectMapper().writeValueAsString(new Response("retrieved all",true,fmService.getARe())));
    }

    public void updateR(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        UDate uDate = new ObjectMapper().readValue(requestBody,UDate.class);
        fmService.updateReimId(uDate);
        out.println(new ObjectMapper().writeValueAsString(new Response("update successful",true,null)));
    }

}
