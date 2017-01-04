package entity.Report;

import entity.Base;
import entity.Project.Material;
import entity.Project.Project;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;


/**
 * Created by sarmeetsingh on 9/8/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class MaterialReport extends Base {
    private Date date;
    @Reference
    private Project project; // the project the ViewReport belongs to
    @Reference
    private Material material; // the material that is being reported
    private int numberOfTradesmen; // the number of employees working on material
    private Long AmountApplied; // the amount that has been applied

    private String comment;


    public MaterialReport() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }


    public Long getAmountApplied() {
        return AmountApplied;
    }

    public void setAmountApplied(Long amountApplied) {
        AmountApplied = amountApplied;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfTradesmen() {
        return numberOfTradesmen;
    }

    public void setNumberOfTradesmen(int numberOfTradesmen) {
        this.numberOfTradesmen = numberOfTradesmen;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
