package org.bayport.Project;

import Controller.JobsiteReportController;
import Controller.ProjectController;
import base.Constants;
import base.Services;
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
 * Created by sarmeetsingh on 9/23/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
@WebServlet(name = "ViewProject", urlPatterns = "/view_project")
public class ViewProject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projectId = request.getParameter(Constants.projectObjectId);
        Project project = ProjectController.getProjectById(projectId);
        request.setAttribute(Constants.request_attribute_view_project, project);
        List<Material> materials = ProjectController.getProjectMaterial(project);
        request.setAttribute(Constants.request_attribute_project_materials, materials);
        List<JobsiteReport> reports = JobsiteReportController.getJobsiteReport(Services.getWeekStartInDate(0)[0], Services.getWeekStartInDate(0)[1], project);
        System.out.println("list of reports " + reports.size());
        request.setAttribute(Constants.request_attribute_report_list, reports);
        getServletContext().getRequestDispatcher("/projects/view_project.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
