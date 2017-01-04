package org.bayport.employee;

import Controller.AuthController;
import Controller.EmployeeController;
import Controller.PersonController;
import base.Constants;
import entity.Person.Employee;
import entity.Person.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sarmeetsingh on 9/20/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
@WebServlet(name = "CreateEmployee", urlPatterns = "/create_employee")
public class CreateEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = EmployeeController.saveEmployee(EmployeeController.createEmployee(request));
        if (request.getParameter(Constants.authEnableLogin) != null) {
            AuthController.createAuthenticatedUser(request, employee);
        }
        response.sendRedirect(request.getContextPath().concat("/"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = PersonController.getPersonById(request.getParameter(Constants.create_employee_person_id));
        if (person == null) {
            System.out.println("Error");
        } else {
            request.setAttribute(Constants.request_attribute_create_employee_person, person);
            getServletContext().getRequestDispatcher("/employee/create_employee.jsp").forward(request, response);
        }
    }
}
