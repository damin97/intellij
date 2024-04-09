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
<h1>제품 주문</h1>
<div class="col-md-12">
    <div class="col-md-4">
        <form role="form" action="/newOrder" method="post">
        <div class="form-group">
            <label for="member">주문회원</label>
            <select name="memberId" id="member" class="form-control">
                <option value="">회원선택</option>
                <c:forEach var="member" items="${memberList}">
                <option value="${member.memberId}">${member.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="item">제품명</label>
            <select name="prodName" id="item" class="form-control">
                <option value="">제품선택</option>
                <c:forEach var="prod" items="${productList}">
                <option value="${prod.prodName}">${prod.prodName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="count">주문수량</label>
            <input type="number" name="count" class="form-control" id="count" placeholder="주문 수량을 입력하세요">
        </div>
		<a href="/" role="button" class="btn btn-secondary">취소</a>
        <button type="submit" class="btn btn-primary">Submit</button>
    	</form>
    </div>
</div>
</body>
</html>