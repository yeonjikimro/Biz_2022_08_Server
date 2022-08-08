<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
		<th>작성 일자</th>
		<th>작성 시간</th>
		<th>내용</th>
		<th>완료 일자</th>
		<th>완료 시간</th>
	</tr>
		<c:forEach items="${todoList}" var="todo">
	<tr>
		<td>${todo.insert_date }</td>
		<td>${todo.insert_time }</td>
		<td>${todo.context }</td>
		<td>${todo.comp_date }</td>
		<td>${todo.comp_time }</td>
		<td>완료</td>
		
	</tr>
		</c:forEach>	
	</table>

	<form:form>
		<div>
			<input name="context" placeholder="해야할 일">
		</div>
		<div>
			<button>입력</button>
		</div>
	</form:form>
</body>
</html>