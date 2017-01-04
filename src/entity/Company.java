package entity;


import entity.Person.Person;
import org.mongodb.morphia.annotations.Reference;

import java.util.List;

/**
 * Created by sarmeetsingh on 9/7/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class Company extends Base {
    private String name, email, phoneNumber;
    private List<Person> companyPersonals;
    @Reference
    private Person owner;
    @Reference
    private Person contact;

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Person> getCompanyPersonals() {
        return companyPersonals;
    }

    public void setCompanyPersonals(List<Person> companyPersonals) {
        this.companyPersonals = companyPersonals;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getContact() {
        return contact;
    }

    public void setContact(Person contact) {
        this.contact = contact;
    }
}
