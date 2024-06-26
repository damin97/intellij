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
    <h1>SHOPPING MALL</h1>
    <p>
        <a href="/introduce">About Porke</a>
    </p>
    <p>
        <a href="/lookbook">LookBook</a>
    </p>
    <p>회원 기능</p>
    <p>
        <a href="/members/new">회원 가입</a><br>
        <c:choose>
            <c:when test="${sessionScope.isAdmin eq true}">
                <a href="/members">회원 관리</a><br>
            </c:when>
            <c:otherwise>
                <!-- 관리자가 아닌 경우, 링크를 표시하지 않습니다. -->
            </c:otherwise>
        </c:choose>
        <a href="/myPage">마이페이지</a>
    </p>
    <p>제품 기능</p>
    <p>
        <a href="/items">제품 목록</a><br>
        <c:choose>
            <c:when test="${sessionScope.isAdmin eq true}">
                <a href="/items/new">제품 등록</a><br>
                <a href="/items/manage">제품 관리</a>
            </c:when>
            <c:otherwise>
                <!-- 관리자가 아닌 경우, 링크를 표시하지 않습니다. -->
            </c:otherwise>
        </c:choose>
    </p>
    <p>주문 기능</p>
    <p>
        <a href="/order">제품 주문</a><br>
        <c:choose>
            <c:when test="${sessionScope.isAdmin eq true}">
                <a href="/orders">주문 내역</a>
            </c:when>
            <c:otherwise>
                <!-- 관리자가 아닌 경우, 링크를 표시하지 않습니다. -->
            </c:otherwise>
        </c:choose>

    </p>
</div>
</body>
</html>