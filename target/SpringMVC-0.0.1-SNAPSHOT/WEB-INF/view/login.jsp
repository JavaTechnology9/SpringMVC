<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
        </head>
        <body>
            <form:form id="loginForm" modelAttribute="login" action="loginProcess" method="get">
            <table>
                <tr>
                    <td>userName</td>
                    <td>
                        <form:input path="userName" /> <br />
                        <form:errors path="userName" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>password</td>
                    <td>
                        <form:input type="password" path="password" /> <br />
                        <form:errors path="password" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>

            </form:form>
        </body>

        </html>