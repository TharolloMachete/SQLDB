
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>View Phone Book Entries</h1>
    <%@ page isELIgnored="false" %>
    <form:form method="post" modelAttribute="phonebook">
		<table border="2" width="70%" cellpadding="2">
			<tr><th>Name</th><th>Phone Number</th></tr>
		    <c:forEach items="${phonebook.getPhoneBookList()}" var="pb">
			  <tr>
			    <td><c:out value="${pb.name}"/></td>
			    <td><c:out value="${pb.phoneNumber}"/></td>
			  </tr>
			</c:forEach>
	  </table>
    </form:form>
  