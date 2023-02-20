<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<html id="divC" xmlns="http://www.w3.org/1999/xhtml" lang="nl">
	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main_multiverse.css" />
		<noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">
		<c:set var="member_seq" value="${requestScope.member_seq}" />
		<c:set var="exhibition_seq" value="${requestScope.exhibition_seq}" />
		<c:set var="member_nickname" value="${requestScope.member_nickname}" />
		<c:set var="artist_text" value="${requestScope.artist_text}" />
		<c:set var="photo_seq" value="${requestScope.photo_seq}" />
		<c:set var="photo_name" value="${requestScope.photo_name}" />
		<c:set var="photo_text" value="${requestScope.photo_text }" />
		<c:set var="photo_data" value="${requestScope.photo_data }" />
		<c:set var="photoBeanList" value="${requestScope.photoBeanList}"></c:set>
		<c:set var="musicBeanList" value="${requestScope.musicBeanList}"></c:set>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="${pageContext.request.contextPath}/index.jsp"><strong>Multiverse</strong> by PicHall</a></h1>
						<nav>
							<ul>
								<li><a href="#footer" class="icon fa-info-circle">more/music</a></li>
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<div id="main">
                                <c:choose>
										<c:when
											test="${photoBeanList != null and fn:length(photoBeanList)>0}">
											<c:set var="i" value="${0}"></c:set>
											<c:forEach var="photoBean" items="${photoBeanList}">
											<!-- photoBean에는 해당 전시회에 해당된 사진들이 담겨 있음. -->
												<c:set var="i" value="${i+1}" />
												<article class="thumb">
													<a class="image fit"
														href="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}"
														class="image"> <img
														src="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}"
														alt="" />
													</a>
													<h6 style="color:white">${photoBean.getPhoto_name()}</h6>
													<p style="color:white; font-size:12px;">${photoBean.getPhoto_text()}
													</p>
											 </article>
											</c:forEach>
										</c:when>
									</c:choose>
                            
						
					</div>

				<!-- Footer -->
					<footer id="footer" class="panel">
						<div class="inner split">
							<div>
								<section>
									<h2>${member_nickname }</h2>
									<p>${artist_text}</p>
								</section>
								<section>
									<h2><a href="${pageContext.request.contextPath}/exhibition/UserView.ex?member_seq=${member_seq}" style="border-bottom: none">예술가 페이지로 가기</a></h2><!-- 작가의 유저페이지로 이동 -->
								</section>
								<p class="copyright">
									&copy; PicHall.
								</p>
								<iframe src="${pageContext.request.contextPath}/app/music/${musicBean.getMusic_data()}" allow="autoplay" id="iframeAudio" style="display:none"></iframe>
								<audio controls autoplay loop preload="none" id="playAudio"> <!-- controls유무가 음악조절바가 뜨냐안뜨냐 유무 -->
									<c:set var="i" value="${0}"></c:set>
									<c:forEach var="musicBean" items="${musicBeanList}">
										<c:set var="i" value="${i+1}" />
										<source src="${pageContext.request.contextPath}/app/music/${musicBean.getMusic_data()}">
									</c:forEach>
								</audio>
							</div>
							<div>
								<section>
									<h2>신고하기</h2>
									<form name="reportForm" method="post" action="${pageContext.request.contextPath}/exhibition/SendReport.ex">
										<input type="hidden" name="exhibition_seq" value="${exhibition_seq}" />
										<div class="field half first">
											<input type="text" name="title" id="title" placeholder="제목" />
										</div>
										<div class="field">
											<textarea name="message" id="message" rows="4" placeholder="내용을 입력해주세요" style="resize:none"></textarea>
										</div>
										<ul class="actions">
											<li><input type="submit" value="Send" class="special" /></li>
											<li><input type="reset" value="Reset" /></li>
										</ul>
									</form>
								</section>
							</div>
						</div>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.poptrox.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/multiverse.main.js"></script>

        </body> 
       <!--  <script>
        var isChrome = /Chrome/.test(navigator.userAgent) && /Google Inc/.test(navigator.vendor);
        if (!isChrome){
            $('#iframeAudio').remove()
        }
        else {
            $('#playAudio').remove() // just to make sure that it will not have 2x audio in the background 
        }
        </script> -->
</html>
   
