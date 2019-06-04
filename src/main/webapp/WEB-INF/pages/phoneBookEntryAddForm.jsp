<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>
<head>
    <title>Add PhoneBook Entry Form</title> 
    <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
 
<body>
    <h2><spring:message code="lbl.page" text="Add New PhoneBook" /></h2>
    <br/>
    <form:form method="post" modelAttribute="phonebook">
        <table>
            <tr>
                <td><spring:message code="lbl.name" text="Name" /></td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.phoneNumber" text="Phone Number" /></td>
                <td><form:input path="phoneNumber" /></td>
                <td><form:errors path="phoneNumber" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="save"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>