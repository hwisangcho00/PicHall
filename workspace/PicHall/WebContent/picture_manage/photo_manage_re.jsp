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
<title>PicHall - ???????????????</title>
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

											<!-- ?????? ???????????? -->
											<div class="modal-content">
												<span class="close">&times;</span>
												<p>?????? ????????????</p>
												<form
												action="${pageContext.request.contextPath}/photo/PhotoEditOk.ph"
												method="post" enctype="multipart/form-data" name="editForm">
												<input name="photo_name" type="text" id="demo-name" placeholder="Title"></input>
												<input name="photo_text" type="text" id="demo-name" placeholder="Text"></input>
												<a href="javascript:editPhoto()" class="button primary small">????????????</a>
												</form>
											</div>
											</div>  --%>
											 
											 </article>
											</c:forEach>
										</c:when>
										<c:otherwise>
									<tr height="50px">
									<td colspan="5" align="center">????????? ????????? ????????????. '?????? ?????????'??? ???????????? ????????? ?????????????????????.</td>
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
								<th colspan="3">??????</th>
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
				<%-- <li><a href="${pageContext.request.contextPath}/photo/PhotoUploadOk.ph" class="button primary small">???????????????</a></li>
				<input name="board_file1" type="file" class="button primary small">???????????????</input> --%>
				<li><button class="button primary">?????? ?????????</button></li>
			</ul>

			<!-- ??????????????? Modal -->
			<div class="modal">

				<!-- ?????? ?????? Modal??? ?????? -->
				<div class="modal-content">
					<span class="close">&times;</span>
					<p>???????????????</p>
					<form
						action="${pageContext.request.contextPath}/photo/PhotoUploadOk.ph"
						method="post" enctype="multipart/form-data" name="PhotoForm" style="text-align:center;">
						<input name="board_file1" type="file" class="button primary small" style="width:100%;"></input>
						<input name="photo_name" type="text" id="demo-name" placeholder="Title"></input>
						<input name="photo_text" type="text" id="demo-name" placeholder="Text"></input>
						<a href="javascript:addboard()" class="button primary small" style="margin:15px;">??????</a>
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
<!--???????????? ??????????????????  -->

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
	// Modal??? ???????????????.
	var modals = document.getElementsByClassName("modal");
	// Modal??? ????????? ????????? ????????? ???????????????.
	var btns = document.getElementsByClassName("button primary");
	// Modal??? ?????? close ???????????? ???????????????.
	var spanes = document.getElementsByClassName("close");
	var funcs = [];

	// Modal??? ????????? ?????? ?????? ???????????? ????????? ??????
	function Modal(num) {
		return function() {
			// ?????? ???????????? ????????? ???????????? Modal??? ????????????.
			btns[num].onclick = function() {
				modals[num].style.display = "block";
				console.log(num);
				$('body').css("overflow", "hidden");
			};

			// <span> ??????(X ??????)??? ???????????? Modal??? ????????????.
			spanes[num].onclick = function() {
				modals[num].style.display = "none";
				$('body').css("overflow", "scroll");
			};
		};
	}

	// ????????? Modal ????????? Modal ????????? ???????????? funcs ????????? ???????????????.
	for (var i = 0; i < btns.length; i++) {
		funcs[i] = Modal(i);
	}

	// ????????? Modal ????????? funcs ????????? ???????????????.
	for (var j = 0; j < btns.length; j++) {
		funcs[j]();
	}

	// Modal ?????? ?????? ???????????? Modal??? ????????????.
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
	function deletePhoto() {/* ?????? */
		var deletePhoto=confirm("????????? ?????????????????????????");
		if(deletePhoto==true){
			deleteForm.submit();
		}else{
			
		}
	}
	function editPhoto() {
		var editPhoto=confirm("?????? ????????? ????????? ?????? ?????????????????????????");
		if(editPhoto=true){
			editForm.submit();
		}
	}
	
</script>
</html>