<%@ page import="Controller.JobsiteReportController" %>
<%@ page import="base.Constants" %>
<%@ page import="base.Services" %>
<%@ page import="entity.Report.JobsiteReport" %>
<%@ page import="entity.Report.MaterialReport" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Objects" %>
<%@include file="../static/includes/header.jsp" %>
<%@include file="../static/includes/main_menu.jsp" %>


<%JobsiteReport jobsiteReport = (JobsiteReport) request.getAttribute(Constants.request_attribute_report);%>


<div class="row">
    <div class="large-12 medium-12 small-12 columns">
        <hr>
        <h4>Report: <%out.print(Services.getDisplayFormat(jobsiteReport.getDate()));%></h4>
    </div>


</div>
<div class="row">
    <div class="large-12 medium-12 small-12 columns">
        <hr>
        <a href="${pageContext.request.contextPath}/edit_report?<%out.print(Constants.ReportObjectId+"="+jobsiteReport.getId().toString());%>">
            <button type="button" class="success button">Edit Report</button>
        </a>
    </div>

</div>

<div class="row">

    <div class="large-3 medium-3 small-12 columns">
        <hr>
        <h5>Name</h5>
        <%out.print(jobsiteReport.getProject().getName());%>
        <hr>
        <h5>Address</h5>
        <%out.print(jobsiteReport.getProject().getAddress().getFirstLine());%> <br/>
        <%out.print(jobsiteReport.getProject().getAddress().getSecondLine());%> <br/>
        <%out.print(jobsiteReport.getProject().getAddress().getCity() + ", " + jobsiteReport.getProject().getAddress().getZip());%>
    </div>

    <div class="large-9 medium-9 small-12 columns">

        <div class="row">
            <div class="large-12 medium-12 small-12 columns">
                <hr>
                <h5>Material Report</h5>
            </div>
        </div>

        <div class="row">
            <div class="large-12 medium-12 small-12 columns">

                <table class="hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Total Amount</th>
                        <th>Amount Applied</th>
                        <th>Number of Tradesmen</th>
                        <th>Average/Tradesmen</th>
                        <%if (AuthController.getAccountType(request, Constants.accountTypeProjectManager) || AuthController.getAccountType(request, Constants.accountTypeAssistantProjectManager)) {%>
                        <th>Production</th>
                        <%}%>

                    </tr>
                    </thead>
                    <tbody>
                    <%for (MaterialReport materialReport : jobsiteReport.getMaterialReportList()) {%>
                    <tr>
                        <td><%out.print(materialReport.getMaterial().getName());%></td>
                        <td><%out.print(materialReport.getMaterial().getContractMaterialAmount());%></td>
                        <td><%out.print(materialReport.getAmountApplied());%></td>
                        <td><%out.print(materialReport.getNumberOfTradesmen());%></td>
                        <td><%
                            out.print(materialReport.getAmountApplied() / materialReport.getNumberOfTradesmen());%></td>
                        <%if (AuthController.getAccountType(request, Constants.accountTypeProjectManager) || AuthController.getAccountType(request, Constants.accountTypeAssistantProjectManager)) {%>

                        <td><%
                            out.print("$ " + materialReport.getMaterial().getPriceOfOne().multiply
                                    (new BigDecimal(materialReport.getAmountApplied())));%></td>
                        <%}%>
                    </tr>
                    <%}%>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><Strong>Total</Strong></td>
                        <td><Strong><%
                            out.print("$ " + JobsiteReportController.sumOfJobsiteProduction(jobsiteReport));%></Strong>
                        </td>

                    </tr>

                    </tbody>
                </table>
            </div>
        </div>


        <div class="row">
            <div class="large-12 medium-12 small-12 columns">
                <hr>
                <h5>Extended Report</h5>
            </div>
        </div>

        <div class="row">
            <div class="large-3 medium-3 small-12 columns">
                <h6>Other Tradesmen</h6>
                <%out.print(jobsiteReport.getTradesMen());%>
            </div>
            <div class="large-9 medium-9 small-12 columns">
                <h6>Work Done</h6>
                <%

                    if (jobsiteReport.getWorkDescription() == null || Objects.equals(jobsiteReport.getWorkDescription(), "")) {
                        out.print("None");
                    } else {
                        out.print(jobsiteReport.getWorkDescription());

                    }%>

            </div>

        </div>
        <div class="row">
            <div class="large-3 medium-3 small-12 columns">
                <h6>Labourers</h6>
                <%
                    out.print(jobsiteReport.getLabourers());
                %>
            </div>
        </div>

        <div class="row">
            <div class="large-12 medium-12 small-12 columns">
                <h6>Jobsite Log</h6>
                <%

                    if (jobsiteReport.getJobsiteWorkDone() == null || Objects.equals(jobsiteReport.getJobsiteWorkDone(), "")) {
                        out.print("None");
                    } else {
                        out.print(jobsiteReport.getJobsiteWorkDone());
                    }
                %>

            </div>
        </div>
        <div class="row">
            <div class="large-12 medium-12 small-12 columns">
                <h6>Jobsite Comments</h6>

                <%


                    if (jobsiteReport.getJobsiteComment() == null || Objects.equals(jobsiteReport.getJobsiteComment(), "")) {
                        out.print("None");
                    } else {

                        out.print(jobsiteReport.getJobsiteComment());
                    }%>

            </div>
        </div>
        <div class="row">
            <div class="large-12 medium-12 small-12 columns">
                <h6>Incidents</h6>
                <%
                    if (jobsiteReport.getJobsiteIncident() == null || Objects.equals(jobsiteReport.getJobsiteIncident(), "")) {
                        out.print("None");
                    } else {
                        out.print(jobsiteReport.getJobsiteIncident());
                    }
                %>
            </div>
        </div>
    </div>
</div>


<div class="row">
    <div class="large-12 medium-12 small-12 columns">

        <a href="${pageContext.request.contextPath}/view_project?<%out.print(Constants.projectObjectId + "=" + jobsiteReport.getProject().getId().toString());%>">
            <button type="button" class="success button">Back To Project</button>
        </a>
    </div>
</div>
<%@include file="../static/includes/footer.jsp" %>
