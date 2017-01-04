package org.bayport.report;

import Controller.JobsiteReportController;
import Controller.ProjectController;
import base.Constants;
import entity.Project.Material;
import entity.Project.Project;
import entity.Report.JobsiteReport;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sarmeetsingh on 10/5/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
@WebServlet(name = "EditReport", urlPatterns = "/edit_report")
public class EditReport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jobsiteId = request.getParameter(Constants.ReportObjectId);
        System.out.println(jobsiteId);
        JobsiteReportController.dropJobsiteReport(jobsiteId);
        JobsiteReport report = JobsiteReportController.saveJobsiteReport(JobsiteReportController.createJobsiteReport(request));
        response.sendRedirect(getServletContext().getContextPath().concat("/view_report?").concat(Constants.ReportObjectId).concat("=").concat(report.getId().toString()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String report_id = request.getParameter(Constants.ReportObjectId);
        JobsiteReport jobsiteReport = JobsiteReportController.getJobsiteReport(report_id);
        Project project = jobsiteReport.getProject();
        List<Material> materials = ProjectController.getProjectMaterial(project);
        request.setAttribute(Constants.request_attribute_view_project, project);
        request.setAttribute(Constants.request_attribute_project_materials, materials);
        request.setAttribute(Constants.request_attribute_report, jobsiteReport);
        getServletContext().getRequestDispatcher("/reports/edit_report.jsp").forward(request, response);
    }

}