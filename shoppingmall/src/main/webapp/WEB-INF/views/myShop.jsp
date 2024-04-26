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
        <th>이미지</th>
        <th>제품명</th>
        <th>가격</th>
        <th>상세설명</th>
        <th>수량</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody id="tbody">
    <c:forEach var="shop" items="${shopList}">
        <tr>
            <td>${shop.shopId}</td>
            <td><img src="${shop.prodImg}" width="100px"></td>
            <td><a href="productDetail?prodId=${shop.prodId}">${shop.prodName}</a></td>
            <td>${shop.prodPrice}</td>
            <td>${shop.prodDetail}</td>
            <td>${shop.count}</td>
            <td><button onclick="location.href='/deleteShop?prodId=${shop.prodId}&memberId=${shop.memberId}'">삭제</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/" role="button" class="btn btn-secondary">처음으로</a>
</body>
</html>