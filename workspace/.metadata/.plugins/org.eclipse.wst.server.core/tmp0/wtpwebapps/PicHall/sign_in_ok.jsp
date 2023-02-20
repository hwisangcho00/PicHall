<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>PicHall 커뮤니티</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/community_page.css" />
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="dropdown active logo">
				<button onclick="location.href='${pageContext.request.contextPath}/index.jsp'" class="dropbtn">PicHall</button>
			</div>
		</header>

		<!-- Nav -->
		<nav id="nav">
			<ul class="links">
				<li><a href="${pageContext.request.contextPath}/index.jsp">추천
						전시회</a></li>
				<li><a
					href="${pageContext.request.contextPath}/all_exhibition.jsp">전체
						전시회</a></li>
				<li><a
					href="${pageContext.request.contextPath}/board/BoardList.bo">커뮤니티</a></li>
			</ul>
			<ul class="icons">
				<c:if test="${session_id eq null}">
					<li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
					<li><a href="${pageContext.request.contextPath}/sign_in.jsp">Sign
							in</a></li>
				</c:if>
				<c:if test="${session_id != null}">
					<li><a href="mypage.jsp">My Page</a></li>
					<li><a
						href="${pageContext.request.contextPath}/member/MemberLogOut.me">Logout</a></li>
				</c:if>
			</ul>
		</nav>

		<!-- Main -->
		<div id="main">
			<section>
				<!-- 상단 컨트롤 부분 -->
				<header>
					<div class="col-12" style="text-align:center">
						<h2>회원가입 성공!</h2>
						<h3>이메일 주소 인증 메일이 전송되었습니다. ${param.email}에 들어가서 인증해주세요.</h3>
					</div>
				</header>


				<!-- 게시판 부분 -->
				<article></article>


			</section>


		</div>


		<!-- Footer -->
		<jsp:include page="footer.jsp" />


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
</html>