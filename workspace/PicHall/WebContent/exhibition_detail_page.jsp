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
<title>PicHall 전시회 상세보기</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/exhibition_list.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/category.css" />
<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
<style>
img.profile {
	border-radius: 70px;
	-moz-border-radius: 70px;
	-khtml-border-radius: 70px;
	-webkit-border-radius: 70px;
}
ul {
	justify-content: center;
    display: flex;
    list-style: disc;
    margin: 0 0 2rem 0;
    padding: 0;
    /* padding-left: 1rem; */
}
</style>
</head>
<body class="is-preload">
	<c:set var="memberBean" value="${requestScope.memberBean }"/>
 	<c:set var="exhibition_text" value="${requestScope.exhibition_text }"/>
	<c:set var="exhibition_title" value="${requestScope.exhibition_title }"/>
	<c:set var="artist_text" value="${requestScope.artist_text }"/>
	<c:set var="exhibition_seq" value="${requestScope.exhibition_seq }"/>
	<c:set var="check" value="${requestScope.check }"/>
	<c:set var="session_seq" value="${requestScope.session_seq }"/>
	<c:set var="list" value="${requestScope.exhibitionList}" />
	<c:set var="exhibitionBean" value="${requestScope.exhibitionBean}"/>
	
	<div id="main">
		<!-- Post -->
		<section class="post">
			<header class="major">
				<div class="col-4" style="margin: 0 auto"> 
				<c:choose>
					<c:when test="${exhibitionBean.getMain_photo_data() != null}">
					<div class="profile_pic_col" style="margin: 0 auto">
						<img class="image fit"
							src="${pageContext.request.contextPath}/app/photo/upload/${exhibitionBean.getMain_photo_data()}" />
					</div>
					</c:when>
					<c:otherwise>
						<div class="profile_pic_col" style="margin: 0 auto">
						<img class="image fit" style="width:150px; height:150px; margin:0 auto;"
							src="https://www.flaticon.com/svg/static/icons/svg/711/711769.svg" />
					</div>
					</c:otherwise>
					</c:choose>

				</div>
				<h1 style="margin-top: 0.3em">${exhibition_title}</h1>
				<a href="${pageContext.request.contextPath}/exhibition/ExhibitionMultiverseView.ex?exhibition_seq=${exhibition_seq}" class="button">지금 관람하기</a>
<!-- 				<a href="javascript:subscribeForm.submit()" class="button icon solid far fa-heart">like</a>
				<a href="javascript:subscribeForm.submit()" class="button icon solid far fa-heart-broken">dislike</a>
 -->				<!-- 좋아요 or 좋아요 취소(이미 한 경우) -->
				<c:choose>
					<c:when test="${check==true}">
						<a href="${pageContext.request.contextPath}/like/LikeCancel.li?exhibition_seq=${exhibition_seq}" class="button icon solid far fa-heart-broken">좋아요 취소</a>							
					</c:when>
					<c:when test="${check==false}">
						<a href="${pageContext.request.contextPath}/like/Like.li?exhibition_seq=${exhibition_seq}" class="button icon solid far fa-heart">좋아요</a>													
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/like/LikeCancel.li?exhibition_seq=${exhibition_seq}" class="button icon solid far fa-heart-broken">좋아요 취소</a>
					</c:otherwise>
				</c:choose>

			</header>
			<hr>

			<div class="row gtr-uniform">

				<div class="col-6">
					<section class="post">
						<article>
							<h3>예술가 소개</h3>
							<div class="col-5" style="padding: 0.5em">
							${artist_text}
							</div>
						</article>
					</section>
				</div>


				<div class="col-6">
					<section class="post">
						<article>
							<h3>전시회 소개</h3>
							<div class="col-5" style="padding: 0.5em">
								${exhibition_text}
							</div>
						</article>
					</section>
				</div>
			</div>

		</section>
	</div>

	<!-- Scripts -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</body>
</html>