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
<html>

<style>
#PhotoManage {
	display: block;
	margin: 0 auto;
}
</style>
<style>
ul {
	list-style: none;
	margin: none;
}

a {
	border-bottom: none;
}

.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}
/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
	z-index: 10004;
}
/* The Close Button */
.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

#dragandrophandler {
	border: 2px dotted #0B85A1;
	width: 400px;
	color: #92AAB0;
	text-align: left;
	vertical-align: middle;
	padding: 10px 10px 10 10px;
	margin-bottom: 10px;
	font-size: 200%;
}
</style>
<style>
/* Icon */
@import url(fontawesome-all.min.css);
   .icon {
      text-decoration: none;
      border-bottom: none;
      position: relative;
   }

      .icon:before {
         -moz-osx-font-smoothing: grayscale;
         -webkit-font-smoothing: antialiased;
         display: inline-block;
         font-style: normal;
         font-variant: normal;
         text-rendering: auto;
         line-height: 1;
         text-transform: none !important;
         font-family: 'Font Awesome 5 Free';
         font-weight: 400;
      }

      .icon > .label {
         display: none;
      }

      .icon:before {
         line-height: inherit;
      }

      .icon.solid:before {
         font-weight: 900;
      }

      .icon.brands:before {
         font-family: 'Font Awesome 5 Brands';
      }
</style>
<head>
<title>PicHall - 환영합니다</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/mypage_multiverse2.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
</head>

<!-- Header -->
		<header id="header">
			<div class="dropdown active logo">
				<button
					onclick="location.href='${pageContext.request.contextPath}/index.jsp'"
					class="dropbtn">PicHall</button>
			</div>
		</header>

