package Controller;

import base.Constants;
import base.Services;
import entity.Person.Employee;
import entity.Project.Material;
import entity.Project.Project;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by sarmeetsingh on 9/23/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class ProjectController {
    public static Project createProject(HttpServletRequest request) {
        Project project = new Project();
        project.setStartDate(Services.StringToDate(request.getParameter(Constants.projectStartDate)));
        project.setProjectType(request.getParameter(Constants.projectType).charAt(0));
        project.setName(request.getParameter(Constants.projectName));
        project.setAddress(AddressController.createAddress(request));
        project.setProjectManager(EmployeeController.getEmployeeById(request.getParameter(Constants.projectManagerId)));
        project.setAssistantProjectManager(EmployeeController.getEmployeeById(request.getParameter(Constants.projectAssistantManagerId)));
        project.setSuperIntendent(EmployeeController.getEmployeeById(request.getParameter(Constants.projectSuperIntendentId)));
        project.setForeman(EmployeeController.getEmployeeById(request.getParameter(Constants.projectForemanId)));
        project.setGeneralSuperIntendent(EmployeeController.getEmployeeById(request.getParameter(Constants.projectGeneralSuperIntendentId)));
        project.setCreatedBy(AuthController.getLoggedInEmployee(request));
        return project;
    }

    public static Project saveProject(Project project) {
        Services.ds.save(project);
        return project;
    }

    public static Project getProjectById(String id) {
        ObjectId objectId = new ObjectId(id);
        Query<Project> getProjectById = Services.ds.createQuery(Project.class).field("id").equal(objectId);
        Project project = getProjectById.get();
        return project;
    }

    public static List<Project> getListForEmployee(HttpServletRequest request) {
        Employee employee = AuthController.getLoggedInEmployee(request);
        Query<Project> projects = null;
        String account = (String) request.getSession().getAttribute(Constants.sessionAccountType);
        if (account.equals("pm")) {
            projects = Services.ds.createQuery(Project.class).field("projectManager").equal(employee);

        }
        if (account.equals("apm")) {
            projects = Services.ds.createQuery(Project.class).field("assistantProjectManager").equal(employee);

        }
        if (account.equals("gs")) {
            projects = Services.ds.createQuery(Project.class).field("generalSuperIntendent").equal(employee);

        }
        if (account.equals("s")) {
            projects = Services.ds.createQuery(Project.class).field("superIntendent").equal(employee);

        }
        if (account.equals("f")) {
            projects = Services.ds.createQuery(Project.class).field("foreman").equal(employee);

        }
        return projects.asList();
    }


    public static List<Material> getProjectMaterial(Project project) {
        Query<Material> projectMaterials = Services.ds.createQuery(Material.class).field("project").equal(project);
        List<Material> materials = projectMaterials.asList();
        return materials;
    }

}


