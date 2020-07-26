<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    <title>Employee Registration</title>
    <style type="text/css">
    .errors{
    color:red
    }
    </style>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST" 
          action="addEmployee" modelAttribute="employee">
             <table>
                <tr>
                    <td><form:label path="first_name">FirstName (*)</form:label></td>
                    <td><form:input path="first_name"/>
                    <form:errors path="first_name" cssClass="errors"/>
                    </td>
                </tr>
                 <tr>
                    <td><form:label path="last_name">LastName (*)</form:label></td>
                    <td><form:input path="last_name"/>
                    <form:errors path="last_name" cssClass="errors"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id" value ="1"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">
                     Email (*)</form:label></td>
                    <td><form:input path="email"/>
                        <form:errors path="email" cssClass="errors"/>
                    
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>