<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.StudentBean"%>
<%
StudentBean studentBean = (StudentBean) request.getAttribute("StudentBean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel="stylesheet" type="text/css" href="./css/result.css">
</head>
<body>
	<div class="result">
		<%
		if (studentBean != null) {
		%>
		<div class="header">
			<h1>検索結果</h1>
			<p>下記の情報を確認して、生徒に対して真摯に向き合いましょう！ 頑張ってください。</p>
		</div>
		<table>
			<tr>
				<th>ID</th>
				<td><%=studentBean.getId()%></td>
			</tr>

			<tr>
				<th>名前</th>
				<td><%=studentBean.getName()%></td>
			</tr>

			<tr>
				<th>性別</th>
				<td><%=studentBean.getGender()%></td>
			</tr>

			<tr>
				<th>住所</th>
				<td><%=studentBean.getAddres()%></td>
			</tr>

			<tr>
				<th>連絡先</th>
				<td><%=studentBean.getContact()%></td>
			</tr>

			<tr>
				<th>電話番号</th>
				<td><%=studentBean.getTel()%></td>
			</tr>

			<tr>
				<th>学校名</th>
				<td><%=studentBean.getSchool()%></td>
			</tr>

			<tr>
				<th>学校区分</th>
				<td><%=studentBean.getClassification()%></td>
			</tr>

			<tr>
				<th>学年</th>
				<td><%=studentBean.getSchool_year()%></td>
			</tr>

			<tr>
				<th>得意教科</th>
				<td><%=studentBean.getGood_subject()%></td>
			</tr>

			<tr>
				<th>苦手教科</th>
				<td><%=studentBean.getWeak_subject()%></td>
			</tr>

			<tr>
				<th>趣味</th>
				<td><%=studentBean.getHobby()%></td>
			</tr>

			<tr>
				<th>特徴</th>
				<td><%=studentBean.getFeature()%></td>
			</tr>

			<tr>
				<th>指導における注意点</th>
				<td><%=studentBean.getImportant_point()%></td>
			</tr>

			<tr>
				<th>教材の有無</th>
				<td><%=studentBean.getTeach_material()%></td>
			</tr>

			<tr>
				<th>LoginTime</th>
				<td><%=studentBean.getLogin_Time()%></td>
			</tr>
		</table>

		<%
		} else {
		%>
		<p>IDもしくはパスワードが間違っています。開示できません。</p>
		<%
		}
		%>
	</div>
</body>
</html>