package entity.Report;

import entity.Base;
import entity.Person.Employee;
import entity.Project.Project;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * Created by sarmeetsingh on 9/29/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class JobsiteReport extends Base {
    private Date date; // Date of the ViewReport
    @Reference
    private Project project;
    private String jobsiteComment; // comments on the jobsite
    private String jobsiteWorkDone; // the work done that day
    private String jobsiteIncident;
    @Reference
    private List<MaterialReport> materialReportList; // list of materials used
    private int tradesMen; // tradesmen doing other work 1than masonry
    private String workDescription; // description of their work
    private int labourers; // total labourers on the jobsite
    @Reference
    private Employee creator;
    private String notes;

    public JobsiteReport() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getJobsiteComment() {
        return jobsiteComment;
    }

    public void setJobsiteComment(String jobsiteComment) {
        this.jobsiteComment = jobsiteComment;
    }

    public String getJobsiteWorkDone() {
        return jobsiteWorkDone;
    }

    public void setJobsiteWorkDone(String jobsiteWorkDone) {
        this.jobsiteWorkDone = jobsiteWorkDone;
    }

    public List<MaterialReport> getMaterialReportList() {
        return materialReportList;
    }

    public void setMaterialReportList(List<MaterialReport> materialReportList) {
        this.materialReportList = materialReportList;
    }

    public int getTradesMen() {
        return tradesMen;
    }

    public void setTradesMen(int tradesMen) {
        this.tradesMen = tradesMen;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public int getLabourers() {
        return labourers;
    }

    public void setLabourers(int labourers) {
        this.labourers = labourers;
    }

    public Employee getCreator() {
        return creator;
    }

    public void setCreator(Employee creator) {
        this.creator = creator;
    }

    public String getJobsiteIncident() {
        return jobsiteIncident;
    }

    public void setJobsiteIncident(String jobsiteIncident) {
        this.jobsiteIncident = jobsiteIncident;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "JobsiteReport{" +
                "date=" + date +
                ", project=" + project +
                ", jobsiteComment='" + jobsiteComment + '\'' +
                ", jobsiteWorkDone='" + jobsiteWorkDone + '\'' +
                ", materialReportList=" + materialReportList +
                ", tradesMen=" + tradesMen +
                ", workDescription='" + workDescription + '\'' +
                ", labourers=" + labourers +
                ", creator=" + creator +
                '}';
    }
}
