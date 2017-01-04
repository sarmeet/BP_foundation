package Controller;

import base.Constants;
import base.Services;
import entity.Auth;
import entity.Person.Employee;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by sarmeetsingh on 9/9/16 with love and lots of
 * chai latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class AuthController {

    public static Auth createAuthenticatedUser(HttpServletRequest request, Employee employee) {

        String email = employee.getPerson().getEmail();
        String password = request.getParameter(Constants.employeePassword);
        String accountType = request.getParameter(Constants.employeeJobTitle); // every jobtitle has its own auth page.
        boolean active = true;
        Auth auth = new Auth();
        auth.setEmployee(employee);
        auth.setEmail(email);
        auth.setPassword(password); // needs salting. -- add to requirements.
        auth.setActive(active); // always true. needs changing . -- set for discussion.
        auth.setAccountType(accountType); // finish the creating of authenticated user.

        Services.ds.save(auth); // Save the authentication parameters to the database.
        return auth;
    }

    public static Auth loginHandler(HttpServletRequest request) {
        String email = request.getParameter(Constants.authUserName);
        String password = request.getParameter(Constants.authPassWord);
        Query<Auth> loginHandlerQuery = Services.ds.createQuery(Auth.class).field("email").equal(email).field("password").equal(password);
        Auth auth = loginHandlerQuery.get();

        return auth;
    }

    public static Employee getLoggedInEmployee(HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            ObjectId objectId = new ObjectId((String) session.getAttribute(Constants.sessionEmployeeId));
            Query<Employee> employees = Services.ds.createQuery(Employee.class).field("id").equal(objectId);
            Employee employee = employees.get();
            return employee;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean getAccountType(HttpServletRequest request, String type){
        if (request.getSession().getAttribute(Constants.sessionAccountType).equals(type)){
            return true;
        }
        return false;
    }


}