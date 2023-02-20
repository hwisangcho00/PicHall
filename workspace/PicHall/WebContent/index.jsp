<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--
	Massively by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
<head>
<title>PicHall - 환영합니다</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper" class="fade-in">
		<!-- Intro -->
		<div id="intro">
			<h1>
				THIS IS<br /> PICHALL
			</h1>

			<ul class="actions">
				<li><a href="#header"
					class="button icon solid solo fa-arrow-down scrolly">Continue</a></li>
			</ul>

		</div>

		<!-- Header -->
		<header id="header">
			<!-- 애니메이션 때문에 필요함 -->
			<!-- 지우면 안됨 -->
		</header>

		<!-- Nav -->
		<nav id="nav">
			<ul class="links">
				<li class="active"><a
					href="${pageContext.request.contextPath}/index.jsp">추천 전시회</a></li>
				<li><a
					href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex">전체
						전시회</a></li>
				<li><a
					href="${pageContext.request.contextPath}/board/BoardList.bo">커뮤니티</a></li>
			</ul>
			<ul class="icons">
				<c:if test="${session_seq eq null}">
					<li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
					<li><a href="${pageContext.request.contextPath}/sign_in.jsp">Sign
							in</a></li>
				</c:if>
				<c:if test="${session_seq != null}">
					<li><a
						href="${pageContext.request.contextPath}/member/MemberMyPage.me">My
							Page</a></li>
					<li><a
						href="${pageContext.request.contextPath}/member/MemberLogOut.me">Logout</a></li>
				</c:if>
			</ul>
		</nav>


		<!-- Main -->
		<div id="main">

			<!-- Featured Post -->
			<article class="post featured" id="mainPost">
				<header class="major">
					<span class="date">April 25, 2020</span>
					<h2>
						<a href="#">전시회 제목</a>
					</h2>
					<p>
						전시회 설명.<br>pic01.jpg사진을 바꾸면 사진이 바뀝니다
					</p>
				</header>
				<a href="#" class="image main"><img src="images/pic01.jpg"
					alt="" /></a>
				<ul class="actions special">
					<li><a href="exhibition_detail_page.jsp" class="button large">전시로
							이동하기</a></li>
				</ul>
			</article>

			<!-- Posts -->
			<section class="posts" id="posts"></section>

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

<script>
	var pageContext = "${pageContext.request.contextPath}";
	var seq = $("input[name='seq']").val();
	var check = false;

	$(document).ready(function() {
		getList();
	});

	function getList() {
		$.ajax({
			url : pageContext + "/exhibition/ExhibitionMainList.ex",
			type : "get",
			dataType : "json",
			success : showList
		})
	}

	function showList(exhibitions) {
		/*  		var inserExhibition_HTML= "<article style='height: auto; overflow: hidden'>	<header>"
		 + "<span class='date'>April 24, 2017</span> <h2> <a href='#'>전시회 제목</a> </h2>"
		 + "</header> <a href='#' class='image fit'><img src='images/pic02.jpg' alt='' /></a>"
		 + "<p> 전시회 설명.<br>pic02.jpg사진을 바꾸면 사진이 바뀝니다</p> <ul class='actions special'>"
		 + "<li><a href='#' class='button'>전시로 이동하기</a></li></ul></article>"; */
		var text_main = "";
		var text_posts = "";
		if (exhibitions != null && exhibitions.length != 0) {
			$
					.each(
							exhibitions,
							function(index, exhibition) {

								if (index == 0) {
									text_main += "<article class='post featured'> <header class='major'> <span class='date'>"
											+ exhibition.exhibition_start_date
											+ "</span>";
									text_main += "<h2> <a href=${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq="
											+ exhibition.exhibition_seq
											+ ">"
											+ exhibition.exhibition_name
											+ "</h2></a>";
									text_main += "<p>"
											+ exhibition.exhibition_text
											+ "</p> </header>"
									text_main += "<a href=${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq="
											+ exhibition.exhibition_seq
											+ " class='image main'><img src=${pageContext.request.contextPath}/app/photo/upload/"
											+ exhibition.exhibition_photo
											+ " alt='' /></a>";
									text_main += "<ul class='actions special'> <li><a href=${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq="
											+ exhibition.exhibition_seq
											+ " class='button large'>전시로 이동하기</a></li></ul></article>"
								} else {
									text_posts += "<article style='height: auto; overflow: hidden'> <header> <span class='date'>"
											+ exhibition.exhibition_start_date
											+ "</span>";
									text_posts += "<h2> <a href=${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq="
											+ exhibition.exhibition_seq
											+ ">"
											+ exhibition.exhibition_name
											+ "</h2> </header>";
									text_posts += "<a href=${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq="
											+ exhibition.exhibition_seq
											+ " class='image fit'><img src=${pageContext.request.contextPath}/app/photo/upload/"
											+ exhibition.exhibition_photo
											+ " alt='' /></a>";
									text_posts += "<p>"
											+ exhibition.exhibition_text
											+ "</p> </header>";
									text_posts += "<ul class='actions special'> <li><a href=${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq="
											+ exhibition.exhibition_seq
											+ " class='button'>전시로 이동하기</a></li></ul></article>"
								}

							})
		}

		$("#mainPost").html(text_main);
		$("#posts").html(text_posts);
	}
</script>
</html>