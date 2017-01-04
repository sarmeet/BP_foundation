package org.bayport.auth;

import Controller.AuthController;
import base.Constants;
import entity.Auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sarmeetsingh on 9/24/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("heloooo");
        Auth auth = AuthController.loginHandler(request);
        if (auth == null) {
            response.sendRedirect(getServletContext().getContextPath() + "/");
        } else {
            System.out.println("creating session");
            HttpSession session = request.getSession();
            session.setAttribute(Constants.sessionUserName, auth.getEmployee().getPerson().getName());
            session.setAttribute(Constants.sessionAccountType, auth.getAccountType());
            session.setAttribute(Constants.sessionEmail, auth.getEmployee());
            session.setAttribute(Constants.sessionEmployeeId, auth.getEmployee().getId().toString());

            response.sendRedirect(getServletContext().getContextPath() + "/home");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
