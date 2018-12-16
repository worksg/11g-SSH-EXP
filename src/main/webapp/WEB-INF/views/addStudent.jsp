<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>学生成绩管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.min.css">
<!-- <link rel="stylesheet" type="text/css" media="screen" href="main.css" /> -->
</head>
<body>
	<div class="container-scroller">
		<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/student">学生成绩管理系统</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<!-- <li class="nav-item">
                        <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                            <span class="menu-title">Basic UI Elements</span>
                        </a>
                        <div class="collapse" id="ui-basic">
                            <ul class="nav flex-column sub-menu">
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Buttons</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Typography</a>
                                </li>
                            </ul>
                        </div>
                    </li> -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="javascript:;"
						id="navbardrop" data-toggle="dropdown">学生模块 </a>
						<div class="dropdown-menu">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/student/list">全部学生信息</a> <a
								class="dropdown-item"
								href="<%=request.getContextPath()%>/student/search">查询学生信息</a> <a
								class="dropdown-item"
								href="<%=request.getContextPath()%>/student/add">增加学生信息</a>
							<!-- <a class="dropdown-item" href="./student/update">修改学生信息</a> -->
							<!-- <a class="dropdown-item" href="./student/delete">删除学生信息</a> -->
						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="javascript:;"
						id="navbardrop" data-toggle="dropdown"> 课程模块 </a>
						<div class="dropdown-menu">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/course/list">全部课程信息</a> <a
								class="dropdown-item"
								href="<%=request.getContextPath()%>/course/search">查询课程信息</a> <a
								class="dropdown-item"
								href="<%=request.getContextPath()%>/course/add">增加课程信息</a>
							<!-- <a class="dropdown-item" href="./course/update">修改课程信息</a> -->
							<!-- <a class="dropdown-item" href="./course/delete">删除课程信息</a> -->
						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="javascript:;"
						id="navbardrop" data-toggle="dropdown"> 成绩模块 </a>
						<div class="dropdown-menu">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/score/list">全部成绩信息</a> <a
								class="dropdown-item"
								href="<%=request.getContextPath()%>/score/search">查询成绩信息</a> <a
								class="dropdown-item"
								href="<%=request.getContextPath()%>/score/add">增加成绩信息</a>
							<!-- <a class="dropdown-item" href="./score/update">修改成绩信息</a> -->
							<!-- <a class="dropdown-item" href="./score/delete">删除成绩信息</a> -->
						</div></li>
				</ul>
			</div>
		</nav>

		<div class="container-fluid page-body-wrapper">
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col">
							<div class="card">
								<div class="card-body">
									<h3 class="card-title">增加学生信息</h3>
									<form:form id="addStudentForm" modelAttribute="Student"
										method="post">
										<div class="form-group">
											<form:label path="sno">学号</form:label>
											<form:input type="text" class="form-control" path="sno" />
										</div>
										<div class="form-group">
											<form:label path="sname">姓名</form:label>
											<form:input type="text" class="form-control" path="sname" />
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col">
													<form:label path="ssex">性别</form:label>
												</div>
												<div class="col">
													<div class="custom-control custom-radio">
														<form:radiobutton class="custom-control-input"
															id="Radios1" path="ssex" value="男" />
														<label class="custom-control-label" for="Radios1">
															男</label>
													</div>
												</div>
												<div class="col">
													<div class="custom-control custom-radio">
														<form:radiobutton class="custom-control-input"
															id="Radios2" path="ssex" value="女" />
														<label class="custom-control-label" for="Radios2">
															女 </label>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<form:label path="sbirthday">出生时间[YYYY-MM-DD]</form:label>
											<form:input type="text" class="form-control" path="sbirthday" />
										</div>
										<div class="form-group">
											<form:label path="speciality">专业</form:label>
											<form:input type="text" class="form-control"
												path="speciality" />
										</div>
										<div class="form-group">
											<form:label path="sclass">班号</form:label>
											<form:input type="text" class="form-control" path="sclass" />
										</div>
										<div class="form-group">
											<form:label path="tc">总学分</form:label>
											<form:input type="text" class="form-control" path="tc" />
										</div>
										<div class="col d-flex justify-content-center">
											<form:button type="submit" class="btn btn-primary btn-block">增加</form:button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"
		async defer></script>
	<!-- User Defined Script BEGIN -->
	<!-- END -->
</body>
</html>