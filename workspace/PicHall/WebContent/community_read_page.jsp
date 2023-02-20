<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	href="${pageContext.request.contextPath}/assets/css/community_read_page.css" />
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<c:if test="${session_seq eq null}">
		<script>
			alert("PicHall 회원만 게시글을 볼 수 있습니다");
			location
					.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
		</script>
	</c:if>

	<c:set var="boardBean" value="${requestScope.boardBean}" />
	<c:set var="author_id" value="${requestScope.author_id}" />
	<c:set var="attachBeanList" value="${requestScope.attachBeanList}" />
	<c:set var="commentBeanList" value="${requestScope.commentBeanList}" />
	<c:set var="comment_cnt" value="${requestScope.comment_cnt}" />
	<c:set var="idList" value="${requestScope.idList}" />
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="dropdown active logo">
				<button onclick="location.href=='${pageContext.request.contextPath}/index.jsp'" class="dropbtn">PicHall</button>
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
				<!-- 상단 제목 정보 부분 -->
				<header id="title_header">
					<div class="row">
						<!-- 제목 및 날짜 조회수 -->
						<div class="col-6">
							<div class="row">
								<div class="col-12">
									<span class="title">${boardBean.getBoard_title()}</span>
								</div>
							</div>

							<div class="row">
								<div class="col-12">
									<div class="row">
										<span class="date">${boardBean.getBoard_date()}</span> <span
											class="view">${boardBean.getBoard_hits()}</span> <span
											class="writer">${author_id}</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</header>

				<hr style="margin: 1rem 0">

				<!-- 게시판 부분 -->
				<article>
					<div class="col-12" id="text">${boardBean.getBoard_text()}</div>

					<c:if test="${attachBeanList != null}">
						<div class="row" style="margin-top: 0.5em">
							<c:forEach var="attach" items="${attachBeanList}">
								<div class="col-4">
									<img class="image fit"
										src="${pageContext.request.contextPath}/app/board/upload/${attach.getAttach_name()}" />
								</div>
							</c:forEach>
						</div>
					</c:if>

					<c:if test="${boardBean.getMember_seq() == session_seq}">
						<div class="col-12" style="text-align: right">
							<a
								href="${pageContext.request.contextPath}/board/BoardModify.bo?board_seq=${boardBean.getBoard_seq()}"
								class="button small" id="write_btn">수정</a> <a
								href="${pageContext.request.contextPath}/board/BoardDelete.bo?board_seq=${boardBean.getBoard_seq()}"
								class="button small" id="write_btn">삭제</a>
						</div>
					</c:if>
				</article>



				<hr style="margin: 1rem 0">

				<!-- 댓글 부분 -->
				<footer>
					<!-- 댓글 갯수 -->
					<div class="row">
						<div class="col-12">
							<span>댓글 ${comment_cnt}개</span>
						</div>
					</div>

					<!-- 댓글 리스트 -->
					<form method="post"
						action="${pageContext.request.contextPath}/board/BoardCommentModifyOk.bo"
						name="boardReply">
						<input type="hidden" name="board_seq"
							value="${boardBean.getBoard_seq()}" />

						<div class="row">
							<div class="col-12">
								<table id="comment_table">
									<c:choose>
										<c:when test="${commentBeanList != null}">
											<c:set var="i" value="${0}" />
											<c:forEach var="commentBean" items="${commentBeanList}"
												varStatus="status">
												<c:set var="i" value="${i+1}" />
												<tr style="background-color: rgba(255, 255, 255, 0.25);">
													<td>
														<div class="col-12 comment_text">
															<textarea id="${i}" name="reply_content${i}" class="re"
																style="resize: none; height: 80%; border-color: #eeeeee;"
																readonly>${commentBean.getComment_text()}</textarea>
														</div>
														<div class="col-12 comment_detail">
															<div class="col-3">
																<span class="date">${commentBean.getComment_date()}</span>
															</div>
															<div class="col-3">
																<span class="writer">${idList[status.index]}</span>
															</div>
															<c:if
																test="${session_seq == commentBean.getMember_seq()}">
															&nbsp &nbsp
															<a id="ready${i}" style="font-size: 75%; display: inline"
																	href="javascript:updateReply(${i})">수정</a>
																<a id="ok${i}" style="font-size: 75%; display: none"
																	href="javascript:updateOkReply(${commentBean.getComment_seq()}, ${i})">수정완료</a>
																<a
																	href="${pageContext.request.contextPath}/board/BoardCommentDeleteOk.bo?comment_seq=${commentBean.getComment_seq()}&board_seq=${boardBean.getBoard_seq()}"
																	style="font-size: 75%;">삭제</a>
															</c:if>
														</div>
													</td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td>댓글이 아직 없습니다</td>
											</tr>
										</c:otherwise>
									</c:choose>

								</table>
							</div>
						</div>
					</form>
					<!-- 댓글 작성 -->
					<form method="post"
						action="${pageContext.request.contextPath}/board/BoardCommentOk.bo">
						<input type="hidden" name="board_seq"
							value="${boardBean.getBoard_seq()}" />
						<div class="row">
							<div class="col-12">
								<div class="row">
									<div class="col-12">
										<textarea rows="2" placeholder="댓글을 남겨보세요"
											style="resize: none" name="comment_text" required></textarea>
									</div>
								</div>
								<div class="row">
									<div class="col-12">
										<input type="submit" value="작성"
											style="float: right; margin-top: 0.5em" />
									</div>
								</div>
							</div>
						</div>
					</form>
				</footer>
			</section>
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
<script
	src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
<script>
	autosize($("textarea.re"));

	//수정
	var check = false;

	function updateReply(num) {
		//textarea 객체(readonly 삭제)
		//수정 버튼(숨기기)
		//수정 완료 버튼(나타내기)

		var textarea = $("textarea#" + num);
		var modify_ready_a = $("a#ready" + num);
		var modify_ok_a = $("a#ok" + num);

		if (!check) {
			textarea.removeAttr("readonly");
			modify_ready_a.hide();
			modify_ok_a.show();
			check = true;
		} else {
			alert("수정중인 댓글이 있습니다.");
		}
	}

	//수정 완료
	function updateOkReply(comment_seq, num) {
		//댓글 번호, 게시글 번호, 댓글 식별자를 외부에서 전달받는다.

		//댓글 요소들이 모여있는 form태그의 action 속성 값을 변경한 후 submit 해준다.
		//$("form[name='boardReply']").attr("method", "get");
		$("form[name='boardReply']").attr(
				"action",
				"${pageContext.request.contextPath}/board/BoardCommentModifyOk.bo?comment_seq="
						+ comment_seq + "&num=" + num);

		boardReply.submit();
	}
</script>
</html>