package org.bayport.employee;

import base.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sarmeetsingh on 10/19/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
@WebServlet(name = "ViewEmployee", urlPatterns = "/view_employee")
public class ViewEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter(Constants.personObjectId);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
