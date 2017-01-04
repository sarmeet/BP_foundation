<%@include file="functional/authcheck.jsp" %>

<div class="title-bar" data-responsive-toggle="main-menu" data-hide-for="medium">
    <button class="menu-icon" type="button" data-toggle></button>
    <div class="title-bar-title">Menu</div>
</div>

<div class="top-bar" id="main-menu">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <a href="${pageContext.request.contextPath}/home">
                <li class="menu-text"> Bayport Corp.</li>
            </a>
        </ul>
    </div>
    <div class="top-bar-right">
        <ul class="menu" data-responsive-menu="drilldown medium-dropdown">
            <%if (AuthController.getAccountType(request, Constants.accountTypeProjectManager)) {%>
            <li><a href="${pageContext.request.contextPath}/create_project">Create Project</a></li>

            <li class="has-submenu">
                <a href="${pageContext.request.contextPath}/home">Reports</a>

                <ul class="submenu menu vertical" data-submenu>
                    <li><a href="#">Weekly</a></li>
                    <li><a href="#">Monthly</a></li>
                    <li><a href="#">Cumulative</a></li>
                </ul>
            </li>

            <%}%>


            <%if (AuthController.getAccountType(request, Constants.accountTypeAdministrator)) {%>
            <li><a href="${pageContext.request.contextPath}/create_employee?next_step=create_employee">Create
                Employee</a></li>
            <%}%>


            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>
</div>