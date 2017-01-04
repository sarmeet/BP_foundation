<%@ page import="base.Constants" %>
<%@include file="../static/includes/header.jsp" %>
<%@include file="../static/includes/main_menu_create_employee.jsp" %>
<%
    boolean createEmployee;
    if (request.getAttribute(Constants.request_attribute_create_employee) == null) {
        createEmployee = false;
    } else {
        createEmployee = true;
    }
%>

<form method="post" action="${pageContext.request.contextPath}/create_person">

    <%
            out.print("<input type=\"hidden\" value=\"" + createEmployee + "\" name=\"" + Constants.request_attribute_create_employee + "\">");
    %>

    <div class="row">
        <div class="small-12 medium-5 large-5  columns">
            <hr>
            <h4>About: Person</h4>
            <label>Name
                <input type="text" name="<%out.print(Constants.personName);%>" placeholder="Full Name">
            </label>
        </div>
    </div>
    <div class="row">
        <div class="small-12 medium-5 large-5  columns">
            <label>Email
                <input type="text" name="<%out.print(Constants.personEmail);%>" placeholder="hi@email.com">
            </label>
        </div>
    </div>

    <div class="row">
        <div class="small-12 medium-5 large-5  columns">
            <label>Phone Number
                <input type="text" name="<%out.print(Constants.personPhoneNumber);%>" placeholder="123-123-1234">
            </label>
        </div>
    </div>
    <%@include file="../static/includes/functional/address.jsp" %>

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