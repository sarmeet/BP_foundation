<table class="hover">
    <thead>
    <tr>
        <th>
            Start Date
        </th>
        <th>
            Name
        </th>
        <th>
            Total Price
        </th>
        <th>
            Work Done
        </th>
    </tr>
    </thead>
    <tbody>

    <%for (Project project : projects) {%>

    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/view_project?<%out.print(Constants.projectObjectId+"="+project.getId());%>"><%
                out.print(Services.getDisplayFormat(project.getStartDate()));%></a></td>
        <td>
            <a href="${pageContext.request.contextPath}/view_project?<%out.print(Constants.projectObjectId+"="+project.getId());%>"><%
                out.print(project.getName());%></a></td>
        <td><%out.print(0);%></td>
        <td><%out.print(0);%></td>

    </tr>

    <%}%>

    </tbody>

</table>