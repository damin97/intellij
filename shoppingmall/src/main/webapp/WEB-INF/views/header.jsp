<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더 가운데 정렬</title>
<style>
.header {
    text-align: center; /* 텍스트를 가운데 정렬합니다. */
    padding: 10px; /* 상하좌우 여백을 추가합니다. */
    background-color: #f1f1f1; /* 배경색을 지정합니다. */
}
</style>
</head>
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