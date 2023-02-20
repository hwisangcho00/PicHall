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
<title>PicHall MusicPage</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<c:set var="memberBean" value="${requestScope.memberBean}"></c:set>
	<c:set var="musicBeanList" value="${requestScope.musicBeanList}"></c:set>
	
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
				<h2 style="text-align:center">음악 관리 페이지</h2>
			</div>

			<div class="col-12">
				<table>
					<c:choose>
						<c:when test="${musicBeanList != null and fn:length(musicBeanList)>0}">
							<c:set var="i" value="${0}"></c:set>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>아티스트</th>
								<th colspan="3" style="text-align:center">관리</th>
							</tr>
							<c:forEach var="musicBean" items="${musicBeanList}">
								<c:set var="i" value="${i+1}"/>
								<tr>
									<td>
										${i}
									</td>
									<td>
										${musicBean.getMusic_title()}
									</td>
									<td>
										${musicBean.getMusic_artist()}
									</td>
									<td style="text-align:center">
										<form id="editForm${i}" method="post" action="${pageContext.request.contextPath}/music/MusicEdit.mu">
											<input type="hidden" name="music_seq" value="${musicBean.getMusic_seq()}">
											<a onclick="editMusic(${i})">수정</a>
										</form>
									</td>
									<td style="text-align:center">
										<form id="deleteForm${i}" method="post" action="${pageContext.request.contextPath}/music/MusicDeleteOk.mu">
											<input type="hidden" name="music_seq" value="${musicBean.getMusic_seq()}">
											<a onclick="deleteMusic(${i})">삭제</a>
										</form>
									</td>
									<td style="text-align:center">
										<a onclick="showDisplay(${i})">듣기</a>
									</td>
								</tr>
								<tr>
									<td colspan="6" style="display:none" id="musicPlayer${i}">
										<audio controls>
											<source src="${pageContext.request.contextPath}/app/music/${musicBean.getMusic_data()}">
										</audio>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="6"><a href="${pageContext.request.contextPath}/music/MusicAdd.mu" class="button small" style="float:right">음악 추가하기</a></td>
							</tr>
						</c:when>
							
						<c:otherwise>
							<tr>
								<td style="text-align:center">
									아직 음악이 없습니다.<br>전시회에 사용할 음악을 추가해보세요.<br>
									<a href="${pageContext.request.contextPath}/music/MusicAdd.mu" class="button small">음악 추가 페이지로 이동</a>
								</td>							
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</div>

		</div>
	</div>


	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>


	<!-- Scripts -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.poptrox.min.js"></script>
	<script>
		function deleteMusic(num){
			if(confirm("음악을 삭제하시겠습니까?")){
				document.getElementById("deleteForm"+num).submit();
			}
			
		}
		
		function editMusic(num){
			document.getElementById("editForm"+num).submit();
		}
	
		function showDisplay(num) {
			var td = document.getElementById("musicPlayer"+num);
			
			if(td.style.display=="none") {
				td.style.display="table-cell";
			} else {
				td.style.display="none";
			}
			
		}
	</script>
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
</body>
</html>