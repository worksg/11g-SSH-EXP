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
	<form:form id="updateCourseForm" modelAttribute="Course" method="post">
		<table align="center">
			<tr>
				<td><form:label path="cno">课程号 ：</form:label></td>
				<td><form:input path="cno" /></td>
			</tr>

			<tr>
				<td><form:label path="cname">课程名 ：</form:label></td>
				<td><form:input path="cname" /></td>
			</tr>

			<tr>
				<td><form:label path="credit">学分：</form:label></td>
				<td><form:input path="credit" /></td>
			</tr>

			<tr>
				<td><form:label path="tno">教师编号：</form:label></td>
				<td><form:input path="tno" /></td>
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