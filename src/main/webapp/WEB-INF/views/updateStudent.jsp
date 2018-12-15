<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addStudent</title>
</head>
<body>
	<form:form id="updateStudentForm" modelAttribute="Student"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="sno">学号 ：</form:label></td>
				<td><form:input path="sno" /></td>
			</tr>

			<tr>
				<td><form:label path="sname">姓名 ：</form:label></td>
				<td><form:input path="sname" /></td>
			</tr>

			<tr>
				<td><form:label path="ssex">性别：</form:label></td>
				<td><form:radiobutton path="ssex" value="男" />男 <form:radiobutton
						path="ssex" value="女" />女</td>
			</tr>

			<tr>
				<td><form:label path="sbirthday">出生时间[Y-M-D]：</form:label></td>
				<td><form:input path="sbirthday" /></td>
			</tr>

			<tr>
				<td><form:label path="speciality">专业：</form:label></td>
				<td><form:input path="speciality" /></td>
			</tr>

			<tr>
				<td><form:label path="sclass">班号：</form:label></td>
				<td><form:input path="sclass" /></td>
			</tr>

			<tr>
				<td><form:label path="tc">总学分：</form:label></td>
				<td><form:input path="tc" /></td>
			</tr>

			<tr>
				<td></td>
				<td align="left"><form:button id="login" name="login">修改</form:button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>