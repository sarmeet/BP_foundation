package Controller;

import base.Constants;
import base.Services;
import entity.Project.Material;
import entity.Project.Project;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarmeetsingh on 9/23/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class ProjectMaterialController {
    public static List<Material> createProjectMaterial(HttpServletRequest request, Project project) {
        List<Material> projectMaterials = new ArrayList<>();
        int materialsCount = Integer.parseInt(request.getParameter(Constants.projectMaterialNumbers));
        for (int x = 0; x < materialsCount; x++) {
            if (request.getParameter("project.material.name[" + x + "]") != null) {
                Material projectMaterial = new Material();
                projectMaterial.setProject(project);
                projectMaterial.setName(request.getParameter("project.material.name[" + x + "]"));
                projectMaterial.setType(request.getParameter("project.material.type[" + x + "]"));
                projectMaterial.setContractMaterialAmount(Long.valueOf(request.getParameter("project.TotalQuantity[" + x + "]")));
                projectMaterial.setMaterialAmountAlreadyApplied(Long.valueOf(request.getParameter("project.UsedQuantity[" + x + "]")));
                projectMaterial.setUnit(request.getParameter("project.MaterialUnit[" + x + "]"));
                projectMaterial.setPrice(new BigDecimal(request.getParameter("project.TotalCost[" + x + "]")));
                projectMaterial.setPriceOfOne(projectMaterial.getPrice().divide(new BigDecimal(projectMaterial.getContractMaterialAmount()), BigDecimal.ROUND_CEILING, 2));
                projectMaterial.setMaterialApplied(0L);
                saveMaterial(projectMaterial);
                projectMaterials.add(projectMaterial);
            }
        }
        return projectMaterials;
    }


    public static Material saveMaterial(Material material) {
        Services.ds.save(material);
        return material;
    }

    /**
     * get a projet material with its id
     *
     * @param id
     * @return
     */
    public static Material getProjectMaterialById(String id) {
        ObjectId objectId = new ObjectId(id);
        Query<Material> getProjectMaterialById = Services.ds.createQuery(Material.class).field("id").equal(objectId);
        Material projectMaterial = getProjectMaterialById.get();
        return projectMaterial;
    }


}
