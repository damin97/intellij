<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="header.jsp"/>
<h2>제품 관리</h2>
<table border="1" cellspacing="0">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
			<th>상세설명</th>
			<th>이미지명</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="prod" items="${productManage}">
			<tr>
				<td>${prod.prodId}</td>
				<td>${prod.prodName}</td>
				<td>${prod.prodPrice}</td>
				<td>${prod.prodDetail}</td>
				<td>${prod.prodImg}</td>
				<td><button onClick='location.href="/updateProductForm?prodId=${prod.prodId}"'>수정</button></td>
				<td><button onClick='location.href="/deleteProduct?prodId=${prod.prodId}"'>삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>