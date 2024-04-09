<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello page</h1>
	<form method="post" action="updateProduct">
	<table>
		
			<tr>
				<td><label for="name">번호</label></td>
				<td><input readonly type="text" name="prodId" value="${prod.prodId}"/></td>
			</tr>
			<tr>
				<td><label for="age">이름</label></td>
				<td><input type="text" name="prodName" value="${prod.prodName}"/></td>
			</tr>
			<tr>
				<td><label for="email">가격</label></td>
				<td><input type="text" name="prodPrice" value="${prod.prodPrice}"/></td>
			</tr>
			<tr>
				<td><label for="memo">상세설명</label></td>
				<td><textarea name="prodDetail" cols="20" rows="5">${prod.prodDetail}</textarea></td>
			</tr>
			<tr>
				<td><label for="memo">이미지명</label></td>
				<td><input type="text" name="prodImg" value="${prod.prodImg}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" /></td>
			</tr>
		
	</table>
	</form>
</body>
</html>