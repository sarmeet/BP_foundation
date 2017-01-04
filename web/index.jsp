<%@ page import="base.Constants" %>
<%--
  User: sarmeetsingh
  Date: 9/7/16
  Time: 1:44 PM
--%>
<%@include file="static/includes/header.jsp" %>


<div class="row">
    <div class="medium-6 medium-centered large-4 large-centered columns">

        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="login-padding-top"></div>
            <div class="log-in-form">
                <div class="row column ">
                    <h4 class="text-center">Log in with you email account</h4>
                    <label>Email
                        <input type="text" placeholder="somebody@example.com"
                               name="<%out.print(Constants.authUserName);%>">
                    </label>
                    <label>Password
                        <input type="password" placeholder="Password" name="<% out.print(Constants.authPassWord); %>">
                    </label>
                    <input id="remember-me" type="checkbox" name="<% out.print(Constants.authRememberMe); %>">
                    <label for="remember-me">Remember Me</label>
                    <p><input type="submit" class="button expanded"></input></p>
                    <p class="text-center"><a href="#">Forgot your password?</a></p>
                </div>
            </div>
        </form>
    </div>
</div>

<%@include file="static/includes/footer.jsp" %>