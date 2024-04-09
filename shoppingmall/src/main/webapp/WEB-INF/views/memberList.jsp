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
<h2>회원 관리</h2>
<table border="1" cellspacing="0">
            <thead>
            <tr>
                <th>멤버번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>주소</th>
				<th>우편번호</th>
				<th>년</th>
				<th>월</th>
				<th>일</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="member" items="${memberList}">
                <tr>
                    <td>${member.memberId}</td>
                    <td><a href="member?memberId=${member.memberId}">${member.name}</a></td>
                    <td>${member.userId}</td>
                    <td>${member.pw}</td>
                    <td>${member.address}</td>
                    <td>${member.zipcode}</td>
                    <td>${member.year}</td>
                    <td>${member.month}</td>
                    <td>${member.day}</td>
                    <td><button onClick='location.href="/updateMemberForm?memberId=${member.memberId}"'>수정</button></td>
                    <td><button onClick='location.href="/deleteMember?memberId=${member.memberId}"'>삭제</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

</body>
</html>