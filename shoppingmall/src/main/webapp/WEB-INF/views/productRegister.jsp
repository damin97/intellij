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
<h1>제품등록</h1>

<div class="col-md-12">
    <div class="col-md-4">
        <form action="/new" method="post">
            <div class="form-group">
                <label for="title"> 제품명 </label>
                <input type="text" class="form-control" name="prodName" placeholder="제품명을 입력하세요">
            </div>
            <div class="form-group">
                <label for="author"> 가격 </label>
                <input type="text" class="form-control" name="prodPrice" placeholder="가격를 입력하세요">
            </div>
            <div class="form-group">
                <label for="author"> 상세설명 </label>
                <input type="text" class="form-control" name="prodDetail" placeholder="상세설명을 입력하세요">
            </div>
            <div class="form-group">
            	<label for="productImage">제품 이미지:</label>
                <input type="file" name="prodImg" accept="image/*">
            </div>
            <a href="/" role="button" class="btn btn-secondary">취소하기</a>
        	<input type="submit" class="btn btn-primary" id="btn-save" value="등록하기">
        </form>
    </div>
</div>
</body>
</html>