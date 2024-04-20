<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
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
            <label>제품명</label>
            <label>${prod.prodName}</label>
        </div>
        <div>
            <label>가격</label>
            <label>${prod.prodPrice}</label>
        </div>
        <div>
            <label>상세설명</label>
            <label>${prod.prodDetail}</label>
        </div>
        <div>
            <label>주문수량</label>
            <input type="number" name="count" class="form-control" id="count" placeholder="주문 수량을 입력하세요">
        </div>
        <c:if test="${login}">
            <button id="heart-button" data-prod-id="${prod.prodId}" data-like-click="${like.likeClick}" data-member-id="${like.likeClick}">
                <img src="${like.likeClick ? 'like_fill.png' : 'like_empty.png'}" alt="하트">
            </button>
        </c:if>
            <div><a href="/myShop?prodId=${prod.prodId}">장바구니</a></div>
            <div><a href="#">구매하기</a></div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $('#heart-button').click(function() {
            let likeClick = $(this).data('like-click');
            const prodId = $(this).data('prod-id');

            // likeClick 값을 토글합니다.
            likeClick = !likeClick;

            // 서버로 전송할 데이터
            let data = {
                "likeClick": likeClick,
                "prodId": prodId
            };

            // 서버로 Ajax 요청을 보냅니다.
            $.ajax({
                type: "get",
                url: "/heartClick",
                data: data,
                success: function(res) {
                    console.log("클릭 성공", res);
                    $('#heart-button').data('like-click', res.likeClick);
                    if (res.likeClick) {
                        $('#heart-button img').attr('src', 'like_fill.png');
                    } else {
                        $('#heart-button img').attr('src', 'like_empty.png');
                    }
                },
                error: function(err) {
                    console.error("클릭 실패", err);
                }
            });
        });
    });
</script>
</body>
</html>