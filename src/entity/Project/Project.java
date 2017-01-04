package entity.Project;

import entity.Address;
import entity.Base;
import entity.Company;
import entity.Person.Employee;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

/**
 * Created by sarmeetsingh on 9/7/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class Project extends Base{
    private Date startDate;
    private char projectType; // gc , sub ?
    private String name;
    @Reference
    private Address address;
    @Reference
    private Employee projectManager;
    @Reference
    private Employee assistantProjectManager;
    @Reference
    private Employee superIntendent;
    @Reference
    private Employee foreman;
    @Reference
    private Employee generalSuperIntendent;
    @Reference
    private Employee createdBy;
    @Reference
    private Company gc;
    @Reference
    private Company owner;

    public Project() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public char getProjectType() {
        return projectType;
    }

    public void setProjectType(char projectType) {
        this.projectType = projectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }

    public Employee getAssistantProjectManager() {
        return assistantProjectManager;
    }

    public void setAssistantProjectManager(Employee assistantProjectManager) {
        this.assistantProjectManager = assistantProjectManager;
    }

    public Employee getSuperIntendent() {
        return superIntendent;
    }

    public void setSuperIntendent(Employee superIntendent) {
        this.superIntendent = superIntendent;
    }

    public Employee getForeman() {
        return foreman;
    }

    public void setForeman(Employee foreman) {
        this.foreman = foreman;
    }

    public Employee getGeneralSuperIntendent() {
        return generalSuperIntendent;
    }

    public void setGeneralSuperIntendent(Employee generalSuperIntendent) {
        this.generalSuperIntendent = generalSuperIntendent;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Company getGc() {
        return gc;
    }

    public void setGc(Company gc) {
        this.gc = gc;
    }

    public Company getOwner() {
        return owner;
    }

    public void setOwner(Company owner) {
        this.owner = owner;
    }


}
