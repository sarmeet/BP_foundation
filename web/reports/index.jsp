<%@ page import="base.Constants" %>
<%@ page import="entity.Project.Material" %>
<%@ page import="entity.Project.Project" %>
<%@ page import="java.util.List" %>
<%@include file="../static/includes/header.jsp" %>
<%@include file="../static/includes/main_menu.jsp" %>
<%Project project = (Project) request.getAttribute(Constants.request_attribute_view_project);%>
<%List<Material> projectMaterials = (List<Material>) request.getAttribute(Constants.request_attribute_project_materials);%>

<form method="post" action="${pageContext.request.contextPath}/create_daily_report">
    <div class="row">
        <div class="large-12 medium-12 small-12 columns">
            <hr>
            <h4>Create Report</h4>
        </div>
    </div>
    <input type="hidden" name="<%out.print(Constants.projectObjectId);%>"
           value="<%out.print(project.getId().toString());%>">

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
            <h5>Material Numbers</h5>

            <div class="row">
                <div class="large-3 medium-3 small-12 columns">
                    <label>
                        Date
                        <input type="date"
                               name="<%out.print(Constants.reportDate);%>">
                    </label>
                </div>
            </div>
            <%for (Material material : projectMaterials) {%>

            <div class="row">
                <div class="large-2 medium-2 small-12 columns">
                    <%out.print(material.getName());%>
                </div>
                <div class="large-2 medium-2 small-12 columns">
                    <label>
                        Number Applied
                        <input type="number"
                               name="<%out.print(Constants.reportNumberApplied);%>[<%out.print(material.getId().toString());%>]">
                    </label>
                </div>
                <div class="large-2 medium-2 small-12 columns">
                    <label>
                        Masons
                        <input type="number"
                               name="<%out.print(Constants.reportMasons);%>[<%out.print(material.getId().toString());%>]">
                    </label>
                </div>

                <div class="large-6 medium-6 small-12 columns">
                    <label>Comment
                        <input type="text"
                               name="<%out.print(Constants.reportComment);%>[<%out.print(material.getId().toString());%>]">
                    </label>
                </div>

                <%}%>

            </div>

            <div class="row">
                <div class="large-12 medium-12 small-12 columns">
                    <hr>
                    <h5>Other Information</h5>
                </div>
            </div>
            <div class="row">
                <div class="large-3 medium-3 small-12 columns">
                    Other tradesmen
                    <input type="number"
                           name="<%out.print(Constants.reportTradesmen);%>">
                </div>
                <div class="large-9 medium-9 small-12 columns">
                    Work Done
                    <input type="text"
                           name="<%out.print(Constants.reportTradesmenWork);%>">
                </div>

            </div>


            <div class="row">
                <div class="large-3 medium-3 small-12 columns">
                    <label>Labourers
                        <input type="number"
                               name="<%out.print(Constants.reportLabourers);%>">
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="large-11 medium-11 small-11 columns">
                    <label>Work Performed</label>
                    <input type="text"
                           name="<%out.print(Constants.reportJobsiteComment);%>]">
                </div>
            </div>
            <div class="row">
                <div class="large-11 medium-11 small-11 columns">
                    <label>Jobsite Comment(s)</label>
                    <input type="text"
                           name="<%out.print(Constants.reportJobsiteWorkDone);%>">
                </div>
            </div>
            <div class="row">
                <div class="large-11 medium-11 small-11 columns">
                    <label>Jobsite Incident(s)</label>
                    <input type="text"
                           name="<%out.print(Constants.reportIncident);%>">
                </div>
            </div>
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
