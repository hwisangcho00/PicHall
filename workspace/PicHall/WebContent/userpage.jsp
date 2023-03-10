<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!--
	Massively by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html id="divC" xmlns="http://www.w3.org/1999/xhtml" lang="kr">
<head>
<title>user Page</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/exhibition_list.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage_multiverse2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
<style>
ul {
	justify-content: center;
    display: flex;
    list-style: disc;
    margin: 0 0 2rem 0;
    padding: 0;
    /* padding-left: 1rem; */
}
a {
	border-bottom: none;
}
</style>
</head>
<body class="is-preload">
<c:set var="memberBean" value="${requestScope.memberBean }"/>
<c:set var="followerBeanList" value="${requestScope.followerBeanList}"/>
<c:set var="followerIdList" value="${requestScope.followerIdList}"/>
<c:set var="followerSeqList" value="${requestScope.followerSeqList}"/>
<c:set var="followingBeanList" value="${requestScope.followingBeanList}"/>
<c:set var="followingIdList" value="${requestScope.followingIdList}"/>
<c:set var="followingSeqList" value="${requestScope.followingSeqList}"/>

<c:set var="list" value="${requestScope.exhibitionList}" />
<c:set var="nowPage" value="${requestScope.nowPage}" />
<c:set var="startPage" value="${requestScope.startPage}" />
<c:set var="endPage" value="${requestScope.endPage}" />
<c:set var="totalCnt" value="${requestScope.totalCnt}" />
<c:set var="realEndPage" value="${requestScope.realEndPage}" />
<c:set var="photoBeanList" value="${requestScope.photoBeanList }"/>

<c:set var="column" value="${4}"/>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header" style="z-index: auto">
			<!-- <a href="index.jsp" class="logo">PicHall</a> -->
			<div class="dropdown active logo">
				<button onclick="location.href='${pageContext.request.contextPath}/index.jsp'" class="dropbtn">PicHall</button>
			</div>
		</header>


		<!-- Main -->
		<div id="main">
			<section>
				<div class="row">
					<!-- ????????? ?????? -->
					<c:choose>
					<c:when test="${memberBean.getMember_profile_pic() != null}">
					<div class="profile_pic_col" style="margin: 0 auto">
						<img class="image fit"
							src="${pageContext.request.contextPath}/app/member/profile_pic/${memberBean.getMember_profile_pic()}" />
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

				<!-- ????????? ?????? ?????? ????????? row -->
				<div class="row">
					<div class="col-12" style="text-align: center" id="member_nickname">${memberBean.getMember_nickname()}</div>
					<div class="col-12" style="text-align: center" id="member_id">${memberBean.getMember_id()}</div>
				</div>
				<!-- ?????? -->
				<div class="row" style="margin-top: 1em">
					<div class="col-12">
						<div class="actions">
							<ul class="modal_list">
								<li class="modal_li">
									<button class="btn" name="check" value="follower" onclick="location.href='javascript:viewFollowed()'">?????????</button> <!-- ??? ?????? Modal -->
									<div class="modal">

										<!-- ??? ?????? Modal??? ?????? -->
										<div class="modal-content"
											style="height: 50%; overflow-y: scroll;">
											<span class="close">&times;</span>
											<ul style="display:contents;">
												<!-- ???????????? ???????????? ??????????????? ??????????????? -->
												<!-- <li><input type="text" placeholder="??????"></li> -->
												<c:choose>
													<c:when test="${followerBeanList!=null }">
														<c:forEach var="followerBean" items="${followerBeanList}" varStatus="status">
															<li><a href="${pageContext.request.contextPath}/exhibition/UserView.ex?member_seq=${followerSeqList[status.index]}">${followerIdList[status.index]}</a></li>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<li>??????????????? ????????? ????????????</li>
													</c:otherwise>
												</c:choose>
											</ul>
										</div>
									</div>
								</li>
								<li class="modal_li">
									<button class="btn" name="check" value="following" onclick="location.href='javascript:viewFollowing(${member_seq})'">?????????</button> <!-- ??? ?????? Modal -->
									<div class="modal">

										<!-- ??? ?????? Modal??? ?????? -->
										<div class="modal-content"
											style="height: 50%; overflow-y: scroll;">
											<span class="close">&times;</span>
											<ul style="display:contents;">
												<!-- ???????????? ???????????? ??????????????? ??????????????? -->
												<!-- <li><input type="text" placeholder="??????"></li> -->
												<c:choose>
													<c:when test="${followingBeanList!=null }">
														<c:forEach var="followingBean" items="${followingBeanList}" varStatus="status">
															<li><a href="${pageContext.request.contextPath}/exhibition/UserView.ex?member_seq=${followingSeqList[status.index]}">${followingIdList[status.index]}</a></li>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<li>??????????????? ????????? ????????????</li>
													</c:otherwise>
												</c:choose>
											</ul>
										</div>
									</div>

								</li>
							</ul>
						</div>
					</div>
				</div>

				<hr>
