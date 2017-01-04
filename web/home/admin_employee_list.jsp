<table class="hover">
    <thead>
    <tr>
        <th>
            Employee Id
        </th>
        <th>
            Name
        </th>
        <th>
            Position
        </th>
        <th>
            Pay Scale
        </th>

        <th>
            Phone Number
        </th>
        <th>
            Email
        </th>
    </tr>
    </thead>
    <tbody>
    <%for (Employee employee : employees) {%>
    <tr>
        <td>
            <% out.print(employee.getEmployeeId().toString());%>
        </td>
        <td>
            <% out.print(employee.getPerson().getName());%>
        </td>
        <td>
            <% String title = employee.getJobTitle();
                if (title.equals(Constants.accountTypeAdministrator)) {
                    out.println("Site Administrator");
                }
                if (title.equals(Constants.accountTypeAssistantProjectManager)) {
                    out.println("Assistant Project Manager");
                }
                if (title.equals(Constants.accountTypeProjectManager)) {
                    out.println("Project Manager");
                }
                if (title.equals(Constants.accountTypeGeneralSuper)) {
                    out.println("General Super");
                }
                if (title.equals(Constants.accountTypeSuper)) {
                    out.println("Site Super");
                }
                if (title.equals(Constants.accountTypeForeman)) {
                    out.println("Site Foreman");
                }
                if (title.equals(Constants.accountTypeMason)) {
                    out.println("Mason");
                }
                if (title.equals(Constants.accountTypeLabourer)) {
                    out.println("Labourer");
                }

            %>
        </td>


        <td>
            <% out.print(employee.getPayScale().toString());%>
            <% char paytype = (employee.getPayscaleType());

                if (paytype == 'h') {
                    out.print(" /hour");
                }
                if (paytype == 'w') {
                    out.print(" /Week");
                }
            %>
        </td>

        <td>
            <%
                out.print(employee.getPerson().getPhoneNumber());
            %>
        </td>


        <td>
            <%
                out.print(employee.getPerson().getEmail());
            %>
        </td>


        <%}%>

    </tr>
    </tbody>
</table>