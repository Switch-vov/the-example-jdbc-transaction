<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>转账案例</title>
	</head>
	<body>
		<form action="${pageContext.servletContext.contextPath}/AccountServlet" method="post">
			<table border="1" width="50%" align="center" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>收款人</td>
					<td><input type="text" name="to" /></td>
				</tr>
				<tr>
					<td>付款人</td>
					<td><input type="text" name="from" /></td>
				</tr>
				<tr>
					<td>付款金额</td>
					<td><input type="text" name="money" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="转账" /></td>
				</tr>
			</table>
		</form>
	</body>
</html>