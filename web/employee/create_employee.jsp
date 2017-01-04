<%@ page import="base.Constants" %>
<%@ page import="entity.Person.Person" %>
<%@include file="../static/includes/header.jsp" %>
<%@include file="../static/includes/main_menu_create_employee.jsp" %>
<% Person person = (Person) request.getAttribute(Constants.request_attribute_create_employee_person);%>


<div class="row">
    <div class="small-12 medium-12 large-12 columns">
        <hr>
        <h4>Add Employee: </h4>
        <h5>Name</h5>
        <% out.print(person.getName());%>
    </div>
</div>

<form action="${pageContext.request.contextPath}/create_employee" method="post">
    <input type="hidden" name="<%out.print(Constants.employeeObjectId);%>"
           value="<%out.print(person.getId().toString());%>">
    <div class="row">
        <div class="small-12 medium-12 large-12 columns">
            <hr>
            <h4>Additional Information: </h4>
        </div>
    </div>
    <div class="row">


        <div class="small-12 medium-4 large-4 columns">

            <label>Gender
                <select name="<%out.print(Constants.employeeGender);%>">
                    <option value="m">Male</option>
                    <option value="f">Female</option>
                </select>
            </label>
        </div>

        <div class="small-12 medium-4 large-4 columns">

            <label>Employee ID
                <input type="number" name="<%out.print(Constants.employeeId);%>">
            </label>
        </div>

        <div class="small-12 medium-4 large-4 columns">
            <label>Date Of Birth
                <input type="date" name="<%out.print(Constants.employeeDOB);%>">
            </label>

        </div>
    </div>
    <div class="row">

        <div class="small-12 medium-4 large-4 columns">
            <label>Title
                <select name="<%out.print(Constants.employeeJobTitle);%>">

                    <option value="<%out.print(Constants.accountTypeProjectManager);%>">Project Manager</option>
                    <option value="<%out.print(Constants.accountTypeAdministrator);%>">Administrator !</option>
                    <option value="<%out.print(Constants.accountTypeAssistantProjectManager);%>">Assistant Project
                        Manager
                    </option>
                    <option value="<%out.print(Constants.accountTypeGeneralSuper);%>">General Super</option>
                    <option value="<%out.print(Constants.accountTypeSuper);%>">Super</option>
                    <option value="<%out.print(Constants.accountTypeForeman);%>">Foreman</option>
                    <option value="<%out.print(Constants.accountTypeMason);%>">Mason</option>
                    <option value="<%out.print(Constants.accountTypeLabourer);%>">Labourer</option>
                </select>
            </label>
        </div>


        <div class="small-12 medium-4 large-4 columns">
            <label>Race
                <select name="<%out.print(Constants.employeeRace);%>">

                    <option value="hi">Hispanic or Latino</option>
                    <option value="wh">White</option>
                    <option value="bl">Black or African American</option>
                    <option value="as">Asian</option>
                    <option value="na">Native Hawaiian</option>
                    <option value="aa">American Indian</option>
                    <option value="tw">Two or More races</option>
                </select>
            </label>
        </div>

        <div class="small-12 medium-2 large-2 columns">
            <label>PayScale
                <input type="number" step="any" name="<%out.print(Constants.employeePayScale);%>">
            </label>
        </div>


        <div class="small-12 medium-2 large-2 columns">
            <label>Pay Scale Type
                <select name="<%out.print(Constants.employeePayScaleType);%>">

                    <option value="h">hourly</option>
                    <option value="w">weekly</option>
                </select>
            </label>
        </div>


    </div>

    <div class="row">
        <div class="small-12 medium-12 large-12 columns">
            <hr>

            <h4> Employee Authentication: </h4>
        </div>
    </div>
    <div class="row">

        <div class="small-12 medium-2 large-2 columns">

            <input id="enable-login" type="checkbox" name="<% out.print(Constants.authEnableLogin); %>"><label
                for="enable-login">Enable Login</label>
        </div>

        <div class="small-12 medium-4 large-4 columns">

            <label>
                Password
                <input type="password" name="<%out.print(Constants.employeePassword);%>">
            </label>
        </div>

        <div class="small-12 medium-4 large-4 columns">
            <label>
                Password again:
                <input type="password" name="<%out.print(Constants.employeePasswordAgain);%>">
            </label>
        </div>
        <div class="small-12 medium-2 large-2 columns">

        </div>
    </div>

    <div class="row">
        <div class="small-12 large-3 medium-3 columns">
            <div class="expanded button-group">
                <input class="success button" type="submit">Submit</input>
                <a class="alert button">Cancel</a>
            </div>
        </div>
    </div>
</form>

<%@include file="../static/includes/footer.jsp" %>