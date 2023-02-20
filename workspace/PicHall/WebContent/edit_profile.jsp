<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>PicHall 회원정보 수정</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/edit_profile.css" />

<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<c:set var="memberBean" value="${requestScope.memberBean}"/>

	<!-- Main -->
	<div id="main">

		<!-- Post -->
		<section class="post">
			<header class="major">
				<h3 style="font-size: 2rem">
					<a href="${pageContext.request.contextPath}/index.jsp">PicHall</a><br style="display:block">회원정보 수정
				</h3>
			</header>
			<hr>

			<div class="row gtr-uniform">
					<table style="table-layout:fixed">
						<colgroup>
							<col style="width: 25%" />
							<col style="width: 75%" />
						</colgroup>
						<tr>
							<th>프로필 사진 변경</th>
							<td>
								<form method="post" action="${pageContext.request.contextPath}/member/MemberEditProfilePicOk.me"
									enctype="multipart/form-data" name="profilePicForm">
									<input type="hidden" name="key" value="profilePic"/>
									<input type="file" class="button" name="profile_pic"> 
									<input type="submit" class="okay_btn" id="profile_okay_btn" value="확인" style="float: right;">
								</form>
							</td>
						</tr>
						<tr>
							<th>비밀번호 변경</th>
							<td>
								<form method="post" action="${pageContext.request.contextPath}/member/MemberEditProfileOk.me"
								name="passwordForm">
									<input type="hidden" name="key" value="pw"/>
									현재 비밀번호 : <input type="password" name="password" class="edit_profile_input" value="" /> 
									새 비밀번호 : <input type="password" name="new_member_pw" class="edit_profile_input" value="" /> 
									비밀번호 다시 입력 : <input type="password" name="new_member_pw_re" class="edit_profile_input" value="" />
									<a href="javascript:formSubmit()" class="button" id="sign_up_btn" style="float: right; margin-top: 0.5rem">확인</a>
								</form>
							</td>
						</tr>
						<tr>
							<th>닉네임 변경</th>
							<td>
								<form method="post" action="${pageContext.request.contextPath}/member/MemberEditProfileOk.me"
								name="nicknameForm">
									<input type="hidden" name="key" value="nickname"/>
									새 닉네임 : <input type="text" name="new_member_nickname" class="edit_profile_input" value="${memberBean.getMember_nickname()}" /> 
									<input type="submit" value="확인" style="float: right; margin-top: 0.5rem" class="okay_btn">
								</form>
							</td>
						</tr>
						<tr>
							<th>작가소개 변경</th>
							<td>
								<form method="post" action="${pageContext.request.contextPath}/member/MemberEditProfileOk.me"
								name="textForm">
									<input type="hidden" name="key" value="text"/>
									<div class="col-12">
										<textarea name="new_member_text" id="demo-message"
											rows="6"
											style="resize: none">${memberBean.getMember_text()}</textarea>
										<input type="submit" value="확인"
											style="float: right; margin-top: 0.5rem" class="okay_btn">
									</div>
								</form>
							</td>
						</tr>
					</table>

			</div>
			
			<a href="${pageContext.request.contextPath}/member/MemberQuit.me"
				style="float: right; color: red; font-size: 1em">회원 탈퇴하기</a>
		</section>

	</div>

</body>
<!-- Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<!-- 비밀번호 설정 부분 확인 -->
<script src="${pageContext.request.contextPath}/app/member/edit_profile.js"></script>
</html>