<%@ page import="base.Constants" %>
<%@ page import="entity.Project.Material" %>
<%@ page import="entity.Project.Project" %>
<%@ page import="entity.Report.JobsiteReport" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.List" %>
<%@include file="../static/includes/header.jsp" %>
<%@include file="../static/includes/main_menu.jsp" %>
<%
    Project project = (Project) request.getAttribute(Constants.request_attribute_view_project);
    List<Material> materialList = (List<Material>) request.getAttribute(Constants.request_attribute_project_materials);
    List<JobsiteReport> jobsiteReports = (List<JobsiteReport>) request.getAttribute(Constants.request_attribute_report_list);
%>

<div class="row">

    <div class="large-12 medium-12 small-12 columns">
        <hr>
        <h4>About Project</h4>
    </div>
</div>

<div class="row">

    <div class="large-3 medium-3 small-12 columns">
        <hr>
        <h5>Name</h5>
        <%out.print(project.getName());%>
        <hr>
        <h5>Address</h5>
        <%out.print(project.getAddress().getFirstLine());%> <br/>
        <%out.print(project.getAddress().getSecondLine());%> <br/>
        <%out.print(project.getAddress().getCity() + ", " + project.getAddress().getZip());%>
    </div>
    <div class="large-9 medium-9 small-12 columns">
        <hr>
        <h5>Company Personal</h5>
        <table>
            <thead>
            <tr>
                <th>Position</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Project Manager</td>
                <td><%out.print(project.getProjectManager().getPerson().getName());%></td>
                <td><%out.print(project.getProjectManager().getPerson().getPhoneNumber());%></td>
                <td><%out.print(project.getProjectManager().getPerson().getEmail());%></td>
            </tr>
            <tr>
                <td>Assistant Project Manager</td>
                <td><%out.print(project.getAssistantProjectManager().getPerson().getName());%></td>
                <td><%out.print(project.getAssistantProjectManager().getPerson().getPhoneNumber());%></td>
                <td><%out.print(project.getAssistantProjectManager().getPerson().getEmail());%></td>
            </tr>
            <tr>
                <td>General Super</td>
                <td><%out.print(project.getGeneralSuperIntendent().getPerson().getName());%></td>
                <td><%out.print(project.getGeneralSuperIntendent().getPerson().getPhoneNumber());%></td>
                <td><%out.print(project.getGeneralSuperIntendent().getPerson().getEmail());%></td>
            </tr>
            <tr>
                <td>Super</td>
                <td><%out.print(project.getSuperIntendent().getPerson().getName());%></td>
                <td><%out.print(project.getSuperIntendent().getPerson().getPhoneNumber());%></td>
                <td><%out.print(project.getSuperIntendent().getPerson().getEmail());%></td>
            </tr>
            <tr>
                <td>Foreman</td>
                <td><%out.print(project.getForeman().getPerson().getName());%></td>
                <td><%out.print(project.getForeman().getPerson().getPhoneNumber());%></td>
                <td><%out.print(project.getForeman().getPerson().getEmail());%></td>
            </tr>


            </tbody>
        </table>
    </div>

</div>


<div class="row">

    <div class="large-12 medium-12 small-12 columns">
        <hr>
        <h4>Project Materials</h4>
    </div>
</div>


<div class="row">

    <div class="large-offset-2 medium-offset-2 large-8 medium-8 small-12 columns">
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Total Amount</th>
                <th>Amount Applied</th>
                <th>Amount Charged</th>
            </tr>
            </thead>
            <tbody>

            <%for (Material material : materialList) {%>
            <tr>
                <td><%out.print(material.getName());%></td>
                <td><%out.print(material.getType());%></td>
                <td><%out.print(material.getContractMaterialAmount());%></td>
                <td><%out.print(material.getMaterialApplied());%></td>
                <td><%
                    out.print(material.getPriceOfOne().multiply(new BigDecimal(material.getMaterialApplied())));%></td>
            </tr>
            <%}%>

            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="large-12 medium-12 small-12 columns">
        <hr>
        <h4> List Of Reports</h4>
    </div>
</div>

<div class="row">
    <div class=" large-offset-2 medium-offset-2 large-8 medium-8 small-12 columns">
        <%if (jobsiteReports.size() > 0) {%>
        <%@include file="report_list.jsp" %>
        <%}%>
    </div>
</div>


<div class="row">
    <div class="small-12 large-3 medium-3 columns">
        <div class="expanded button-group">
            <a class="success button"
               href="${pageContext.request.contextPath}/create_daily_report?<%out.print(Constants.projectObjectId+"="+project.getId().toString());%>">Create
                Report</a>
            <a class="alert button">Cancel</a>
        </div>
    </div>
</div>

<%@include file="../static/includes/footer.jsp" %>