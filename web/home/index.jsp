<%@ page import="base.Constants" %>
<%@ page import="base.Services" %>
<%@ page import="entity.Project.Project" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Person.Employee" %>
<%@include file="../static/includes/header.jsp" %>
<%@include file="../static/includes/main_menu.jsp" %>

<%List<Project> projects = null;%>
<%List<Employee> employees = null;%>


<% if (request.getSession().getAttribute(Constants.sessionAccountType).equals(Constants.accountTypeAssistantProjectManager)
        || request.getSession().getAttribute(Constants.sessionAccountType).equals(Constants.accountTypeProjectManager)) { %>
<% projects = (List<Project>) request.getAttribute(Constants.request_attribute_project_list_home);


%>

<%}%>


<%if (request.getSession().getAttribute(Constants.sessionAccountType).equals(Constants.accountTypeAdministrator)) {%>

<% employees = (List<Employee>) request.getAttribute(Constants.request_attribute_employees_list); %>

<%}%>


<% if (request.getSession().getAttribute(Constants.sessionAccountType).equals(Constants.accountTypeAssistantProjectManager)
        || request.getSession().getAttribute(Constants.sessionAccountType).equals(Constants.accountTypeProjectManager)) { %>
<%@include file="project_manager_project_list.jsp" %>
<%}%>


<%if (request.getSession().getAttribute(Constants.sessionAccountType).equals(Constants.accountTypeAdministrator)) {%>
<%@include file="admin_employee_list.jsp" %>
<%}%>


<%@include file="../static/includes/footer.jsp" %>