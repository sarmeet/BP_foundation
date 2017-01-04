package org.bayport.Project;

import Controller.ProjectController;
import Controller.ProjectMaterialController;
import entity.Project.Material;
import entity.Project.Project;

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
@WebServlet(name = "CreateProject", urlPatterns = "/create_project")
public class CreateProject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Project project = ProjectController.saveProject(ProjectController.createProject(request));
        List<Material> materials = ProjectMaterialController.createProjectMaterial(request, project);
        response.sendRedirect(getServletContext().getContextPath() + "/home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/projects/create_project.jsp").forward(request, response);
    }
}
