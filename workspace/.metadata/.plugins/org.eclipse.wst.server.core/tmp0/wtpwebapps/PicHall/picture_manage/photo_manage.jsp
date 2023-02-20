<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="${pageContext.request.contextPath}/picture_manage/js/jquery-1.7.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/picture_manage/js/lightbox.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" /><!--이건 받아옴  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/picture_manage/css/lightbox.css" />
	
	<style type="text/css">
		* {margin:0; padding:0;}
		ul,li {list-style:none;}
		img {border:none;}
		#lightBox li {float:left;}
		#lightBox li a {margin:0 10px 0 0;}
		#lightBox li a img{width:300px;}
	</style>
	
	<style>
		#lightBox{
			display:block;
			margin:0 auto;
		}
		@import url(fontawesome-all.min.css);
		body{
			background-color:#242629
		}
		
		/* Icon */

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
	<style>
ul{
   list-style: none;
   margin: none;
}
a{
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
#dragandrophandler{
    border:2px dotted #0B85A1;
    width:400px;
    color:#92AAB0;
    text-align:left;vertical-align:middle;
    padding:10px 10px 10 10px;
    margin-bottom:10px;
    font-size:200%;
}
</style>
</head>
<body>
	<c:set var="photo_seq" value="${requestScope.photo_seq}"/>
	<c:set var="photo_name" value="${requestScope.photo_name}"/>
	<c:set var="photo_text" value="${requestScope.photo_text }"/>
	<c:set var="memberBean" value="${requestScope.memberBean}"></c:set>
	<c:set var="photoBeanList" value="${requestScope.photoBeanList}"></c:set>
	<div id="lightBox">
		<ul>
		<!--해당이미ㅈ  -->
		<li><a href="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}" rel="lightbox[imgBox]" title="${photo_name}"><img src="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}" alt="" /></a></li>
			
		</ul>
		<table >
					<c:choose>
						<c:when test="${photoBeanList != null and fn:length(photoBeanList)>0}">
							<c:set var="i" value="${0}"></c:set>
							<!-- <tr>
								<th>번호</th>
								<th>제목</th>
								<th>아티스트</th>
								<th colspan="3" style="text-align:center">관리</th>
							</tr> -->
							<c:forEach var="photoBean" items="${photoBeanList}">
								<c:set var="i" value="${i+1}"/>
								<tr class="lightBox">
									<td >
										${i}
									</td>
									<td>
										<span>
										<a href="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}" rel="lightbox[imgBox]" title="${photo_name}"><img src="${pageContext.request.contextPath}/app/photo/upload/${photoBean.getPhoto_data()}" alt="" /></a>
										</span>
										
									</td>
									<td>
										<%-- <a href="${pageContext.request.contextPath}/photo/PhotoView.ph?photo_seq=${photo_seq}" rel="lightbox[imgBox]" title="${photo_name}"><img src="${pageContext.request.contextPath}/photo/PhotoView.ph?photo_seq=${photo_seq}" alt="" /></a>--%>
									 </td>
									<%-- <td style="text-align:center">
										<form id="deleteForm" method="post" action="${pageContext.request.contextPath}/photo/PhotoDeleteOk.ph">
											<input type="hidden" name="music_seq" value="${musicBean.getMusic_seq()}">
											<a onclick="deletePhoto()">삭제</a>
										</form>
									</td>
									<td style="text-align:center">
										<a onclick="showDisplay(${i})">듣기</a>
									</td> --%>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td style="text-align:center">
									아직 전시회에 등록할 사진이 없습니다.<br>전시회에 등록할 사진을 추가해보세요.<br>
									<button class="button primary">사진 업로드</button>
								</td>							
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
		
		
		<!--설정시 사용되는 속성
			var : 값을 설정할 EL변수의 이름
			value : 변수의 값을 설정(표현식, EL, 상수 사용 가능)
			scope : 변수가 저장되는 영역 설정(page | request | session | application 생략가능 생략시 기본값은 page)-->
			
			
			<ul class="actions small">
			<%-- <li><a href="${pageContext.request.contextPath}/photo/PhotoUploadOk.ph" class="button primary small">사진업로드</a></li>
				<input name="board_file1" type="file" class="button primary small">사진업로드</input> --%>
			<li><button class="button primary" >사진 업로드</button></li>
			</ul>

            <!-- 다섯 번째 Modal -->
            <div class="modal">

               <!-- 다섯 번째 Modal의 내용 -->
               <div class="modal-content">
                  <span class="close">&times;</span>
                  <p>사진업로드</p>
                  <form action="${pageContext.request.contextPath}/photo/PhotoUploadOk.ph" method="post" enctype="multipart/form-data" name="PhotoForm">
                  <input name="board_file1" type="file" class="button primary small"></input>
                  <a href="javascript:addboard()" class="button primary small">등록</a>
                  </form>
               </div>
            </div>
	</div>
</body>

<script>
/* 
 * 
 function deletePhoto(){
		if(confirm("사진을 삭제하시겠습니까?")){
			document.getElementById("deleteForm").submit();
		}	
	}

 */
 
 /*
function insertPhoto(){
	if(confirm("사진을 업로드하시겠습니까?")){
		document.getElementById("insertForm").submit();
	}
	
} */
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
   var btns = document.getElementsByClassName("button primary");
   // Modal을 닫는 close 클래스를 가져옵니다.
   var spanes = document.getElementsByClassName("close");
   var funcs = [];
    
   // Modal을 띄우고 닫는 클릭 이벤트를 정의한 함수
   function Modal(num) {
     return function() {
       // 해당 클래스의 내용을 클릭하면 Modal을 띄웁니다.
       btns[num].onclick =  function() {
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
   for(var i = 0; i < btns.length; i++) {
     funcs[i] = Modal(i);
   }
    
   // 원하는 Modal 수만큼 funcs 함수를 호출합니다.
   for(var j = 0; j < btns.length; j++) {
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
   function addboard(){
		PhotoForm.submit();
	}
   </script>
</html>