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
<title>PicHall MyPage</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/exhibition_list.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/mypage.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/mypage_multiverse2.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />

<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
<style>
#makebtn {
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
	<c:set var="memberBean" value="${requestScope.memberBean}" />
	<c:set var="list" value="${requestScope.exhibitionList }" />
	<c:set var="totalCnt" value="${requestScope.totalCntbySeq}" />
	<c:set var="photo_seq" value="${requestScope.photo_seq}" />
	<c:set var="photo_name" value="${requestScope.photo_name}" />
	<c:set var="photo_text" value="${requestScope.photo_text }" />
	<c:set var="photoBeanList" value="${requestScope.photoBeanList}"></c:set>
	<c:set var="memberProfilePic" value="${requestScope.memberProfilePic}"></c:set>
	<c:set var="photoExhibitionBeanList" value="${requestScope.photoExhibitionBeanList}"></c:set>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="dropdown active logo">
				<button
					onclick="location.href='${pageContext.request.contextPath}/index.jsp'"
					class="dropbtn">PicHall</button>
			</div>
		</header>


		<!-- Main -->
		<div id="main">
			<section style="width: 100%">
				<div class="row">
					<!-- 프로필 사진 -->
					<%-- <div class="profile_pic_col" style="margin: 0 auto">
						<img class="image fit"
							src="${pageContext.request.contextPath}/app/member/profile_pic/${memberBean.getMember_profile_pic()}" />
					</div> --%>
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

				<!-- 프로필 사진 아래 새로운 row -->
				<div class="row">
					<div class="col-12" style="text-align: center" id="member_nickname">${memberBean.getMember_nickname()}</div>
					<div class="col-12" style="text-align: center" id="member_id">${memberBean.getMember_id()}</div>
				</div>
				<!-- 모달 -->
				<div class="row" style="margin-top: 1em">
							<!--프로필 수정  -->
					<div class="col-12">
						<div class="actions">
							<ul class="modal_list" style="text-align:center;"><li class="modal_li"><a class="button" style="width: 100%; "
									href="${pageContext.request.contextPath}/member/MemberEditProfile.me">프로필 수정</a></li></ul>
							<ul class="modal_list">
								<li class="modal_li">
									<form name="PictureManageForm"
						action="${pageContext.request.contextPath}/photo/PhotoView.ph?member_seq=${memberBean.getMember_seq()}"
						method="post">
						<input type="hidden" name="session_seq" value="${session_seq}" />
						</form>
						<ul>
						<li id="more"><a href="javascript:PictureManageForm.submit()"
						class="button " style="width:100%">사진 관리</a></li>
						</ul>
								</li>
								<li class="modal_li"><a class="button" style="width: 100%"
									href="${pageContext.request.contextPath}/music/MusicMyPage.mu">음악
										관리</a> <!-- 두 번째 Modal --> <%-- <div class="modal">
										두 번째 Modal의 내용
										<div class="modal-content">
											<span class="close">&times;</span>
											<p>음악을 업로드해주세요. 저작권이 있는 음악의 업로드에 대해 PicHall은 책임지지 않습니다.</p>
											<div id="dragandrophandler">Drag & Drop Files Here</div>
											<br>
											<div id="status1"></div>
										</div>
									</div> --%></li>
								<li class="modal_li">
									<button class="btn">팔로워</button> <!-- 세 번째 Modal -->
									<div class="modal">

										<!-- 세 번째 Modal의 내용 -->
										<div class="modal-content"
											style="height: 50%; overflow-y: scroll;">
											<span class="close">&times;</span>
											<ul style="display:contents;">
												<!-- 팔로우를 클릭하면 상대방에게 이동합니다 -->
												<!-- <li><input type="text" placeholder="검색"></li> -->
												<c:choose>
													<c:when test="${followerBeanList!=null }">
														<c:forEach var="followerBean" items="${followerBeanList}" varStatus="status">
															<li><a href="${pageContext.request.contextPath}/exhibition/UserView.ex?member_seq=${followerSeqList[status.index]}">${followerIdList[status.index]}</a></li>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<li>팔로우하는 작가가 없습니다</li>
													</c:otherwise>
												</c:choose>
											</ul>
										</div>
									</div>
								</li>
								<li class="modal_li">
									<button class="btn">팔로잉</button> <!-- 네 번째 Modal -->
									<div class="modal">

										<!-- 네 번째 Modal의 내용 -->
										<div class="modal-content"
											style="height: 50%; overflow-y: scroll;">
											<span class="close">&times;</span>
											<ul style="display:contents;">
												<!-- 팔로워를 클릭하면 상대방에게 이동합니다 -->
												<!-- <li><input type="text" placeholder="검색"></li> -->
												<c:choose>
													<c:when test="${followingBeanList!=null }">
														<c:forEach var="followingBean" items="${followingBeanList}" varStatus="status">
															<li><a href="${pageContext.request.contextPath}/exhibition/UserView.ex?member_seq=${followingSeqList[status.index]}">${followingIdList[status.index]}</a></li>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<li>팔로잉하는 작가가 없습니다</li>
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

				<!-- 내 전시회 보기 -->
				<div class="col-12" style="text-align: center">
					<span style="font-size: 1.5em">My Exhibition</span>

					<form name="makeexhibitionForm"
						action="${pageContext.request.contextPath}/exhibition/ExhibitionUpload.ex?member_seq=${memberBean.getMember_seq()}"
						method="post">
						<input type="hidden" name="session_seq" value="${session_seq}" />
					</form>
					<ul class="actions" id="makebtn">
						<li><a href="javascript:makeexhibitionForm.submit()"
							class="button primary icon solid fa-images">make</a></li>
					</ul>
					<ul class="recent_exhibition_list">
						<c:choose>
							<c:when test="${list!=null}">
								<c:forEach var="e_bean" items="${list}" varStatus="status">
									<li><a
										href="${pageContext.request.contextPath}/exhibition/ExhibitionView.ex?exhibition_seq=${e_bean.getExhibition_seq()}">
											<img
											src="${pageContext.request.contextPath}/app/photo/upload/${e_bean.getMain_photo_data()}"
											class="item_img image fit">
									</a> 
									<p>${e_bean.getExhibition_name()}</p>
									<a href="${pageContext.request.contextPath}/exhibition/ExhibitionModify.ex?exhibition_seq=${e_bean.getExhibition_seq()}">수정하기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath}/exhibition/ExhibitionDelete.ex?exhibition_seq=${e_bean.getExhibition_seq()}">삭제하기</a>
									</li>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr height="50px">
									<td colspan="5" align="center">등록된 게시물이 없습니다. 아직 전시회는 페이징
										없이 모든 전시회가 리스트로 나열됩니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<hr>
				<!-- 전체 전시회 -->

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
									<td colspan="5" align="center">등록된 사진이 없습니다. '사진 관리'로 가시거나 '더 보기'를 눌러주세요.</td>
									</tr>
							</c:otherwise>
									</c:choose>
								</div>
							</div>


						</div>
					</td>
				</tr>
			</table>
				

				<form name="morePictureForm"
					action="${pageContext.request.contextPath}/photo/PhotoView.ph?member_seq=${memberBean.getMember_seq()}"
					method="post">
					<input type="hidden" name="session_seq" value="${session_seq}" />
				</form>
				<ul>
					<li id="more" style="text-align:center;"><a href="javascript:morePictureForm.submit()"
						class="button ">더 보기</a></li>
				</ul>
				<%-- <form name="temporary" action="${pageContext.request.contextPath}/exhibition/exhibitionPhotoOk.ex?member_seq=${memberBean.getMember_seq()}" method="post">
                           <input type="hidden" name="session_seq" value="${session_seq}"/>
                </form>
                <ul>
               		<li id="more"><a href="javascript:temporary.submit()" class="button ">임시 전시회 사진선택 페이지 </a></li>
                </ul>  --%>
			</section>
		</div>



	</div>


	<!-- Footer -->
		<jsp:include page="footer.jsp" />


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
		// Modal을 가져옵니다.
		var modals = document.getElementsByClassName("modal");
		// Modal을 띄우는 클래스 이름을 가져옵니다.
		var btns = document.getElementsByClassName("btn");
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
		var files;

		$(document).ready(function() {
			var obj = $("#dragandrophandler");

			obj.on('dragenter', function(e) {
				e.stopPropagation();
				e.preventDefault();
				$(this).css('border', '2px solid #0B85A1');
			});
			obj.on('dragover', function(e) {
				e.stopPropagation();
				e.preventDefault();
			});
			obj.on('drop', function(e) {

				$(this).css('border', '2px dotted #0B85A1');
				e.preventDefault();
				files = e.originalEvent.dataTransfer.files;

				//We need to send dropped files to Server
				handleFileUpload(files, obj);
			});

			$(document).on('dragenter', function(e) {
				e.stopPropagation();
				e.preventDefault();
			});
			$(document).on('dragover', function(e) {
				e.stopPropagation();
				e.preventDefault();
				obj.css('border', '2px dotted #0B85A1');
			});
			$(document).on('drop', function(e) {
				e.stopPropagation();
				e.preventDefault();
			});

		});

		// 파일 멀티 업로드
		function handleFileUpload(files, obj) {
			if (confirm(files.length + "개의 파일을 업로드 하시겠습니까?")) {
				var data = new FormData();

				data.append('_token', '{{ Session::token() }}');

				for (var i = 0; i < files.length; i++) {
					data.append('file[]', files[i]);
				}

				var url = "{{url('/upload')}}";
				$.ajax({
					url : url,
					method : 'POST',
					data : data,
					dataType : 'json',
					processData : false,
					contentType : false,
					success : function(res) {
						// for(var i=0; i < files.length; i++){
						//     alert(files[i].name + " - " + files[i].size);
						// }
					}
				});

				for (var i = 0; i < files.length; i++) {
					// 드래그 앤 드롭으로 업로드된 파일 리스트 작성
					// 사진 미리보기는 px부분을 수정하면 됩니다. 미리보기가 있으면 좋긴 하겠는데 리스트 모양이 망가지네요
					$('#status1')
							.append(
									'<div id="file_result_'+i+'"><span>'
											+ files[i].name
											+ " - "
											+ files[i].size
											+ '</span>'
											+ '<input type="button" value="삭제" onclick="delete_file('
											+ i
											+ ')">'
											+ '<img id="file_img_'+i+'" width="100px" height="100px">'
											+ '</div>');

					// 이미지 미리보기
					var reader = new FileReader();
					var j = 0;
					reader.onload = function(e) {
						document.getElementById('file_img_' + j).src = e.target.result;
						// $('#file_img_'+i).attr('src', rst.target.result);
						j++;
					}
					reader.readAsDataURL(files[i]);
				}

			}
		}

		//사진 삭제
		function delete_file(idx) {
			if (confirm(files[idx].name + "을 삭제하시겠습니까?")) {
				var data = new FormData();

				data.append('_token', '{{ Session::token() }}');
				data.append('_method', 'DELETE');
				data.append('file_name', files[idx].name);

				$.ajax({
					url : "{{url('/upload/1')}}",
					method : 'POST',
					data : data,
					dataType : 'json',
					processData : false,
					contentType : false,
					success : function(data) {
						// alert(data);
					}
				});

				$('#file_result_' + idx).remove();
			}
		}
	</script>
</body>
</html>