<%@ page import="Controller.AuthController" %>
<%

    if (AuthController.getLoggedInEmployee(request) == null)
        response.sendRedirect(getServletConfig().getServletContext().getContextPath().concat("/home"));

%>