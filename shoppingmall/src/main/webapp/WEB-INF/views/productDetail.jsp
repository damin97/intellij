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
<h2>상품 리스트</h2>
<div class="card">
    <div>
        <img src="${prod.prodImg}" width="300px" height="300px">
    </div>
    <div>
        <div>
            <label for="prodName">제품명</label>
            <label for="prodName">${prod.prodName}</label>
        </div>
        <div>
            <label for="prodPrice">가격</label>
            <label for="prodPrice">${prod.prodPrice}</label>
        </div>
        <div>
            <label for="prodDetail">상세설명</label>
            <label for="prodDetail">${prod.prodDetail}</label>
        </div>
        <div>
            <label for="count">주문수량</label>
            <input type="number" name="count" class="form-control" id="count" placeholder="주문 수량을 입력하세요">
        </div>
        <div>
            <div><a href="#">장바구니</a></div>
            <div><a href="#">바로구매</a></div>
        </div>
    </div>
</div>
</body>
</html>