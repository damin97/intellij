<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script type="text/javascript">
        // 에러 메시지를 팝업창으로 표시하는 함수
        function showErrorPopup(errorMessage) {
            alert(errorMessage); // 팝업창에 에러 메시지를 표시합니다.
        }

        // 페이지 로드 시 실행되는 함수
        window.onload = function() {
            <%-- 에러 메시지가 존재할 경우 showErrorPopup 함수를 호출하여 팝업창을 표시합니다. --%>
            if (error != null) {
            showErrorPopup(${error});
            }
        };
    </script>
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
            <div>
                <button onclick="addToCart()">장바구니 담기</button>
            </div>
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

    var login = ${login};
    var prodId = ${prod.prodId};

    function addToCart() {
        // count 값을 가져옵니다.
        var count = parseInt(document.getElementById('count').value);

        $.ajax({
            type: "GET",
            url: "/toMyShop",
            data: {
                prodId: prodId,
                count: count
            },
            success: function(response) {
                if(login === false) {
                    alert("로그인 후 이용 가능합니다."); // 에러 메시지 알림 창 표시
                } else {
                    alert("상품이 장바구니에 추가되었습니다."); // 성공 알림 창 표시
                    location.reload();
                }
            },
            error: function(xhr, status, error) {
                // AJAX 요청이 실패했을 때 처리할 동작을 여기에 작성합니다.
                alert("상품을 추가하는 도중 오류가 발생했습니다: " + error); // 오류 알림 창 표시
            }
        });
    }
</script>
</body>
</html>