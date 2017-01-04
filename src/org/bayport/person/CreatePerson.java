package org.bayport.person;

import Controller.PersonController;
import base.Constants;
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
@WebServlet(name = "CreatePerson", urlPatterns = "/create_person")
public class CreatePerson extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = PersonController.savePerson(PersonController.createPerson(request));
        if (request.getParameter(Constants.request_attribute_create_employee).equals("true")) {
            response.sendRedirect(getServletContext().getContextPath() + "/create_employee?" + Constants.create_employee_person_id + "=" + person.getId().toString());
        } else {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // If the request string has the parameter next_step=create_person,
        // set the attribute of creating of employee as true. This way the post method will know where to redirect it to.


        String nextStep = request.getParameter(Constants.request_next_step);
        if (nextStep != null && nextStep.equals(Constants.create_employee)) {
            request.setAttribute(Constants.request_attribute_create_employee, true);
            getServletContext().getRequestDispatcher("/employee/create_person.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/employee/create_person.jsp").forward(request, response);
        }
    }
}
