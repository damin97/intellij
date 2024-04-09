<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LookBook</title>
    <style>
        .gallery {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between; /* 아이템을 균등하게 배치 */
            list-style: none;
            padding: 50px;
            margin: 0 400px; /* 좌우 마진 추가 */
        }
        .gallery-item {
            width: 30%; /* 가로 공간을 균등하게 나누기 위해 30%로 설정 */
            margin-bottom: 50px;
            border: 1px solid #eee;
            border-radius: 5px;
            padding: 10px;
            box-sizing: border-box;
        }
        .gallery-item img {
            width: 100%;
            height: auto;
            border-top-left-radius: 4px;
            border-top-right-radius: 4px;
            border-bottom-left-radius: 4px;
            border-bottom-right-radius: 4px;
        }
        .popup {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.6); /* 반투명한 배경색 */
            z-index: 999; /* 팝업창을 가장 위로 올리기 */
        }
        .popup-content {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        .popup-img {
            max-width: 90%;
            max-height: 90%;
        }
    </style>
</head>
<body>
<c:import url="header.jsp"/>
    <div class="gallery">
        <div class="gallery-item">
            <img src="lookbook1.jpg" alt="이미지 1">
        </div>
        <div class="gallery-item">
            <img src="lookbook2.jpg" alt="이미지 2">
        </div>
        <div class="gallery-item">
            <img src="lookbook3.jpg" alt="이미지 3">
        </div>
        <div class="gallery-item">
            <img src="lookbook4.jpg" alt="이미지 4">
        </div>
        <div class="gallery-item">
            <img src="lookbook5.jpg" alt="이미지 5">
        </div>
        <div class="gallery-item">
            <img src="lookbook6.jpg" alt="이미지 6">
        </div>
    </div>
    
    <div class="popup" id="popup">
        <div class="popup-content">
            <img src="" alt="" class="popup-img">
        </div>
    </div>

    <script>
        // JavaScript로 이미지를 클릭할 때 팝업 창을 열도록 설정합니다.
        const galleryItems = document.querySelectorAll('.gallery-item img');
        const popup = document.getElementById('popup');
        const popupImg = document.querySelector('.popup-img');

        galleryItems.forEach(item => {
            item.addEventListener('click', () => {
                // 클릭된 이미지의 src와 alt를 팝업창의 이미지에 설정합니다.
                popupImg.src = item.src;
                popupImg.alt = item.alt;
                // 팝업 창을 화면에 표시합니다.
                popup.style.display = 'block';
            });
        });

        // 팝업 창 외부를 클릭하면 팝업 창을 닫도록 설정합니다.
        popup.addEventListener('click', () => {
            popup.style.display = 'none';
        });
    </script>
</body>
</html>