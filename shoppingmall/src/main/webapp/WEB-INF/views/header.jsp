<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .header {
            background-color: #333;
            color: #fff;
            padding: 15px 0;
            text-align: center;
        }

        .header a {
            color: #fff;
            text-decoration: none;
            margin-right: 20px;
        }

        .header a:hover {
            color: #ddd;
        }

        .header button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .header button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="header">
    <a href="/">메인으로</a>
    <c:choose>
        <c:when test="${loginMember ne null}">
            <span>${loginMember.name} 님 환영합니다. <button onclick="location.href='/logout'">로그아웃</button></span>
        </c:when>
        <c:otherwise>
            <button onclick="location.href='/login'">로그인</button>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>