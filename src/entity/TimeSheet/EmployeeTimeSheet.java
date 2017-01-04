package entity.TimeSheet;

import entity.Base;
import entity.Person.Employee;
import entity.Project.Project;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

/**
 * Created by sarmeetsingh on 9/8/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class EmployeeTimeSheet extends Base {
    @Reference
    private Employee employee;
    @Reference
    private Project project;
    private Date timeIn;
    private Date timeOut;
    private Date date;

    public EmployeeTimeSheet() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}