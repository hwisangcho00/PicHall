<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>PicHall 탈퇴하기</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />

<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">
	
	<c:set var="member_seq" value="${requestScope.member_seq}"/>
	<c:set var="member_id" value="${requestScope.member_id}"/>

	<!-- Main -->
	<div id="main">

		<!-- Post -->
		<section class="post">
			<header class="major">
				<h3 style="font-size: 2rem">PicHall 탈퇴안내</h3>
			</header>
			<hr>

			<div class="row gtr-uniform">
				<div>
					<p>
						1. 사용하고 계신 아이디(${member_id})는 탈퇴할 경우 재사용 및 복구가 <strong style="color: red">불가능</strong>합니다.
					</p>

					<hr>

					<p>
						2. 탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다. 회원정보, 사진, 전시회, 게시글 등 개인형 서비스 이용기록은
						<strong style="color: red">모두 삭제되며 , 삭제된 데이터는 복구되지 않습니다.</strong>
						삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.
					</p>

					<hr>

					<form method="post" action="${pageContext.request.contextPath}/member/MemberQuitOk.me" name="quitForm" id="quitForm">
						<input type="checkbox" id="agree" name="agree" value="동의합니다"><label
							for="agree" style="font-family: 'Noto Sans KR'">안내 사항을 모두
							확인하였으며, 이에 동의합니다. </label>
						<p style="text-align:center">
							<a class="button small" onclick="submit()" id="quit_btn">확인</a>
						</p>
					</form>

				</div>
			</div>
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
<script>
	function submit() {
		var frm = document.quitForm;
		
		if(frm.agree.checked == false) {
			alert("약관을 읽고 동의해주세요.")
			return false;
		}
		
		$("#quit_btn").addClass("disabled");
		
		frm.submit();
	}
</script>
</html>