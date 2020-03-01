<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body>
            <form:form id="regForm" modelAttribute="register" action="registerProcess" 
            method="post" enctype="multipart/form-data">
                <table>
                <tr>
                    <td>userName</td>
                    <td>
                        <form:input path="username" /> <br />
                        <form:errors path="username" cssClass="error" />
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
                    <td>FirstName</td>
                    <td>
                        <form:input path="firstName" /> <br />
                        <form:errors path="firstName" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>lastName</td>
                    <td>
                        <form:input path="lastName" /> <br />
                        <form:errors path="lastName" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>email</td>
                    <td>
                        <form:input path="email" /> <br />
                        <form:errors path="email" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>address</td>
                    <td>
                        <form:input path="address" /> <br />
                        <form:errors path="address" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>phone</td>
                    <td>
                        <form:input path="phone" /> <br />
                        <form:errors path="phone" cssClass="error" />
                    </td>
                </tr>
                <%-- <tr>
                    <td>Profile Image</td>
                    <td>
                        <form:input type="file" name ="file" path="data" /> <br />
                        <input type="file"  name="file" size = "50"/>
                        <form:errors path="data" cssClass="error" />
                    </td>
                </tr> --%>
                 <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
            </form:form>
               <%--  <form action="savefile" method="post" enctype="multipart/form-data">  
    Select File: <input type="file" name="file"/>  
    <input type="submit" value="Upload File"/>  
    </form> --%>  
        </body>
        </html>