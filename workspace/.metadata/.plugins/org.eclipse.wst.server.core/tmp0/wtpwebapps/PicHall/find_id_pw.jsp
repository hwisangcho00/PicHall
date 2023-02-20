<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>PicHall 아이디/비밀번호 찾기</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" />
</noscript>
<style>
@media screen and (max-width: 736px) {
	.row .col-6 {
		width:100%
	}
	
	.col-1-small {
		display:none;
	}
}
</style>
</head>
<body class="is-preload">
	<!-- Main -->
	<div id="main">

		<!-- Post -->
		
		<section class="post">
			<header class="major">
				<h1>
					PicHall<br style="display:block">비밀번호/아이디 찾기
				</h1>
			</header>
			<hr>

			<div class="row gtr-uniform">
				<div class="col-6">
					<div class="col-1-small">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					<div class="col-5 col-12-xsmall box">
						<h3>아이디 찾기</h3>
					 <label>이름 입력</label> <input type="text"
							name="member_name" id="member_name" value="" placeholder="이름"/>
						<br> <label>이메일 입력</label> <input type="email"
							name="member_email" id="member_email" value=""
							placeholder="email@pichall.com" /> <br>
						<a onclick="getId()" id="getId" class="button primary fit">아이디 확인하기</a>
					</div>
				</div>

				<div class="col-6">
					<div class="col-1-small">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					<div class="col-5 col-12-xsmall box">
						<h3>비밀번호 찾기</h3>
						<form name="findPwForm" method="post" action="${pageContext.request.contextPath}/member/MemberFindPwOk.me">
							<label>아이디 입력</label> <input type="text" name="member_id"
								id="member_id" value="" placeholder="5~15자리" /> <br> <label>이메일
								입력</label> <input type="email" name="member_email_pw" id="member_email_pw"
								value="" placeholder="email@pichall.com" /> <br> 
								<a onclick="submit()" id="submit" class="button primary fit">임시 비밀번호 발급</a>
						</form>
					</div>
				</div>

				<div class="col-6 col-6-xsmall" style="margin: 0 auto">
					<a href="${pageContext.request.contextPath}/member/MemberJoin.me" class="button fit"
						style="margin-bottom: 0.5em">계정 만들기</a> 
						<a href="${pageContext.request.contextPath}/member/MemberLogin.me"
						class="button primary fit">로그인 페이지로 이동</a>
				</div>
			</div>
		</section>

	</div>
</body>
<!-- Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script>
	var contextPath = "${pageContext.request.contextPath}";
	
	function submit() {
		if($("#member_email_pw").val() == "") {
			alert("이메일을 입력해주세요");
			return false;
		}
		
		if($("#member_id").val() == ""){
			alert("아이디를 입력해주세요");
			return false;
		}
		
		$("#submit").addClass("disabled");
		
		document.findPwForm.submit();
		
	}
	
	function getId(){
		var name = $("#member_name").val()
		var email = $("#member_email").val();
		
		
		if(name == "") {
			alert("이름을 입력해주세요");
			return false;
		}
		
		if(email == "") {
			alert("이메일을 입력해주세요");
			return false;
		}
		
		$("#getId").addClass("disabled");
		
		$.ajax({
			url:contextPath + "/member/MemberFindIdOk.me?name="+name +"&email="+email,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim() == "no"){
					alert("존재하지 않는 아이디입니다");
				}else{
					alert("아이디 : " + result.trim());
				}
				
				$("#getId").removeClass("disabled")
				
			},
			error:function(){
				console.log("오류");
			}
		});
		
		
		
	}
</script>
</html>