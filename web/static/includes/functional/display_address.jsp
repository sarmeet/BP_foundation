<%@ page import="entity.Address" %>
<% Address address;%>

<div class="row">
    <div class="large-12 medium-12 small-12 columns">
        <hr>
    </div>
</div>

<div class="row">
    <div class="large-12 medium-12 small-12 columns">
        <h5>Address:</h5>
        <%out.print(address.getFirstLine());%> <br>
        <%
            if (address.getSecondLine() != "" || address.getSecondLine() != null) {
                out.print(address.getSecondLine());
            }
        %>
        <%out.print(address.getCity());%> <br>
        <%out.print(address.getState());%>, <%out.print(address.getZip());%><br>
    </div>
</div>