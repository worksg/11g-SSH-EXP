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
	<form:form id="addScoreForm" modelAttribute="Score" method="post">
		<table align="center">
			<tr>
				<td><form:label path="sno">学号 ：</form:label></td>
				<td><form:input path="sno" /></td>
			</tr>

			<tr>
				<td><form:label path="cno">课程号 ：</form:label></td>
				<td><form:input path="cno" /></td>
			</tr>

			<tr>
				<td><form:label path="grade">成绩：</form:label></td>
				<td><form:input path="grade" /></td>
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