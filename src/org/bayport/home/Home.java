package org.bayport.home;

import Controller.EmployeeController;
import Controller.ProjectController;
import base.Constants;
import entity.Person.Employee;
import entity.Project.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sarmeetsingh on 9/26/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
@WebServlet(name = "Home", urlPatterns = "/home")
public class Home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            if (request.getSession().getAttribute(Constants.sessionAccountType).equals(Constants.accountTypeProjectManager)
                    || request.getSession().getAttribute(Constants.sessionAccountType).equals(Constants.accountTypeAssistantProjectManager)) {
                List<Project> projectList = ProjectController.getListForEmployee(request);
                request.setAttribute(Constants.request_attribute_project_list_home, projectList);
                getServletContext().getRequestDispatcher("/home/index.jsp").forward(request, response);
            } else {
                if (request.getSession().getAttribute(Constants.sessionAccountType).equals(Constants.accountTypeAdministrator)) {

                    List<Employee> employees = EmployeeController.getAllEmployees();
                    request.setAttribute(Constants.request_attribute_employees_list, employees);
                    getServletContext().getRequestDispatcher("/home/index.jsp").forward(request, response);

                } else {
                    System.out.println("error");
                }
            }


        } catch (Exception e) {
            System.out.println("Login succeeded. Exception raised.");
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath().concat("/"));
        }
    }
}
