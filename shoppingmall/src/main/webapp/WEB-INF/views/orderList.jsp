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
<h2>주문 내역</h2>
<table border="1" cellspacing="0">
            <thead class="thead-strong">
            <tr>
                <th>번호</th>
                <th>고객명</th>
                <th>상품명</th>
                <th>수량</th>
            </tr>
            </thead>
            <tbody id="tbody">
            <c:forEach var="order" items="${orderList}">
                <tr>
                    <td>${order.orderId}</td>
                    <td><a href="order?orderId=${order.orderId}">${order.memberId}</a></td>
                    <td>${order.prodName}</td>
                    <td>${order.count}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/" role="button" class="btn btn-secondary">처음으로</a>
</body>
</html>