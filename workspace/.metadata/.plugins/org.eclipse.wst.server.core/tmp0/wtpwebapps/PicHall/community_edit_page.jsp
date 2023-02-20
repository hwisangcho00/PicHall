<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>PicHall 게시글 작성</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/community_write_page.css" />
<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<c:set var="boardBean" value="${requestScope.boardBean}"/>
	<c:set var="attachBeanList" value="${requestScope.attachBeanList}"/>

	<!-- Main -->
	<div id="main">

		<!-- Post -->
		<section>
			<header>
				<h2>PicHall 게시글 수정</h2>
			</header>

			<!-- 글쓰는 부분 -->
			<div class="row gtr-uniform">
				<div class="col-12">
					<form method="post"
						action="${pageContext.request.contextPath}/board/BoardModifyOk.bo"
						enctype="multipart/form-data" name="boardForm">
						<input type="hidden" name="board_seq" value="${boardBean.getBoard_seq()}"/>
						<div class="row">
							<div class="title_wrap">
								<input type="text" name="board_title" value="${boardBean.getBoard_title()}"
									id="title_input">
							</div>

							<div class="type_wrap">
								<select name="board_category_id">
									<c:choose>
										<c:when test="${boardBean.getBoard_category_id() eq 1}">
											<option value="1" selected>자유</option>
											<option value="2">정보</option>
											<option value="3">홍보</option>
											<option value="4">토론</option>
										</c:when>
										<c:when test="${boardBean.getBoard_category_id() eq 2}">
											<option value="1">자유</option>
											<option value="2" selected>정보</option>
											<option value="3">홍보</option>
											<option value="4">토론</option>
										</c:when>
										<c:when test="${boardBean.getBoard_category_id() eq 3}">
											<option value="1">자유</option>
											<option value="2">정보</option>
											<option value="3" selected>홍보</option>
											<option value="4">토론</option>
										</c:when>
										<c:when test="${boardBean.getBoard_category_id() eq 4}">
											<option value="1">자유</option>
											<option value="2">정보</option>
											<option value="3">홍보</option>
											<option value="4" selected>토론</option>
										</c:when>
										
									</c:choose>
								</select>
							</div>
						</div>

						<textarea name="board_text" id="board_text" rows="10"
							style="resize: none">${boardBean.getBoard_text()}</textarea>
						
						<div class="col-12">
							<div class="row">
								<input type="file" name="attach1"/>
								<input type="button" class="button small" onclick="cancelFile('attach1')" value="첨부 삭제">
							</div>
							<div class="row">
								<input type="file" name="attach2"/>
								<input type="button" class="button small" onclick="cancelFile('attach2')" value="첨부 삭제">
							</div>
							<div class="row">
								<input type="file" name="attach3"/>
								<input type="button" class="button small" onclick="cancelFile('attach3')" value="첨부 삭제">
							</div>
						</div>
							
						<a class="button small"
							id="board_submit" onclick="addboard()">수정</a>

					</form>
				</div>

			</div>
		</section>

	</div>
	<div class="bg fixed" style="transform: none;"></div>
</body>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<!--
		migrate 1.2.1 버전 사용 시 반드시 jquery 3.5.1버전 적용 후 사용해야 한다.
-->
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.js"></script>

<script>
		function cancelFile(fileTagName){
			if($.browser.msie){	//ie일 때 초기화
				$("input[name='"+ fileTagName +"']").replaceWith($("input[name='"+ fileTagName +"']").clone(true));
			}else{ //그 외 브라우저일 때 초기화
				$("input[name='"+ fileTagName +"']").val("");
			}
		}	
		
		function addboard(){
			
			var frm = document.boardForm;
			
			if(frm.board_title.value == "") {
				alert("제목을 작성해주세요");
				return false;
			}
			
			if(frm.board_text.value == "") {
				alert("게시글 내용을 작성해주세요");
				return false;
			}
			
			$("#board_submit").addClass("disabled");
			
			boardForm.submit();
		}
		
</script>
</html>