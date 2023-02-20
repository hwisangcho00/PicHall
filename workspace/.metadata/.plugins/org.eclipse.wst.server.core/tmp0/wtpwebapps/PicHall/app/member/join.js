/**
 * 회원가입
 */

var idCheck = false;
var emailCheck = false;

function formSubmit() {
	var form = document.joinForm;

	//이름 검사
	if(form.member_name.value==""){
		alert("이름을 입력해주세요.");
		form.member_name.focus();
		return false;
	}
	//아이디 검사
	if(form.member_id.value==""){
		alert("아이디를 입력해주세요.");
		form.member_id.focus();
		return false;
	}
	
	if(!idCheck) {
		alert("중복된 아이디입니다");
		form.member_id.focus();
		return false;
	}
	
	//닉네임 검사
	if(form.member_nickname.value==""){
		alert("닉네임을 입력해주세요.");
		form.member_nickname.focus();
		return false;
	}
	
	if(!emailCheck) {
		alert("중복된 이메일입니다");
		form.member_email.focus();
		return false;
	}
	
	//패스워드 검사
	if(form.member_pw.value==""){
		alert("패스워드를 입력해주세요.")
		form.member_pw.focus();
		return false;
	}else{
		//8자리 이상, 대문자/소문자/숫자/특수문자 모두 포함되어 있는 지 검사
		var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;//true면 정상, false이면 잘못됨
		var hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		if(!reg.test(form.member_pw.value)){
			alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
			form.member_pw.focus();
			return false;
		}
		else if(hangleCheck.test(form.member_pw.value)){
			alert("비밀번호에 한글을 사용할 수 없습니다.")
			form.member_pw.focus();
			return false;
		}
		//비밀번호에 공백을 포함할 수 없다.
		else if(form.member_pw.value.search(/\s/)!=-1){
			alert("비밀번호에 공백 없이 입력해주세요.");
			form.member_pw.focus();
			return false;
		}
		if(form.member_pw.value!=form.member_pw_re.value){
			alert("패스워드를 확인해주세요");
			form.member_pw_re.focus();
			return false;
		}
		//약관동의 검사
		if(form.agree.checked == false){
			alert("약관을 읽고 동의해주세요.")
			return false;
		}
		
	$("#sign_up_btn").addClass("disabled");
	form.submit();
	}
}

function checkId(id){
	idCheck = false;
	if(id == ""){
		$("#idCheck_text").text("아이디를 작성해주세요.");
	}else{
		$.ajax({
			url:contextPath + "/member/MemberCheckIdOk.me?id="+id,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim() == "ok"){
					idCheck = true;
					$("#idCheck_text").text("사용할 수 있는 아이디입니다.");
				}else{
					$("#idCheck_text").text("중복된 아이디입니다.");
				}
			},
			error:function(){
				console.log("오류");
			}
		});
	}
}

function checkEmail(email){
	emailCheck = false;
	if(email == ""){
		$("#emailCheck_text").text("이메일을 작성해주세요.");
	}else{
		$.ajax({
			url:contextPath + "/member/MemberCheckEmailOk.me?email="+email,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim() == "ok"){
					emailCheck = true;
					$("#emailCheck_text").text("사용할 수 있는 이메일입니다.");
				}else{
					$("#emailCheck_text").text("중복된 이메일입니다.");
				}
			},
			error:function(){
				console.log("오류");
			}
		});
	}
}

$("input[name='member_id']").keyup(function(event){
	var id = $("input[name='member_id']").val();
	checkId(id);
});

$("input[name='member_email']").keyup(function(event){
	var email = $("input[name='member_email']").val();
	checkEmail(email);
});



















