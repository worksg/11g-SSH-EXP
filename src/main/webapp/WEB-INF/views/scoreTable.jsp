<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="table-responsive">
	<table class="table table-bordered table-dark table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>学号</th>
				<th>课程号</th>
				<th>成绩</th>
				<th>功能</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>${item.sno}</td>
				<td>${item.cno}</td>
				<td>${item.grade}</td>
				<td>
					<div class="btn-group">
						<form action="<%=request.getContextPath()%>/score/update">
							<input type="text" name="sid" value="${item.sno}" hidden /> <input
								type="text" name="cid" value="${item.cno}" hidden />
							<button type="submit"
								class="btn btn-outline-warning btn-rounded btn-fw btn-sm">修改</button>
						</form>
						<form action="<%=request.getContextPath()%>/score/delete"
							method="post">
							<input type="text" name="sid" value="${item.sno}" hidden /> <input
								type="text" name="cid" value="${item.cno}" hidden />
							<button type="submit"
								class="btn btn-outline-danger btn-rounded btn-fw btn-sm">删除</button>
						</form>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>