<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Confirmation</title>
</head>
<body>
    <h2>Submitted Employee Information</h2>
    <table>
        <tr>
            <td>FirstName :</td>
            <td>${first_name}</td>
        </tr>
           <tr>
            <td>LastName :</td>
            <td>${last_name}</td>
        </tr>
     
        <tr>
            <td>Email :</td>
            <td>${email}</td>
        </tr>
    </table>
</body>
</html>