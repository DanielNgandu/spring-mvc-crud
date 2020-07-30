<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    <title>Employee Registration</title>
    
<link rel="stylesheet" href="${pageContext.request.contextPath}/assests/css/bootstrap.min.css"/>
<script src="${pageContext.request.contextPath}/assests/js/bootstrap.min.js"></script>   
 
    <style type="text/css">
   
    .errors{
    color:red
    }
    </style>
      <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST" 
          action="addEmployee" modelAttribute="employee">
             <table>
	             <tr>
	                <td><form:label path="id">ID</form:label></td>
	             
                    <td><form:input path="id"/>
	             </tr>
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