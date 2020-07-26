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
                    <td><form:label path="name">Name (*)</form:label></td>
                    <td><form:input path="name"/>
                    <form:errors path="name" cssClass="errors"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="contactNumber">
                      Contact Number (*)</form:label></td>
                    <td><form:input path="contactNumber"/>
                        <form:errors path="contactNumber" cssClass="errors"/>
                    
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>