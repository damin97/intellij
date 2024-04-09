<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .products {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between; /* 아이템을 균등하게 배치 */
            list-style: none;
            padding: 50px;
            margin: 0 100px; /* 좌우 마진 추가 */
        }
        .product {
            width: 300px; /* 가로 공간을 균등하게 나누기 위해 30%로 설정 */
            margin-bottom: 50px;
            border: 1px solid #eee;
            border-radius: 5px;
            padding: 10px;
            box-sizing: border-box;
        }
        .product img {
            width: 100%;
            height: auto;
            border-top-left-radius: 4px;
            border-top-right-radius: 4px;
            border-bottom-left-radius: 4px;
            border-bottom-right-radius: 4px;
        }
        .product h3, .product p {
            margin: 10px;
        }
        h2 {
            text-align: center; /* 텍스트를 가운데로 정렬 */
        }
</style>
</head>
<body>
<c:import url="header.jsp"/>
<h2>상품 리스트</h2>
        <div class="products">
            <c:forEach var="prod" items="${productList}">
            <div class="product">
            	<a href="productDetail?prodId=${prod.prodId}">
                <img src="${prod.prodImg}" alt="상품 이미지" width="300" height="300">
                <h3>${prod.prodName}</h3>
                </a>
                <p>${prod.prodPrice}</p>
            </div>
            </c:forEach>
        </div>
</body>
</html>