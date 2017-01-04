package entity.Person;

import entity.Base;
import org.mongodb.morphia.annotations.Reference;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sarmeetsingh on 9/7/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class Employee extends Base {
    private Long employeeId;
    @Reference
    private Person person;
    private char gender;
    private String race, jobTitle;
    private Date DOB;
    private BigDecimal payScale;
    private char payscaleType;
    @Reference
    private Employee createdBy;


    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public BigDecimal getPayScale() {
        return payScale;
    }

    public void setPayScale(BigDecimal payScale) {
        this.payScale = payScale;
    }

    public char getPayscaleType() {
        return payscaleType;
    }

    public void setPayscaleType(char payscaleType) {
        this.payscaleType = payscaleType;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }
}