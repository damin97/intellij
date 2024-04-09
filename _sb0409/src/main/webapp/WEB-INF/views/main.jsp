<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>메인</title>
</head>
<body>
    <p>환영합니다.</p>
    <h2>${value1}</h2>
    <h2>${value2}</h2>
    <p><a href="<c:url value="/register/step1" />">[회원 가입하기]</a>
    <p><a href="<c:url value="/member/memberList" />">[회원 목록보기]</a>
</body>
</html>
