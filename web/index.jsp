<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>
</head>
<style>
div.ex {
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>
<body>
	<h1>Student Data Register</h1>
	<div class="ex">
		<form action="AddStudent" method="post">
                    <p>Send the details<p>
			<table style="with: 50%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="Name" /></td>
				</tr>
                                <tr>
					<td>Score</td>
					<td><input type="text" name="Score" /></td>
				</tr>
			</table>
			<input type="submit" value="register"/>
                </form>       
	</div>
        <div class="ex">
		<form action="History" method="post">
                    <p>Enter details to check student growth<p>
			<table style="with: 50%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="Name" /></td>
				</tr>
			</table>
			<input type="submit" value="register"/>
                </form>       
	</div>
</body>
</html>