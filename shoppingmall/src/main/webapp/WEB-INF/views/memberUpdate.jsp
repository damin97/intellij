<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        /* CSS를 사용하여 입력 필드의 너비 조절 */
        input[type="text"] {
            width: 400px; /* 원하는 너비로 조절 */
        }
    </style>
</head>
<body>
<h1>Hello page</h1>
<form method="post" action="updateMember">
    <table>

        <tr>
            <td><label for="id">멤버번호</label></td>
            <td><input readonly type="text" name="memberId" value="${member.memberId}"/></td>
        </tr>
        <tr>
            <td><label for="name">이름</label></td>
            <td><input type="text" name="name" value="${member.name}"/></td>
        </tr>
        <tr>
            <td><label for="userId">아이디</label></td>
            <td><input readonly type="text" name="userId" value="${member.userId}"/></td>
        </tr>
        <tr>
            <td><label for="pw">비밀번호</label></td>
            <td><input type="text" name="pw" value="${member.pw}"/></td>
        </tr>
        <tr>
            <td><label for="address">주소</label></td>
            <td><input type="text" name="address" value="${member.address}"/></td>
        </tr>
        <tr>
            <td><label for="zipcode">우편번호</label></td>
            <td><input type="text" name="zipcode" value="${member.zipcode}"/></td>
        </tr>
        <tr>
            <td><label for="year">출생년도</label></td>
            <td><input type="text" name="year" value="${member.year}"/></td>
        </tr>
        <tr>
            <td><label for="month">출생월</label></td>
            <td><input type="text" name="month" value="${member.month}"/></td>
        </tr>
        <tr>
            <td><label for="day">출생일</label></td>
            <td><input type="text" name="day" value="${member.day}"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" /></td>
        </tr>

    </table>
</form>
</body>
</html>