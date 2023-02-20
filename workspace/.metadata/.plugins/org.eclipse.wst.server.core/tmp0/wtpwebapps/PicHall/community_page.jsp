<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>PicHall 커뮤니티</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/community_page.css" />
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<c:set var="list" value="${requestScope.boardList}" />
	<c:set var="nowPage" value="${requestScope.nowPage}" />
	<c:set var="startPage" value="${requestScope.startPage}" />
	<c:set var="endPage" value="${requestScope.endPage}" />
	<c:set var="totalCnt" value="${requestScope.totalCnt}" />
	<c:set var="realEndPage" value="${requestScope.realEndPage}" />
	<c:set var="idList" value="${requestScope.idList}" />
	<c:set var="board_category_id" value="${requestScope.board_category_id}" />

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
				<li><a href="${pageContext.request.contextPath}/index.jsp">추천 전시회</a></li>
				<li><a href="${pageContext.request.contextPath}/exhibition/ExhibitionList.ex">전체 전시회</a></li>
				<li class="active"><a href="${pageContext.request.contextPath}/board/BoardList.bo">커뮤니티</a></li>
			</ul>
			<ul class="icons">
				<c:if test="${session_seq eq null}">
					<li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
					<li><a href="${pageContext.request.contextPath}/sign_in.jsp">Sign in</a></li>
				</c:if>
				<c:if test="${session_seq != null}">
					<li><a href="${pageContext.request.contextPath}/member/MemberMyPage.me">My Page</a></li>
					<li><a href="${pageContext.request.contextPath}/member/MemberLogOut.me">Logout</a></li>
				</c:if>
			</ul>
		</nav>

		<!-- Main -->
		<div id="main">
			<section>
				<!-- 상단 컨트롤 부분 -->
				<header>
					<div class="col-12">
						<table id="community_control_table">
							<colgroup>
								<col class="col_button" />
								<col class="col_button" />
								<col class="col_button" />
								<col class="col_button" />
								<col class="col_button" />
								<col class="col_input" />

							</colgroup>
							<tr>
								<td class="button_td">
									<button class="button fit" onclick="javascript:location.replace('${pageContext.request.contextPath}/board/BoardList.bo?board_category_id=0')">전체</button>
								</td>
								<td class="button_td">
									<button class="button fit" onclick="javascript:location.replace('${pageContext.request.contextPath}/board/BoardList.bo?board_category_id=1')">자유</button>
								</td>
								<td class="button_td">
									<button class="button fit" onclick="javascript:location.replace('${pageContext.request.contextPath}/board/BoardList.bo?board_category_id=2')">정보</button>
								</td>
								<td class="button_td">
									<button class="button fit" onclick="javascript:location.replace('${pageContext.request.contextPath}/board/BoardList.bo?board_category_id=3')">홍보</button>
								</td>
								<td class="button_td">
									<button class="button fit" onclick="javascript:location.replace('${pageContext.request.contextPath}/board/BoardList.bo?board_category_id=4')">토론</button>
								</td>
								<!-- 검색엔진 -->
								<td class="input_td">
									<form name="search_form" method="post" action="${pageContext.request.contextPath}/board/BoardList.bo">
										<input type="text" name="query">
									</form>
								</td>
							</tr>
						</table>
					</div>

					<!-- 모바일 인풋 부분 -->
					<div class="col-12" id="mobile_input">
						<input type="text" style="width: 100%">
					</div>

				</header>


				<!-- 게시판 부분 -->
				<article>
					<div class="board_wrap col-12">
						<table id="board_table">
							<colgroup>
								<col class="col_num" />
								<col class="col_type" />
								<col class="col_title" />
								<col class="col_author" />
								<col class="col_date" />
								<col class="col_view" />
								<col class="col_like" />
							</colgroup>
							<tr>
								<th>번호</th>
								<th>종류</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회</th>
								<th>추천</th>
							</tr>
							<c:choose>
								<c:when test="${list != null and fn:length(list)>0}">
									<c:forEach var="b_bean" items="${list}" varStatus="status">
										<tr>
											<td>${b_bean.getBoard_seq()}</td>
											<td class="board_type"><script>
													if(${b_bean.getBoard_category_id()} == 1) {
														document.write('자유')
													} else if (${b_bean.getBoard_category_id()} == 2){
														document.write('정보')
													} else if (${b_bean.getBoard_category_id()} == 3){
														document.write('홍보')
													} else if (${b_bean.getBoard_category_id()} == 4){
														document.write('토론')
													}
												</script></td>
											<td><a
												href="${pageContext.request.contextPath}/board/BoardView.bo?board_seq=${b_bean.getBoard_seq()}">${b_bean.getBoard_title()}</a>
											</td>
											<td>${idList[status.index]}</td>
											<td>${b_bean.getBoard_date()}</td>
											<td>${b_bean.getBoard_hits()}</td>
											<td>${b_bean.getBoard_like()}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="7" align="center">등록된 게시물이 없습니다</td>
									</tr>
								</c:otherwise>
							</c:choose>

						</table>
					</div>
					<!-- 글쓰기 버튼 -->
					<a
						href="${pageContext.request.contextPath}/board/BoardWrite.bo"
						class="button small" id="write_btn">글쓰기</a>
				</article>


			</section>

			<footer id="page_bar">
				<div class="pagination">
					<c:choose>
						<c:when test="${nowPage>1}">
							<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${nowPage-1}&board_category_id=${board_category_id}" class="previous">Prev</a>
						</c:when>
					</c:choose>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<c:choose>
							<c:when test="${i eq nowPage}">
								<a href="#" class="page active">${i}</a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${i}&board_category_id=${board_category_id}" class = "page">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${nowPage != realEndPage}">
							<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${nowPage + 1}&board_category_id=${board_category_id}" class="next">Next</a>
						</c:when>
					</c:choose>
					
				</div>
			</footer>

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
</html>