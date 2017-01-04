<%@ page import="entity.Person.Employee" %>
<%@ page import="base.Constants" %>
<%@include file="../static/includes/header.jsp" %>
<%@include file="../static/includes/main_menu.jsp" %>
<%Employee employee = request.getParameter(Constants.employee);%>

<div class="row">
    <div class="large-12 medium-12 small-12 columns">
        <hr>
    </div>
</div>
<div class="row">
    <div class="large-4 medium-4 small-12 columns">
        <h4>About:</h4>
        <h5><%out.print(employee.getPerson().getName());%></h5>
    </div>
    <div class="large-4 medium-4 small-12 columns">
        <h4>Job Title:</h4>
        <h5><%out.print(employee.getJobTitle());%></h5>
    </div>

</div>

<div class="row">
    <div class="large-12 medium-12 small-12 columns">
        <hr>
    </div>
</div>
<div class="row">
    <div class="large-12 medium-12 small-12 columns">
        <h5>Contact:</h5>
    </div>
</div>

<div class="row">
    <div class="large-6 medium-6 small-12 columns">
        <h6>Email</h6>
        <%out.print(employee.getPerson().getEmail());%>
    </div>

    <div class="large-6 medium-6 small-12 columns">
        <h6>Phone</h6>
        <%out.print(employee.getPerson().getPhoneNumber());%>
    </div>
</div>


<%@include file="../static/includes/functional/display_address.jsp" %>


<%@include file="../static/includes/footer.jsp" %>