<%!int row_cnt = 4;
int col_cnt = 3;%>
				<!-- ??? ????????? ?????? -->
				<table class="col-6">
					<tr>
						<td>
							<div class="col-12" style="text-align: center">
						<span style="font-size: 1.5em">My Exhibition</span>
						
						<form name="subscribeForm" action="${pageContext.request.contextPath}/exhibition/SubscribeOk.ex?member_seq=${memberBean.getMember_seq()}" method="post">
							<input type="hidden" name="session_seq" value="${session_seq}"/>
							<input type="hidden" name="member_id" value="${memberBean.getMember_id()}"/>
						</form>
						<form name="unsubscribeForm" action="${pageContext.request.contextPath}/exhibition/UnSubscribeOk.ex?member_seq=${memberBean.getMember_seq()}" method="post">
							<input type="hidden" name="session_seq" value="${session_seq}"/>
							<input type="hidden" name="member_id" value="${memberBean.getMember_id()}"/>
						</form>
						
						<ul class="actions">
							<li><a href="javascript:subscribeForm.submit()" class="button primary icon solid fa-bell">subscribe</a></li>
							<li><a href="javascript:unsubscribeForm.submit()" class="button icon solid fa-bell-slash">unsubscribe</a></li>
						</ul>
						
						
						<table class="list_table">
							<colgroup>
								<c:forEach var="i" begin="1" end="${column}">
									<col>
								</c:forEach>
							</colgroup>
						
							<c:choose>
								<c:when test="${list!=null}">
									<c:forEach var="e_bean" items="${list}" varStatus="status">
									<!-- e_bean ????????? ????????? -->
										<c:if test="${status.index % column eq 0}">
											<tr align="center" valign="middle"
												onmouseover="this.style.backgroundColor='F8F8F8'"
												onmouseout="this.style.backgroundColor=''">
										</c:if>
										<td>
											<div class="item_wrap">
												<div class="image_wrap col-12">
													<a href="${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq=${e_bean.getExhibition_seq()}"> 
													<img src="${pageContext.request.contextPath}/app/photo/upload/${e_bean.getMain_photo_data()}" class="item_img image fit">
														<!-- class="item_img image fit"> --></a>
												</div>
												<div class="detail_wrap">
													<a
														href="${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq=${e_bean.getExhibition_seq()}"><span
														class="exh_title">${e_bean.getExhibition_name()}</span></a>
													<p class="exh_date">${e_bean.getStart_date()}~${e_bean.getEnd_date()}</p>
												</div>
											</div>
										</td>
										<c:if test="${status.index % column eq (column-1)}">
											</tr>
										</c:if>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr height="50px">
										<td colspan="5" align="center">????????? ???????????? ????????????.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
						</td>
					</tr>
				</table>
				<hr>
				
			</section>
			
			
			<!-- ????????? -->
			<table border="0" cellpadding="0" cellspacing="0" width="900px">
				<tr align="center" valign="middle">
					<td><c:choose>
							<c:when test="${nowPage > 1}">
								<a
									href="${pageContext.request.contextPath}/exhibition/UserView.ex?member_seq=${member_seq}&page=${nowPage - 1}">[??????]</a>&nbsp;
						</c:when>
						</c:choose> <c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${i eq nowPage}">
								[${i}]&nbsp;
								</c:when>
								<c:otherwise>
									<a
										href="${pageContext.request.contextPath}/exhibition/UserView.ex?member_seq=${member_seq}&page=${i}">${i}&nbsp;</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <c:choose>
							<c:when test="${nowPage != realEndPage}">
								<a
									href="${pageContext.request.contextPath}/exhibition/UserView.ex?member_seq=${member_seq}&page=${nowPage + 1}">[??????]</a>&nbsp;
							</c:when>
						</c:choose></td>
				</tr>
			</table>
		</div>



	</div>

	<!-- Footer -->
		<jsp:include page="footer.jsp" />


	<!-- Scripts -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.poptrox.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/multiverse.main.js"></script>
	<script>var contextPath = "${pageContext.request.contextPath}";</script>
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
	<script>
		// Modal??? ???????????????.
		var modals = document.getElementsByClassName("modal");
		// Modal??? ????????? ????????? ????????? ???????????????.
		var btns = document.getElementsByClassName("btn");
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
	//????????? Ajax ?????? ??? success:function(result){var follows = JSON.parse(result);}
	//following ??????
	function viewFollowing(member_seq) {
		var followings=new Array();
		$.ajax({
			url : contextPath+"/ViewFollowing.su?member_seq="+member_seq,
			type : 'POST',
			dataType : 'text',
			success : function(result) {
				var follows = JSON.parse(result);
				for(var i=0;i<follows.length;i++){
					followings[i]=follows[1];
				}
			}
		});
	}
	//followed(follower) ??????
	function viewFollowed(member_seq) {
		var followers=new Array();
		$.ajax({
			url : contextPath+"/ViewFollower.su?member_seq="+member_seq,
			type : 'POST',
			dataType : 'text',
			success : function(result) {
				var follows = JSON.parse(result);
				for(var i=0;i<follows.length;i++){
					followers[i]=follows[1]
				}
			}
		});
	}
	</script>
</body>
</html>























