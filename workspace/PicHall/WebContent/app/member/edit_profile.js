/**
 * 회원가입
 */

var check = false;

function formSubmit() {
	var form = document.passwordForm;
	
	//패스워드 검사
	if(form.new_member_pw.value==""){
		alert("패스워드를 입력해주세요.")
		form.new_member_pw.focus();
		return false;
	}else{
		//8자리 이상, 대문자/소문자/숫자/특수문자 모두 포함되어 있는 지 검사
		var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;//true면 정상, false이면 잘못됨
		var hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		if(!reg.test(form.new_member_pw.value)){
			alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
			form.new_member_pw.focus();
			return false;
		}
		else if(hangleCheck.test(form.new_member_pw.value)){
			alert("비밀번호에 한글을 사용할 수 없습니다.")
			form.new_member_pw.focus();
			return false;
		}
		//비밀번호에 공백을 포함할 수 없다.
		else if(form.new_member_pw.value.search(/\s/)!=-1){
			alert("비밀번호에 공백 없이 입력해주세요.");
			form.new_member_pw.focus();
			return false;
		}
		if(form.new_member_pw.value!=form.new_member_pw_re.value){
			alert("패스워드를 확인해주세요");
			form.new_member_pw.focus();
			return false;
		}
		
	$(".button").addClass("disabled");
	form.submit();
	}
}

function checkId(id){
	check = false;
	if(id == ""){
		$("#idCheck_text").text("아이디를 작성해주세요.");
	}else{
		$.ajax({
			url:contextPath + "/member/MemberCheckIdOk.me?id="+id,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim() == "ok"){
					check = true;
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
$("input[name='member_id']").keyup(function(event){
	var id = $("input[name='member_id']").val();
	checkId(id);
});



