<body class="is-preload">
	<c:set var="photo_seq" value="${requestScope.photo_seq}" />
	<c:set var="photo_name" value="${requestScope.photo_name}" />
	<c:set var="photo_text" value="${requestScope.photo_text }" />
	<c:set var="memberBean" value="${requestScope.memberBean}"></c:set>
	<c:set var="photoBeanList" value="${requestScope.photoBeanList}"></c:set>

	<div id="wrapper">
		<!-- Main -->

		<div id="main">

			<div id="PhotoManage" style="width: 100%;">
				<h2 style="text-align:center">Photo Manage</h2>
			</div>

			<table>
				<tr>
					<td>
						<div class="is-preload" style="text-align: center">
							<span style="font-size: 1.5em">My picture</span>

							<div id="wrapper">
								<div id="main">
									<c:choose>
										<c:when
											test="${photoBeanList != null and fn:length(photoBeanList)>0}">
											<c:set var="i" value="${0}"></c:set>
											<c:forEach var="photoBean" items="${photoBeanList}">
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
													<form id="deleteForm" method="post" action="${pageContext.request.contextPath}/photo/PhotoDeleteOk.ph">
													<input type="hidden" name="photo_seq" value="${photoBean.getPhoto_seq()}">
													<a onclick="deletePhoto()"><button style="float:right; padding:0 1.5em"><i class="fas fa-trash"></i></button></a>
													</form>
													<%-- <button style="float:right; padding:0 1.5em" class="button primary"><i class="fa fa-list-ul" aria-hidden="true"></i></button>
											 
											 <div class="modal">

											<!-- 사진 정보수정 -->
											<div class="modal-content">
												<span class="close">&times;</span>
												<p>사진 정보수정</p>
												<form
												action="${pageContext.request.contextPath}/photo/PhotoEditOk.ph"
												method="post" enctype="multipart/form-data" name="editForm">
												<input name="photo_name" type="text" id="demo-name" placeholder="Title"></input>
												<input name="photo_text" type="text" id="demo-name" placeholder="Text"></input>
												<a href="javascript:editPhoto()" class="button primary small">수정완료</a>
												</form>
											</div>
											</div>  --%>
											 
											 </article>
											</c:forEach>
										</c:when>
										<c:otherwise>
									<tr height="50px">
									<td colspan="5" align="center">등록된 사진이 없습니다. '사진 업로드'를 클릭하여 사진을 업로드해보세요.</td>
									</tr>
								</c:otherwise>
									</c:choose>
								</div>
							</div>


						</div>
					</td>
				</tr>
			</table>

			<%-- <table>
					<c:choose>
						<c:when
							test="${photoBeanList != null and fn:length(photoBeanList)>0}">
							<c:set var="i" value="${0}"></c:set>
							<tr>
								<th colspan="3">사진</th>
							</tr>
							<c:forEach var="photoBean" items="${photoBeanList}">
								<c:set var="i" value="${i+1}" />
								<td>
									<article class="thumb">
										${i} 
										<a href="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}"
											class="image">
										<img src="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}"
											alt="" /></a>
										<h2>${photoBean.getPhoto_name()}</h2>
										<p>${photoBean.getPhoto_text()}</p>
									</article>
								</td>
							</c:forEach>
						</c:when>
					</c:choose>
				</table> --%>
			<ul class="actions small" style="margin:0 auto;">
				<%-- <li><a href="${pageContext.request.contextPath}/photo/PhotoUploadOk.ph" class="button primary small">사진업로드</a></li>
				<input name="board_file1" type="file" class="button primary small">사진업로드</input> --%>
				<li><button class="button primary">사진 업로드</button></li>
			</ul>

			<!-- 사진업로드 Modal -->
			<div class="modal">

				<!-- 다섯 번째 Modal의 내용 -->
				<div class="modal-content">
					<span class="close">&times;</span>
					<p>사진업로드</p>
					<form
						action="${pageContext.request.contextPath}/photo/PhotoUploadOk.ph"
						method="post" enctype="multipart/form-data" name="PhotoForm" style="text-align:center;">
						<input name="board_file1" type="file" class="button primary small" style="width:100%;"></input>
						<input name="photo_name" type="text" id="demo-name" placeholder="Title"></input>
						<input name="photo_text" type="text" id="demo-name" placeholder="Text"></input>
						<a href="javascript:addboard()" class="button primary small" style="margin:15px;">등록</a>
					</form>
				</div>
			</div>
			
			
		</div>
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
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.poptrox.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/multiverse.main.js"></script>
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
			var dropdowns = document.getElementsByClassName("dropdown-content");
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
	// Modal을 가져옵니다.
	var modals = document.getElementsByClassName("modal");
	// Modal을 띄우는 클래스 이름을 가져옵니다.
	var btns = document.getElementsByClassName("button primary");
	// Modal을 닫는 close 클래스를 가져옵니다.
	var spanes = document.getElementsByClassName("close");
	var funcs = [];

	// Modal을 띄우고 닫는 클릭 이벤트를 정의한 함수
	function Modal(num) {
		return function() {
			// 해당 클래스의 내용을 클릭하면 Modal을 띄웁니다.
			btns[num].onclick = function() {
				modals[num].style.display = "block";
				console.log(num);
				$('body').css("overflow", "hidden");
			};

			// <span> 태그(X 버튼)를 클릭하면 Modal이 닫습니다.
			spanes[num].onclick = function() {
				modals[num].style.display = "none";
				$('body').css("overflow", "scroll");
			};
		};
	}

	// 원하는 Modal 수만큼 Modal 함수를 호출해서 funcs 함수에 정의합니다.
	for (var i = 0; i < btns.length; i++) {
		funcs[i] = Modal(i);
	}

	// 원하는 Modal 수만큼 funcs 함수를 호출합니다.
	for (var j = 0; j < btns.length; j++) {
		funcs[j]();
	}

	// Modal 영역 밖을 클릭하면 Modal을 닫습니다.
	window.onclick = function(event) {
		if (event.target.className == "modal") {
			event.target.style.display = "none";
			$('body').css("overflow", "scroll");
		}
	};
</script>
<script>
	function addboard() {
		PhotoForm.submit();
	}
	function deletePhoto() {/* 잘됨 */
		var deletePhoto=confirm("사진을 삭제하시겠습니까?");
		if(deletePhoto==true){
			deleteForm.submit();
		}else{
			
		}
	}
	function editPhoto() {
		var editPhoto=confirm("사진 정보를 다음과 같이 수정하시겠습니까?");
		if(editPhoto=true){
			editForm.submit();
		}
	}
	
</script>
</html>