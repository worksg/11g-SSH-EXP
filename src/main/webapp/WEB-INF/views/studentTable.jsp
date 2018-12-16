<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="table-responsive">
	<table class="table table-bordered table-dark table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>专业</th>
				<th>班号</th>
				<th>总学分</th>
				<th>功能</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>${item.sno}</td>
				<td>${item.sname}</td>
				<td>${item.ssex}</td>
				<td>${item.sbirthday}</td>
				<td>${item.speciality}</td>
				<td>${item.sclass}</td>
				<td>${item.tc}</td>
				<td>
					<div class="btn-group">
						<form action="<%=request.getContextPath()%>/student/update">
							<input type="text" name="id" value="${item.sno}" hidden />
							<button type="submit"
								class="btn btn-outline-warning btn-rounded btn-fw btn-sm">修改</button>
						</form>
						<form action="<%=request.getContextPath()%>/student/delete"
							method="post">
							<input type="text" name="id" value="${item.sno}" hidden />
							<button type="submit"
								class="btn btn-outline-danger btn-rounded btn-fw btn-sm">删除</button>
						</form>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>