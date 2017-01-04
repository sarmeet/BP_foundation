package Controller;

import base.Constants;
import base.Services;
import entity.Project.Material;
import entity.Project.Project;
import entity.Report.JobsiteReport;
import entity.Report.MaterialReport;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sarmeetsingh on 9/30/16 with love and lots of
 * chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class JobsiteReportController {

    public static JobsiteReport createJobsiteReport(HttpServletRequest request) {
        Project project = ProjectController.getProjectById(request.getParameter(Constants.projectObjectId));
        JobsiteReport report = new JobsiteReport();
        report.setProject(project);
        report.setDate(Services.StringToDate(request.getParameter(Constants.reportDate)));
        report.setJobsiteWorkDone(request.getParameter(Constants.reportJobsiteWorkDone));
        report.setTradesMen(Integer.parseInt(request.getParameter(Constants.reportTradesmen)));
        report.setWorkDescription(request.getParameter(Constants.reportTradesmenWork));
        report.setLabourers(Integer.parseInt(request.getParameter(Constants.reportLabourers)));
        report.setJobsiteComment(request.getParameter(Constants.reportJobsiteWorkDone));
        report.setMaterialReportList(MaterialReportController.reportList(request));
        report.setCreator(AuthController.getLoggedInEmployee(request));
        report.setJobsiteIncident(request.getParameter(Constants.reportIncident));
        report.setNotes(Constants.reportNotes);
        System.out.println(report.toString());
        return report;
    }

    public static JobsiteReport saveJobsiteReport(JobsiteReport report) {
        Services.ds.save(report);
        return report;
    }

    public static JobsiteReport getJobsiteReport(Date date, Project project) {
        Query<JobsiteReport> report = Services.ds.createQuery(JobsiteReport.class).field("date").equal(date).field("project").equal(project);
        JobsiteReport jobsiteReport = report.get();
        return jobsiteReport;
    }

    public static List<JobsiteReport> getJobsiteReport(Date date) {
        Query<JobsiteReport> report = Services.ds.createQuery(JobsiteReport.class).field("date").equal(date);
        List<JobsiteReport> jobsiteReport = report.asList();
        return jobsiteReport;
    }

    public static List<JobsiteReport> getJobsiteReport(Date StartDate, Date endDate, Project project) {
        System.out.println("StartDate" + StartDate);
        System.out.println("endDate" + endDate);

        Query<JobsiteReport> jobListQuery = Services.ds.createQuery(JobsiteReport.class).field("date").greaterThan(StartDate).field("date").lessThan(endDate).field("project").equal(project);
        List<JobsiteReport> reports = jobListQuery.asList();
        System.out.println("Report Size" + reports.size());

        return reports;
    }

    public static JobsiteReport getJobsiteReport(String reportId) {
        ObjectId objectId = new ObjectId(reportId);
        Query<JobsiteReport> jobsiteReportQuery = Services.ds.createQuery(JobsiteReport.class).field("id").equal(objectId);
        JobsiteReport jobsiteReport = jobsiteReportQuery.get();
        return jobsiteReport;
    }

    public static BigDecimal sumOfJobsiteProduction(JobsiteReport report) {
        BigDecimal total = new BigDecimal(0);
        for (MaterialReport materialReport : report.getMaterialReportList()) {
            total = total.add(materialReport.getMaterial().getPriceOfOne().multiply(new BigDecimal(materialReport.getAmountApplied())));
        }
        return total;
    }

    public static Long getTypeCount(JobsiteReport report, String type) {
        List<MaterialReport> materialReports = report.getMaterialReportList();
        Long ret = 0L;
        for (MaterialReport materialReport : materialReports) {
            if (materialReport.getMaterial().getType().equals(type)) {
                ret = ret + materialReport.getAmountApplied();
            }
        }
        return ret;
    }

    public static Boolean getTypeExists(JobsiteReport report, String type) {
        List<MaterialReport> materialReports = report.getMaterialReportList();
        for (MaterialReport materialReport : materialReports) {
            if (materialReport.getMaterial().getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static Long getMaterialAmount(JobsiteReport report, Material material) {
        for (MaterialReport materialReport : report.getMaterialReportList()) {
            if (materialReport.getMaterial().getId().toString().equals(material.getId().toString())) {
                System.out.println(materialReport.getMaterial().getName() + " :" + materialReport.getAmountApplied());
                return materialReport.getAmountApplied();
            }
        }
        return 0L;
    }

    public static List<JobsiteReport> filterJobsiteList(List<JobsiteReport> reports) {
        List<JobsiteReport> jobsiteReports = new ArrayList<>();
        for (JobsiteReport report : reports) {

        }
        return jobsiteReports;
    }

    public static void dropJobsiteReport(String id) {
        JobsiteReport report = getJobsiteReport(id);
        Services.ds.delete(report);
    }


}