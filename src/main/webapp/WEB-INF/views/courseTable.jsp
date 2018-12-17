<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="table-responsive">
	<table class="table table-bordered table-dark table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>课程号</th>
				<th>课程名</th>
				<th>学分</th>
				<th>教师编号</th>
				<th>功能</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>${item.cno}</td>
				<td>${item.cname}</td>
				<td>${item.credit}</td>
				<td>${item.tno}</td>
				<td>
					<div class="btn-group">
						<form action="<%=request.getContextPath()%>/course/update">
							<input type="text" name="id" value="${item.cno}" hidden />
							<button type="submit"
								class="btn btn-outline-warning btn-rounded btn-fw btn-sm">修改</button>
						</form>
						<form action="<%=request.getContextPath()%>/course/delete"
							method="post">
							<input type="text" name="id" value="${item.cno}" hidden />
							<button type="submit"
								class="btn btn-outline-danger btn-rounded btn-fw btn-sm">删除</button>
						</form>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>