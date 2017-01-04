package entity;

import entity.Person.Employee;
import org.mongodb.morphia.annotations.Reference;

/**
 * Created by sarmeetsingh on 7/29/16 with love and lots of chai'
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class Auth extends Base {

    private String email, password, accountType;
    @Reference
    private Employee employee;
    private boolean active;

    public Auth() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                ", employee=" + employee.toString() +
                ", active=" + active +
                '}';
    }
}
