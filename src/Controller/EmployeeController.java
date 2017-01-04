package Controller;

import base.Constants;
import base.Services;
import entity.Person.Employee;
import entity.Person.Person;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by sarmeetsingh on 9/9/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class EmployeeController {

    public static Employee createEmployee(HttpServletRequest request) {
        Employee employee = new Employee();
        Person person = PersonController.getPersonById(request.getParameter(Constants.employeeObjectId));
        System.out.println(person.getName());
        employee.setEmployeeId(Long.parseLong(request.getParameter(Constants.employeeId)));
        employee.setPerson(person);
        employee.setGender(request.getParameter(Constants.employeeGender).charAt(0));
        employee.setRace(request.getParameter(Constants.employeeRace));
        employee.setJobTitle(request.getParameter(Constants.employeeJobTitle));
        employee.setDOB(Services.StringToDate(request.getParameter(Constants.employeeDOB)));
        employee.setPayScale(new BigDecimal(request.getParameter(Constants.employeePayScale)));
        employee.setPayscaleType(request.getParameter(Constants.employeePayScaleType).charAt(0));
        return employee;
    }

    public static Employee updateEmployee(HttpServletRequest request) {
        Employee employee = createEmployee(request);
        ObjectId objectId = new ObjectId(request.getParameter(Constants.objectId));
        return employee;
    }

    public static Employee createAuthenticatedEmployee(HttpServletRequest request) {
        Employee employee = createEmployee(request);
        saveEmployee(employee);
        AuthController.createAuthenticatedUser(request, employee);
        return employee;
    }


    public static Employee saveEmployee(Employee employee) {
        Services.ds.save(employee);
        return employee;
    }


    public static Employee getEmployeeById(String employeeId) {
        ObjectId objectId = new ObjectId(employeeId);
        Query<Employee> getEmployeeByidQuery = Services.ds.createQuery(Employee.class).field("id").equal(objectId);
        Employee employee = getEmployeeByidQuery.get(); // redundant but for consistency sake.
        return employee;
    }

    public static List<Employee> getEmployeeByType(String type) {
        List<Employee> employees;
        Query<Employee> getEmployeeByType = Services.ds.createQuery(Employee.class).field("jobTitle").equal(type);
        employees = getEmployeeByType.asList();
        return employees;
    }

    public static String printEmployeeOptionsDropDown(List<Employee> employees) {
        String dropdown = "";
        for (Employee employee : employees) {
            dropdown = dropdown + "<option value=\"" + employee.getId() + "\">" + employee.getPerson().getName() + "</option>";
        }
        return dropdown;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employees;

        Query<Employee> getallEmployees = Services.ds.createQuery(Employee.class);

        employees = getallEmployees.asList();
        return employees;
    }
}
