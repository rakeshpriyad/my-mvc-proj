<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit Student </title>
		<style type="text/css">
			.error {
				color: red;
			}
			table {
				width: 50%;
				border-collapse: collapse;
				border-spacing: 0px;
			}
			table td {
				border: 1px solid #565454;
				padding: 20px;
			}
		</style>
	</head>
	<body>
		<h1>Student Intro Form</h1>
		<form:form action="addStudent" method="post" modelAttribute="student">
			<table>
				<tr>
					<td>StudentId</td>
					<td>
						<form:input path="studId" /> <br />
						<form:errors path="studId" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>
						<form:input path="name" /> <br />
						<form:errors path="name" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Fathers Name</td>
					<td>
						<form:input path="fName" /> <br />
						<form:errors path="fName" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>DOB</td>
					<td>
						<form:input path="dob" /> <br />
						<form:errors path="dob" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Course</td>
					<td>
						<form:input path="course" /> <br />
						<form:errors path="course" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Addr</td>
					<td>
						<form:input path="addr" /> <br />
						<form:errors path="addr" cssClass="error" />
					</td>
				</tr>
				
				<tr>
					<td>Email</td>
					<td>
						<form:input path="email" /> <br />
						<form:errors path="email" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Mob</td>
					<td>
						<form:input path="mob" /> <br />
						<form:errors path="mob" cssClass="error" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2"><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form:form>
		
		<h2>Students List</h2>
		<table>
			<tr>
				<td><strong>StudId</strong></td>
				<td><strong>Name</strong></td>
				<td><strong>FName</strong></td>
				<td><strong>Dob</strong></td>
				<td><strong>Course</strong></td>
				<td><strong>Addr</strong></td>
				<td><strong>Email</strong></td>
				<td><strong>Mob</strong></td>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.studId}</td>
					<td>${student.name}</td>
					<td>${student.fName}</td>
					<td>${student.dob}</td>
					<td>${student.course}</td>
					<td>${student.addr}</td>
					<td>${student.email}</td>
					<td>${student.mob}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>