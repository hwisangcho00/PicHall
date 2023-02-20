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
<head>
<title>PicHall 전체 전시회</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/exhibition_list.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/category.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<style>
a{
	border-bottom:none;
}
@media screen and (max-width: 480px) {
	body {
		font-size: 0.75em;
	}
}
</style>
</head>
<body class="is-preload">
	<c:set var="recentlist" value="${requestScope.exhibitionRecentList }"/>
	<c:set var="list" value="${requestScope.exhibitionList}" />
	<c:set var="nowPage" value="${requestScope.nowPage}" />
	<c:set var="startPage" value="${requestScope.startPage}" />
	<c:set var="endPage" value="${requestScope.endPage}" />
	<c:set var="totalCnt" value="${requestScope.totalCnt}" />
	<c:set var="realEndPage" value="${requestScope.realEndPage}" />
	<c:set var="idList" value="${requestScope.idList}" />
	<c:set var="categoryid" value="${requestScope.category_id }"/>
	<c:set var="photoBeanList" value="${requestScope.photoBeanList }"/>

	<c:set var="column" value="${4}"/>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="dropdown active logo">
				<button onclick="location.href='${pageContext.request.contextPath}/index.jsp'" class="dropbtn">PicHall</button>
			</div>
		</header>

		<!-- Nav -->
		<nav id="nav">
			<ul class="links">
				<li><a href="${pageContext.request.contextPath}/index.jsp">추천
						전시회</a></li>
				<li class="active"><a
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
			<!-- Post -->
			<!-- 클래스 post 사용하면 padding이 너무 세서 지움 -->
			<section>
				<header class="major">
					<!-- 카테고리 넣을 곳 -->
					<div id="topMenu">
						<ul>
							<li class="topMenuLi"><a class="menuLink"
								href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=1"
								id="null 1">사진</a>
								<ul class="submenu">
									<li><a class="submenuLink longLink" id="1 11"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=11">추상</a></li>
									<li><a class="submenuLink longLink" id="1 12"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=12">패션</a></li>
									<li><a class="submenuLink longLink" id="1 13"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=13">건축</a></li>
									<li><a class="submenuLink longLink" id="1 14"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=14">모던</a></li>
									<li><a class="submenuLink longLink" id="1 15"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=15">인물</a></li>
									<li><a class="submenuLink longLink" id="1 16"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=16">동물</a></li>
									<li><a class="submenuLink longLink" id="1 17"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=17">자연</a></li>
									<li><a class="submenuLink longLink" id="1 18"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=18">기타</a></li>
								</ul></li>
							<!-- <li>|</li>  중앙분리바-->
							<li class="topMenuLi"><a class="menuLink"
								href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=2"
								id="null 2">미디어 아트</a>
								<ul class="submenu">
									<li><a class="submenuLink longLink" id="2 21"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=21">인터렉티브
											아트</a></li>
									<li><a class="submenuLink longLink" id="2 22"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=22">프로젝션
											맵핑</a></li>
									<li><a class="submenuLink longLink" id="2 23"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=23">미디어
											파사드</a></li>
									<li><a class="submenuLink longLink" id="2 24"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=24">디지털
											아트</a></li>
									<li><a class="submenuLink longLink" id="2 25"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=25">라이트
											아트</a></li>
									<li><a class="submenuLink longLink" id="2 26"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=26">키네틱
											아트</a></li>
									<li><a class="submenuLink longLink" id="2 27"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=27">미디어
											퍼포먼스</a></li>
									<li><a class="submenuLink longLink" id="2 28"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=28">기타</a></li>
								</ul></li>
							<!-- <li>|</li>  -->
							<li class="topMenuLi"><a class="menuLink"
								href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=3"
								id="null 3">영상</a>
								<ul class="submenu">
									<li><a class="submenuLink longLink" id="3 31"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=31">영화</a></li>
									<li><a class="submenuLink longLink" id="3 32"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=32">애니메이션</a></li>
									<li><a class="submenuLink longLink" id="3 33"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=33">기타</a></li>
								</ul></li>
							<!-- <li>|</li>  -->
							<li class="topMenuLi"><a class="menuLink"
								href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=4"
								id="null 4">디자인</a>
								<ul class="submenu">
									<li><a class="submenuLink longLink" id="4 41"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=41">그림</a></li>
									<li><a class="submenuLink longLink" id="4 42"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=42">일러스트</a></li>
									<li><a class="submenuLink longLink" id="4 43"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=43">도예</a></li>
									<li><a class="submenuLink longLink" id="4 44"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=44">가구</a></li>
									<li><a class="submenuLink longLink" id="4 45"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=45">조명</a></li>
									<li><a class="submenuLink longLink" id="4 46"
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=46">기타</a></li>
								</ul></li>
						</ul>
					</div>
				</header>
				<div id="list_wrap" class="col-12">

					<div class="col-12" style="text-align: center">
						<span style="font-size: 1.5em">최근 전시회</span>
						<ul class="recent_exhibition_list" id="aaa">
							<c:choose>
								<c:when test="${recentlist!=null}">
									<c:forEach var="e_r_bean" items="${recentlist }" varStatus="status">
										<li><a href="${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq=${e_r_bean.getExhibition_seq()}">
											<img src="${pageContext.request.contextPath}/app/photo/upload/${e_r_bean.getMain_photo_data()}" class="item_img image fit" style="object-fit:cover"></a></li>
									</c:forEach>
								</c:when>
							</c:choose>
						</ul>
					</div>
					<div class="col-12" style="text-align: center">
						<span style="font-size: 1.5em">전체 전시회</span>

						<table class="list_table">
							<colgroup>
								<c:forEach var="i" begin="1" end="${column}">
									<col>
								</c:forEach>
							</colgroup>
						
							<c:choose>
								<c:when test="${list!=null}">
									<c:forEach var="e_bean" items="${list}" varStatus="status">
									<!-- e_bean ->전시회 반복문 -->
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
													<p class="exh_artist">${idList[status.index]}</p>
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
										<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
				</div>

			</section>


			<!-- 페이지 -->
			<table border="0" cellpadding="0" cellspacing="0" width="900px">
				<tr align="center" valign="middle">
					<td><c:choose>
							<c:when test="${nowPage > 1}">
								<a
									href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=${categoryid}&page=${nowPage - 1}">[이전]</a>&nbsp;
						</c:when>
						</c:choose> <c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${i eq nowPage}">
								[${i}]&nbsp;
								</c:when>
								<c:otherwise>
									<a
										href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=${categoryid}&page=${i}">${i}&nbsp;</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <c:choose>
							<c:when test="${nowPage != realEndPage}">
								<a
									href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex?exhibition_category_id=${categoryid}&page=${nowPage + 1}">[다음]</a>&nbsp;
							</c:when>
						</c:choose></td>
				</tr>
			</table>
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
<script type="text/javascript">
  $(document).ready(function(){
   var max_h=0;
   $("#aaa li").each(function(){
 var h = parseInt($(this).css("height"));
    if(max_h<h){ max_h = h; }
   });
   $("#aaa li").each(function(){
 $(this).css({height:max_h});
   });
   
   $("#aaa li a img").each(function(){
		  $(this).css({height:max_h});
	  });
  });
  
  
</script>
</html>