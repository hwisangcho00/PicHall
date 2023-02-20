<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>전시회 수정</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
<style>
ul {
    list-style: none;
    display: inline;
    padding-inline-start: 0;
}
li{
	display: inline;
}
</style>
</head>
<body class="is-preload">
<c:set var="exhibitionBean" value="${requestScope.exhibitionBean}"/>
	<form name="uploadForm"	action="${pageContext.request.contextPath}/exhibition/ExhibitionModifyOk.ex"	method="post">
		<input type="hidden" name="exhibition_seq" value="${exhibitionBean.getExhibition_seq()}"/>
		<!-- Main -->
		<div id="main">

			<!-- Post -->
			<section class="post">

				<div class="row gtr-uniform">
					<div class="col-12" id="exhibition_detail_wrap">
						<div>
							<input type="text" name="exhibition_name" id="exhibition_name"
								placeholder="제목을 입력해주세요" value="${exhibitionBean.getExhibition_name()}"/>
						</div>
						<br>
						<div>
							<textarea name="exhibition_text" id="exhibition_text" style="resize: none;"
								placeholder="전시회 설명을 입력해주세요">${exhibitionBean.getExhibition_text()}</textarea>
						</div>
						<br> <label>카테고리 설정</label>
					</div>
					<div class="col-6" id="exhibition_category_wrap">
						<div class="type_wrap">
							<select name="exhibition_category_big" onchange="categoryChange(this)">
								<option>대카테고리를 선택해주세요</option>
								<option value="사진">사진</option>
								<option value="미디어 아트">미디어 아트</option>
								<option value="영상">영상</option>
								<option value="디자인">디자인</option>
							</select>
							
							<select  name="exhibition_category_small" id="category_id">
								<option>소카테고리를 선택해주세요</option>
							</select>
						</div>
					</div>
					<div class="col-6" id="date_wrap">
						<table>
							<tr>
								<td>시작날짜 설정</td>
								<td>종료날짜 설정</td>
							</tr>
							<tr>
								<td>
								      <p><input type="date" id="start_date" name="start_date" value="currentDate" min="currentDate" max="2099-12-31"></p>
								</td>
		    					<td>
								      <p><input type="date" id="end_date" name="end_date" value="currentDate" min="currentDate" max="2099-12-31"></p>
								     
		    					</td>
	    					</tr>
						</table>
					</div>
				
					
					<div class="col-12">
						<a href="javascript:formSubmit()" class="button" style="float:right"
							id="submit_btn">다음</a>
					</div>
				</div>
				
			</section>
		</div>
	</form>
</body>
<!-- Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/app/exhibition/upload.js"></script>
<script>
	var contextPath = "${pageContext.request.contextPath}";
</script>
<script>
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	 if(dd<10){
	    dd='0'+dd
	 } 
	 if(mm<10){
	    mm='0'+mm
	 } 
	
	today = yyyy+'-'+mm+'-'+dd;
	
  document.getElementById('start_date').setAttribute("min",today) = new Date().toISOString().substring(0, 10);
</script>
<script>
function categoryChange(e) {
	var category_id_a = ["추상", "패션", "건축", "모던", "인물", "동물", "자연", "기타"];
	var category_id_b = ["인터렉티브 아트", "프로젝션 맵핑", "미디어 파사드", "디지털 아트", "라이트 아트", "키네틱 아트", "미디어 퍼포먼스", "기타"];
	var category_id_c = ["영화", "애니메이션", "기타"];
	var category_id_d = ["그림", "일러스트", "도예", "가구", "조명", "기타"];
	var target = document.getElementById("category_id");

	if(e.value == "사진") var d = category_id_a;
	else if(e.value == "미디어 아트") var d = category_id_b;
	else if(e.value == "영상") var d = category_id_c;
	else if(e.value == "디자인") var d = category_id_d;

 	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML = d[x];
		target.appendChild(opt);
	}
}
</script>
</html>