<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>PicHall 로그인</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/login.css" />
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>

</head>
<body class="is-preload">
	<c:if test="${not empty param.login}">
		<c:if test="${not param.login}">
			<script>
				alert("아이디 또는 비밀번호를 다시 확인해주세요.")
			</script>
		</c:if>
	</c:if>

	<!-- Main -->
	<div id="main">

		<!-- Post -->
		<section class="post">

			<div class="major row gtr-uniform">

				<div class="col-6" id="login_wrap">
					<form name="loginForm" method="post"
						action="${pageContext.request.contextPath}/member/MemberLoginOk.me">
						<br> <label>아이디</label>
						<div>
							<input type="text" name="member_id" id="member_id"
								placeholder="5~15자리" />
						</div>

						<br> <label>비밀번호</label>
						<div>
							<input type="password" name="member_pw" id="member_pw"
								placeholder="8~32자리" />
						</div>

						<br> <input type="checkbox" id="remember" name="remember">
						<label for="remember" style="font-family: inherit">아이디를
							기억합니다</label> <input type="button" id="login_submit" name="login_submit"
							value="로그인" class="primary fit" onclick="checkLogin()" />
					</form>
					<hr>
					<a href="find_id_pw.jsp" class="button fit"
						style="margin-bottom: 0.5em">아이디/비밀번호 찾기</a> <a href="sign_in.jsp"
						class="button fit">새 계정 만들기</a>
				</div>

				<div class="col-6" id="img_wrap">
					<br>
					<div style="padding-right: 0px">
						<span class="image fit"><img
							src="${pageContext.request.contextPath}/images/pic05.png" alt="" /></span>
					</div>
				</div>
			</div>

		</section>
	</div>


</body>
<!-- Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

<script>
	//아이디 기억하기
	
	$(document).ready(function() {

		// 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
		var key = getCookie("key");
		$("#member_id").val(key);

		if ($("#member_id").val() != "") { // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
			$("#remember").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
		}

		$("#remember").change(function() { // 체크박스에 변화가 있다면,
			if ($("#remember").is(":checked")) { // ID 저장하기 체크했을 때,
				setCookie("key", $("#member_id").val(), 7); // 7일 동안 쿠키 보관
			} else { // ID 저장하기 체크 해제 시,
				deleteCookie("key");
			}
		});

		// ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
		$("#member_id").keyup(function() { // ID 입력 칸에 ID를 입력할 때,
			if ($("#remember").is(":checked")) { // ID 저장하기를 체크한 상태라면,
				setCookie("key", $("#member_id").val(), 7); // 7일 동안 쿠키 보관
			}
		});
	});

	function setCookie(cookieName, value, exdays) {
		var exdate = new Date();
		exdate.setDate(exdate.getDate() + exdays);
		var cookieValue = escape(value)
				+ ((exdays == null) ? "" : "; expires=" + exdate.toGMTString());
		document.cookie = cookieName + "=" + cookieValue;
	}

	function deleteCookie(cookieName) {
		var expireDate = new Date();
		expireDate.setDate(expireDate.getDate() - 1);
		document.cookie = cookieName + "= " + "; expires="
				+ expireDate.toGMTString();
	}

	function getCookie(cookieName) {
		cookieName = cookieName + '=';
		var cookieData = document.cookie;
		var start = cookieData.indexOf(cookieName);
		var cookieValue = '';
		if (start != -1) {
			start += cookieName.length;
			var end = cookieData.indexOf(';', start);
			if (end == -1)
				end = cookieData.length;
			cookieValue = cookieData.substring(start, end);
		}
		return unescape(cookieValue);
	}
</script>

<script>
	function checkLogin() {
		var frm = document.loginForm;

		if (frm.member_id.value == null || frm.member_id.value == "") {
			alert("아이디를 입력해주세요");
			return false;
		}

		if (frm.member_pw.value == null || frm.member_pw.value == "") {
			alert("비밀번호를 입력해주세요");
			return false;
		}

		$("#login_submit").addClass("disabled");
		
		frm.submit();

	}
</script>
</html>