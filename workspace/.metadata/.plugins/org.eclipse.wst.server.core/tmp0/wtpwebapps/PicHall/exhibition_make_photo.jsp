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
<title>PicHall PhotoPage</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/mypage_multiverse2.css" />
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
<style>
#check_box {
	text-align: left;
}

#thumb {
	padding: 2em 2em 2em 2em;
}

#confirm_button {
	margin: 30px;
}
</style>
</head>

<!-- Header -->


<body class="is-preload">
	<c:set var="photoBeanList" value="${requestScope.photoBeanList}" />
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->

		<header id="header">
			<div class="dropdown active logo">
				<button
					onclick="location.href='${pageContext.request.contextPath}/index.jsp'"
					class="dropbtn">PicHall</button>
			</div>
		</header>

		<div id="main">

			<div id="PhotoManage" style="width: 100%;">
				<h2 style="text-align: center">Photo Select</h2>
			</div>
			<div class="col-12" style="width: 100%;">
				<form name="photoForm" method="post"
					action="${pageContext.request.contextPath}/exhibition/ExhibitionPhotoOk.ex">
					<input type="hidden" name="exhibitionJson" value="${requestScope.exhibitionJson}" /> 
					<input type="hidden" name="main_photo_data" value="${requestScope.main_photo_data}"/>
					<table>
						<tr>
							<td>
								<div class="is-preload" style="text-align: center">

									<div id="wrapper">
										<div id="main">
											<c:choose>
												<c:when
													test="${photoBeanList != null and fn:length(photoBeanList)>0}">
													<c:set var="i" value="${0}"></c:set>
													<c:forEach var="photoBean" items="${photoBeanList}">
														<c:set var="i" value="${i+1}" />
														<article class="thumb" id="thumb">

															<a
																href="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}"
																class="image fit"> <img
																src="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}"
																alt="" />
															</a>
															<h2>${photoBean.getPhoto_name()}</h2>
															<p>${photoBean.getPhoto_text()}</p>
															<div id="check_box" class="col-12 checkbox">
																<c:set var="check" value="${false}" />
																<c:forEach var="photoSeq" items="${photoSeqList}">
																	<c:if test="${photoSeq eq photoBean.getPhoto_seq()}">
																		<c:set var="check" value="${true}" />
																	</c:if>
																</c:forEach>
																<input type="checkbox" name="select" id="select${i}"
																	value="${photoBean.getPhoto_seq()}"> <label
																	for="select${i}" style="font-family: inherit"></label>
															</div>
														</article>
													</c:forEach>
												</c:when>
											</c:choose>
										</div>
										<a class="button small" id="confirm_button"
											onclick="photoFormSubmit()">확인</a>
									</div>


								</div>
							</td>
						</tr>
					</table>

				</form>

			</div>
		</div>
	</div>


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

	<script
		src="${pageContext.request.contextPath}/assets/js/multiverse.main.js"></script>
	<!-- <script>
		function showDisplay(num) {
			var td = document.getElementById("musicPlayer"+num);
			
			if(td.style.display=="none") {
				td.style.display="table-cell";
			} else {
				td.style.display="none";
			}
			
		}
		
		
	</script> -->
	<!--멀티버스 자바스크립튼  -->

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
		function photoFormSubmit() {
			var frm = document.photoForm;

			var selectList = document.getElementsByName("select");

			var check = false;

			for (var i = 0; i < selectList.length; i++) {
				if (selectList[i].checked) {
					check = true;
					break;
				}
			}

			if (check) {
				frm.submit();
			} else {
				alert("사진 하나 이상을 선택해주세요");
				return false;
			}

		}
	</script>
</body>
</html>