<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        .container {
            width: 50%; /* 컨테이너의 너비를 설정합니다. */
            margin: 0 auto; /* 좌우 여백을 자동으로 조정하여 가운데 정렬합니다. */
        }
    </style>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container">
    <h1>MY PAGE</h1>
    <p>
        <a href="/myAccount">계정 관리</a>
    </p>
    <p>
        <a href="/myLikes">찜 목록</a><br>
    </p>
    <p>
        <a href="/myShops">장바구니</a>
    </p>
</div>
</body>
</html>