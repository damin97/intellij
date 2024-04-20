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
	<form id="loginForm" action="/loginCheck" method="post">
		아이디: <input type="text" name="userId" placeholder="아이디를 입력하세요"><br/>
		비밀번호: <input type="text" name="pw" placeholder="비밀번호를 입력하세요">
		<button type="submit">로그인</button>
	</form>

</body>
</html>