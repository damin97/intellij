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
<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th>멤버번호</th>
        <th>이메일</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>등록일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="member" items="${memberList}">
        <tr>
            <td>${member.id}</td>
            <td>${member.email}</td>
            <td>${member.password}</td>
            <td>${member.name}</td>
            <td>${member.registerDateTime}</td>
            <td><button onClick='location.href="/updateMemberForm?memberId=${member.id}"'>수정</button></td>
            <td><button onClick='location.href="/deleteMember?memberId=${member.id}"'>삭제</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>