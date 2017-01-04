package entity.Person;

import entity.Address;
import entity.Base;
import org.mongodb.morphia.annotations.Reference;

/**
 * Created by sarmeetsingh on 9/7/16 with love and lots of chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class Person extends Base {

    private String name, email, phoneNumber;
    @Reference
    private Address address;


    public Person() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
