package org.bayport.report;

import Controller.JobsiteReportController;
import Controller.ProjectController;
import base.Constants;
import entity.Project.Material;
import entity.Project.Project;
import entity.Report.JobsiteReport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sarmeetsingh on 9/27/16 with love and lots of
 * chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
@WebServlet(name = "CreateDailyReport", urlPatterns = "/create_daily_report")
public class CreateDailyReport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobsiteReport report = JobsiteReportController.saveJobsiteReport(JobsiteReportController.createJobsiteReport(request));
        response.sendRedirect(getServletContext().getContextPath() + "/view_report?" + Constants.ReportObjectId + "=" + report.getId().toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Project project = ProjectController.getProjectById(request.getParameter(Constants.projectObjectId));
        request.setAttribute(Constants.request_attribute_view_project, project);
        List<Material> projectMaterials = ProjectController.getProjectMaterial(project);
        request.setAttribute(Constants.request_attribute_project_materials, projectMaterials);
        getServletContext().getRequestDispatcher("/reports/index.jsp").forward(request, response);
    }
}
