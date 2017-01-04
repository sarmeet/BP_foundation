package Controller;

import base.Constants;
import base.Services;
import entity.Project.Material;
import entity.Project.Project;
import entity.Report.MaterialReport;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sarmeetsingh on 9/30/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class MaterialReportController {
    public static MaterialReport createMaterialReport(HttpServletRequest request, Project project, Material material) {
        MaterialReport report = new MaterialReport();
        report.setMaterial(material);
        report.setProject(project);

        report.setAmountApplied(Long.parseLong(request.getParameter(Constants.reportNumberApplied + "[" + material.getId().toString() + "]")));
        System.out.println(request.getParameter(Constants.reportMasons + "[" + material.getId().toString() + "]"));
        report.setNumberOfTradesmen(Integer.parseInt(request.getParameter(Constants.reportMasons + "[" + material.getId().toString() + "]")));
        report.setComment(request.getParameter(Constants.reportComment + "[" + material.getId().toString() + "]"));
        report.setDate(Services.StringToDate(request.getParameter(Constants.reportDate)));
        return report;
    }

    public static MaterialReport saveMaterialReport(MaterialReport report) {
        Services.ds.save(report);
        return report;
    }

    public static List<MaterialReport> reportList(HttpServletRequest request) {
        Project project = ProjectController.getProjectById(request.getParameter(Constants.projectObjectId));
        List<Material> materials = ProjectController.getProjectMaterial(project);
        List<MaterialReport> reports = materials.stream().map(material -> saveMaterialReport(createMaterialReport(request, project, material))).collect(Collectors.toList());
        return reports;
    }



}
