package org.bayport.report;

import Controller.JobsiteReportController;
import base.Constants;
import entity.Report.JobsiteReport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sarmeetsingh on 9/27/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
@WebServlet(name = "ViewReport", urlPatterns = "/view_report")
public class ViewReport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportId = request.getParameter(Constants.ReportObjectId);
        JobsiteReport report= JobsiteReportController.getJobsiteReport(reportId);
        request.setAttribute(Constants.request_attribute_report, report);
        getServletContext().getRequestDispatcher("/reports/view_report.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
