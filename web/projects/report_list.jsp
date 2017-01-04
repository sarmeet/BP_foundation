<%@ page import="Controller.JobsiteReportController" %>
<%@ page import="base.Services" %>

<table>
    <thead>
    <tr>
        <th>Date</th>
        <th>Production Amount</th>
        <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "cmu")) { %>
        <th>CMU</th>
        <%}%>
        <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "brick")) { %>
        <th>Brick</th>
        <%}%>
        <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "stucco")) { %>
        <th>Stucco</th>
        <%}%>
        <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "stone")) { %>
        <th>Stone</th>
        <%}%>
        <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "concrete")) { %>
        <th>Concrete</th>
        <%}%>
        <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "scaffolding")) { %>
        <th>Scaffolding</th>
        <%}%>
        <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "waterproofing")) { %>
        <th>Waterproofing</th>
        <%}%>
        <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "relieving_angles")) { %>
        <th>Relieving Angles</th>
        <%}%>

    </tr>
    </thead>
    <tbody>


    <%for (JobsiteReport report : jobsiteReports) {%>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/view_report?<%out.print(Constants.ReportObjectId +"="+ report.getId().toString());%>">
                <% out.print(Services.getDisplayFormat(report.getDate()));%></a>
        </td>
        <td>
            $ <%out.print(JobsiteReportController.sumOfJobsiteProduction(report));%>
        </td>
            <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "cmu")) { %>
        <td>
            <%out.print(JobsiteReportController.getTypeCount(report, "cmu"));%>
        </td>
            <%}%>
            <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "brick")) { %>
        <td><%out.print(JobsiteReportController.getTypeCount(report, "brick"));%></td>
            <%}%>

            <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "stucco")) { %>
        <td><%out.print(JobsiteReportController.getTypeCount(report, "stucco"));%></td>
            <%}%>

            <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "stone")) { %>
        <td><%out.print(JobsiteReportController.getTypeCount(report, "stone"));%></td>
            <%}%>
            <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "concrete")) { %>
        <td><%out.print(JobsiteReportController.getTypeCount(report, "concrete"));%></td>
            <%}%>
            <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "scaffolding")) { %>
        <td><%out.print(JobsiteReportController.getTypeCount(report, "scaffolding"));%></td>
            <%}%>
            <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "waterproofing")) { %>
        <td><%out.print(JobsiteReportController.getTypeCount(report, "waterproofing"));%></td>
            <%}%>
            <% if (JobsiteReportController.getTypeExists(jobsiteReports.get(0), "relieving_angles")) { %>
        <td><%out.print(JobsiteReportController.getTypeCount(report, "relieving_angles"));%></td>
            <%}%>
            <%}%>

    </tbody>
</table>

