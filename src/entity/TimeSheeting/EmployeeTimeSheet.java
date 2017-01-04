package entity.TimeSheeting;

import entity.Base;
import entity.Person.Employee;
import org.mongodb.morphia.annotations.Reference;

import java.util.List;

/**
 * Created by sarmeetsingh on 9/7/16 with love and lots of
 * chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class EmployeeTimeSheet extends Base {
    @Reference
    private Employee employee;
    private List<EmployeeTimeSheet> timeSheets;

    public EmployeeTimeSheet() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<EmployeeTimeSheet> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(List<EmployeeTimeSheet> timeSheets) {
        this.timeSheets = timeSheets;
    }
}
