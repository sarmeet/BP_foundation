<%@ page import="Controller.EmployeeController" %>
<%@ page import="base.Constants" %>
<%@include file="../static/includes/header.jsp" %>
<%@include file="../static/includes/main_menu.jsp" %>

<form method="post" action="${pageContext.request.contextPath}/create_project">
    <div class="row">

        <div class="large-12 medium-12 small-12 columns">
            <hr>
            <h4>About Project</h4>
        </div>
    </div>


    <div class="row">
        <div class="small-12 medium-3 large-3 columns">
            <label>
                Name
                <input type="text" name="<%out.print(Constants.projectName);%>">
            </label>
        </div>
        <div class="small-12 medium-3 large-3 columns">
            <label>
                Name
                <select name="<%out.print(Constants.projectType);%>">
                    <option name="gc">General Contractor</option>
                    <option name="sc">Sub Contractor</option>
                </select>
            </label>
        </div>
        <div class="small-12 medium-3 large-3 columns">
            <label>
                GC
                <input type="text" name="<%out.print(Constants.projectGC);%>">
            </label>
        </div>
        <div class="small-12 medium-3 large-3 columns">
            <label>
                Owner
                <input type="text" name="<%out.print(Constants.projectOwner);%>">
            </label>
        </div>
    </div>
    <div class="row">
        <div class="small-12 medium-3 large-3 columns">
            <label>Start Date
                <input type="date" name="<%out.print(Constants.projectStartDate);%>">
            </label>
        </div>
    </div>


    <%@include file="../static/includes/functional/address.jsp" %>

    <div class="row">
        <div class="large-12 medium-12 small-12 columns">
            <hr>
            <h4>Company Personal</h4>
        </div>
    </div>
    <div class="row">
        <div class="large-6 medium-6 small-12 columns">
            <label>
                Project Manager
                <select name="<%out.print(Constants.projectManagerId);%>">
                    <%out.print(EmployeeController.printEmployeeOptionsDropDown(EmployeeController.getEmployeeByType("pm")));%>
                </select>
            </label>
        </div>
        <div class="large-6 medium-6 small-12 columns">
            <label>
                Assistant Project Manager
                <select name="<%out.print(Constants.projectAssistantManagerId);%>">
                    <%out.print(EmployeeController.printEmployeeOptionsDropDown(EmployeeController.getEmployeeByType("apm")));%>

                </select>
            </label>
        </div>
    </div>

    <div class="row">
        <div class="large-4 medium-4 small-12 columns">
            <label>
                General Super
                <select name="<%out.print(Constants.projectGeneralSuperIntendentId);%>">
                    <%out.print(EmployeeController.printEmployeeOptionsDropDown(EmployeeController.getEmployeeByType("gs")));%>

                </select>
            </label>

        </div>
        <div class="large-4 medium-4 small-12 columns">
            <label>
                Super
                <select name="<%out.print(Constants.projectSuperIntendentId);%>">
                    <%out.print(EmployeeController.printEmployeeOptionsDropDown(EmployeeController.getEmployeeByType("s")));%>

                </select>
            </label>

        </div>
        <div class="large-4 medium-4 small-12 columns">

            <label>
                Foreman
                <select name="<%out.print(Constants.projectForemanId);%>">
                    <%out.print(EmployeeController.printEmployeeOptionsDropDown(EmployeeController.getEmployeeByType("f")));%>

                </select>
            </label>
        </div>

    </div>

    <div class="row">
        <div class="large-12 medium-12 small-12 columns">
            <hr>
            <h4>Project Materials</h4>
        </div>
    </div>
    <div class="row">
        <div class="large-offset-5 medium-offset-5 large-2 medium-2 small-12 columns">
            <button class="expanded hollow button" id="add_material_button">Add Material</button>
        </div>
    </div>

    <div id="material_form">
        <input type="hidden" value="0" id="<% out.print(Constants.projectMaterialNumbers);%>"
               name="<% out.print(Constants.projectMaterialNumbers); %>">
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

<script>

    var materialCounter = 0;

    function createProjectMaterial(number) {
        return (`
        <div class="row">
            <div class="large-3 medium-3 small-12 columns">
                <label>Name</label>
                <input type="text" name="project.material.name[` + number + `]" placeholder="name">
            </div>

            <div class="large-3 medium-3 small-12 columns">
                <label>Type</label>
                <select name="project.material.type[` + number + `]">
                    <option value="">Select</option>
                    <option value="cmu">CMU</option>
                    <option value="brick">Bricks</option>
                    <option value="stucco">Stucco</option>
                    <option value="stone">Stone</option>
                    <option value="concrete">Concrete</option>
                    <option value="scaffolding">Scaffolding</option>
                    <option value="waterproofing">Waterproofing</option>
                    <option value="relieving_angles">Relieving angles</option>
                </select>
            </div>
            <div class="large-2 medium-2 small-12 columns">
                            <label>Total Quantity</label>
                <input type="number" name="project.TotalQuantity[` + number + `]" placeholder="00" value="0">
            </div>


                        <div class="large-2 medium-2 small-12 columns">
                <label>Current Used</label>
                <input type="number" name="project.UsedQuantity[` + number + `]" placeholder="00" value="0">
            </div>
                        <div class="large-1 medium-1 small-12 columns">
                            <label>Unit</label>
                <input type="text" name="project.MaterialUnit[` + number + `]" placeholder="cu.yd" value="0">
            </div>


                        <div class="large-1 medium-1 small-12 columns">
                <label>Total Cost</label>
                <input type="number" step="any" name="project.TotalCost[` + number + `]" placeholder="00.00" value="0">
            </div>
        </div>`
        )
    }
    ;


    document.getElementById("add_material_button").addEventListener("click", function (event) {
        event.preventDefault();
        $(createProjectMaterial(materialCounter)).appendTo($("#material_form"));
        materialCounter = materialCounter + 1;
        $("#<%out.print(Constants.projectMaterialNumbers);%>").val(materialCounter);
    });


</script>
