<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add student</title>
</head>
<body>

<h2>Add Student</h2>  
<form action="addrecord" method="post">  
<table>  

<tr><td>Roll no:</td><td><input type="rollno" name="rollno"/></td></tr>
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>  
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>  
<tr><td>Phone no:</td><td><input type="phone" name="phone"/></td></tr>
<tr><td>Date of Birth no:</td><td><input type="dob" name="dob"/></td></tr>

<tr><td>Country:</td><td>  
<select name="country" style="width:150px">  
<option>India</option>  
<option>USA</option>  
<option>UK</option>  
<option>Other</option>  
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="Add Student"/></td></tr>
  
</table>  
</form>  

</body>
</html>