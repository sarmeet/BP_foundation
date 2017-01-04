package entity.TimeSheeting;

import entity.Base;
import entity.Person.Employee;
import entity.Project.Project;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

/**
 * Created by sarmeetsingh on 9/7/16 with love and lots
 * of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */

public class TimeSheet extends Base {

    @Reference
    private Project project;
    private Date startTime;
    private Date endTime;
    @Reference
    private Employee createdBy;

    public TimeSheet() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }
}
