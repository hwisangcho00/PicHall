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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload" onload="noBack();"
	onpageshow="if(event.persisted) noBack();">

	<c:set var="musicBeanList" value="${requestScope.musicBeanList}"></c:set>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="dropdown active logo">
				<button onclick="location.href='index.jsp'" class="dropbtn">PicHall</button>
			</div>
		</header>


		<!-- Main -->
		<div id="main">
			<div class="col-12">
				<h2 style="text-align: center">음악 선택 페이지</h2>
			</div>

			<div class="col-12">
				<form name="musicForm" method="post"
					action="${pageContext.request.contextPath}/exhibition/ExhibitionFinishOk.ex">
					<input name="exhibitionJson" value="${requestScope.exhibitionJson}" type="hidden" /> 
					<input name="photoListJson" value="${requestScope.photoListJson}" type="hidden" />
					<input type="hidden" name="main_photo_data" value="${requestScope.main_photo_data}"/>

					<table>
						<c:choose>
							<c:when
								test="${musicBeanList != null and fn:length(musicBeanList)>0}">
								<c:set var="i" value="${0}"></c:set>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>아티스트</th>
									<th colspan="2" style="text-align: center">관리</th>
								</tr>
								<c:forEach var="musicBean" items="${musicBeanList}">
									<c:set var="i" value="${i+1}" />
									<tr>
										<td>${i}</td>
										<td>${musicBean.getMusic_title()}</td>
										<td>${musicBean.getMusic_artist()}</td>
										<td style="text-align: center"><a
											onclick="showDisplay(${i})">듣기</a></td>
										<td>
											<div class="col-12 checkbox">
												<input type="checkbox" name="select" id="select${i}"
													value="${musicBean.getMusic_seq()}"> <label
													for="select${i}" style="font-family: inherit">선택</label>
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="5" style="display: none" id="musicPlayer${i}">
											<audio controls>
												<source
													src="${pageContext.request.contextPath}/app/music/${musicBean.getMusic_data()}">
											</audio>
										</td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="5"><a class="button small"
										onclick="musicFormSubmit()" style="float: right">전시회 완성</a></td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td style="text-align: center">아직 음악이 없습니다.<br>전시회에
										사용할 음악을 추가해보세요.<br> <a
										href="${pageContext.request.contextPath}/music/MusicAdd.mu"
										class="button small">음악 추가 페이지로 이동</a>
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
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
		function showDisplay(num) {
			var td = document.getElementById("musicPlayer"+num);
			
			if(td.style.display=="none") {
				td.style.display="table-cell";
			} else {
				td.style.display="none";
			}
			
		}
		
		function musicFormSubmit(){
			var frm = document.musicForm;
			
			var selectList = document.getElementsByName("select");
			
			var check = false;
			
			for(var i = 0 ; i<selectList.length ; i++) {
				if(selectList[i].checked) {
					check = true;
					break;
				}
			}
			
			if(check) {
				frm.submit();
			} else {
				alert("음악 하나 이상을 선택해주세요");
				return false;
			}
			
			if(confirm("전시회 만들기를 완료하시겠습니까?")){
				frm.submit();
			}
			
		}
	</script>
	<script type="text/javascript">
 		window.history.forward();
 		function noBack(){window.history.forward();}
	</script>

</body>
</html>