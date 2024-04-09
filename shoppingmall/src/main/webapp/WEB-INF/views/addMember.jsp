<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<div class="col-md-12">
		<div class="col-md-4">
			<form action="/newMember" method="post">
				<div class="form-group">
					<label for="title"> 이름 </label> <input type="text"
						class="form-control" name="name" placeholder="이름을 입력하세요">
				</div>
				<div class="form-group">
					<label for="author"> 아이디 </label> <input type="text"
						class="form-control" name="userId" placeholder="아이디를 입력하세요">
				</div>
				<div class="form-group">
					<label for="author"> 비밀번호 </label> <input type="text"
						class="form-control" name="pw" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="form-group">
					<label for="author"> 주소 </label> <input type="text"
						class="form-control" name="address" placeholder="주소를 입력하세요">
				</div>
				<div class="form-group">
					<label for="author"> 우편번호 </label> <input type="text"
						class="form-control" name="zipcode" placeholder="우편번호를 입력하세요">
				</div>
				<div class="form-group">
					<label for="author"> 생년월일 </label>
					<input type="text" id="year" name="year" maxlength="4" placeholder="태어난 해를 입력하세요">
					<label for="year">년</label>
					<input type="text" id="month" name="month" maxlength="2" placeholder="태어난 달을 입력하세요">
					<label for="month">월</label>
					<input type="text" id="day" name="day" maxlength="2" placeholder="태어난 일을 입력하세요">
					<label for="day">일</label><br>
				</div>
				<a href="/" role="button" class="btn btn-secondary">취소</a> <input
					type="submit" class="btn btn-primary" id="btn-save" value="등록">
			</form>

		</div>
	</div>
</body>
</html>