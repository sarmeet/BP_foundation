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
@WebServlet(name = "DisplayPerson", urlPatterns = "/displayPerson")
public class DisplayPerson extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = PersonController.getPersonById(request.getParameter(Constants.personObjectId));
        request.setAttribute(Constants.request_attribute_display_person, person);
        getServletContext().getRequestDispatcher("/employee/display_person.jsp").forward(request, response);
    }
}
