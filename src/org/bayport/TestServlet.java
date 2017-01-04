package org.bayport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by sarmeetsingh on 8/1/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> requestParameters = request.getParameterNames();
        while (requestParameters.hasMoreElements()) {
            String paramName = (String) requestParameters.nextElement();
            System.out.println("Request Paramter Name: " + paramName
                    + ", Value - " + request.getParameter(paramName));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> requestParameters = request.getParameterNames();
        while (requestParameters.hasMoreElements()) {
            String paramName = (String) requestParameters.nextElement();
            System.out.println("Request Paramter Name: " + paramName
                    + ", Value - " + request.getParameter(paramName));
        }
    }
}
