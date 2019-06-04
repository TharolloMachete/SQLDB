<html>
    <head>
        <title>Add PhoneBook Success</title>
        <%@ page isELIgnored="false" %>
    </head>
    <body>
    <form:form modelAttribute="phonebook">
          "${phonebook.toString()} has been added successfully"   
    </form:form>
    </body>
</html>