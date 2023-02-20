<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!--
	Massively by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html id="divC" xmlns="http://www.w3.org/1999/xhtml" lang="kr">
<head>
<title>PicHall AddMusic</title>
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
	
	<c:set var="musicBean" value="${requestScope.musicBean}"/>
	
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="dropdown active logo">
				<button onclick="location.href='${pageContext.request.contextPath}/index.jsp'" class="dropbtn">PicHall</button>
			</div>
		</header>


		<!-- Main -->
		<div id="main">
			<div class="col-12">
				<h2 style="text-align: center">음악 수정하기</h2>
			</div>

			<div class="col-12">
				<form method="post"
					action="${pageContext.request.contextPath}/music/MusicEditOk.mu"
					id="musicForm" name="musicForm">
					<input type="hidden" value="${musicBean.getMusic_seq()}" name="music_seq"/>
					<table>
						<tr>
							<td style="text-align: center">제목</td>
							<td><input type="text" placeholder="노래의 제목을 입력해주세요" name="music_title" value="${musicBean.getMusic_title()}"></td>
						</tr>
						<tr>
							<td style="text-align: center">아티스트</td>
							<td><input type="text" placeholder="아티스트의 이름을 입력해주세요" name="music_artist" value="${musicBean.getMusic_artist()}"></td>
						</tr>
						<tr>
					</table>
					<div class="col-12">
						PicHall에서는 음악 저작권 침해에 관하여 책임을 지지 않습니다. Royalty-Free 음악을 사용해주세요.
						<div class="checkbox">
							<input type="checkbox" id="agree" name="agree" value="agree">
							<label for="agree" style="font-family: inherit">위 사항을 확인하였으며
								동의합니다</label>
						</div>
						<a href="javascript:submit()" class="button" style="float:right">수정</a>
					</div>

					
				</form>
			</div>

		</div>
	</div>


	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>


	<!-- Scripts -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
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
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.poptrox.min.js"></script>
	<script>
		/* When the user clicks on the button, 
		toggle between hiding and showing the dropdown content */
		function myFunction() {
			document.getElementById("myDropdown").classList.toggle("show");
		}

		// Close the dropdown if the user clicks outside of it
		window.onclick = function(event) {
			if (!event.target.matches('.dropbtn')) {
				var dropdowns = document
						.getElementsByClassName("dropdown-content");
				var i;
				for (i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];
					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}
		}
	</script>
	<script>
		function submit(){
			var frm = document.musicForm;
			
			
			if(frm.music_title.value == "") {
				alert("노래 제목을 입력해주세요.");
				return false;
			}
			
			if(frm.music_artist.value == "") {
				alert("아티스트 이름을 입력해주세요.");
				return false;
			}
			
			if(frm.agree.checked == false) {
				alert("약관을 읽고 동의해주세요.");
				return false;
			}
			
			frm.submit();
			
		}
	</script>
</body>
</html>