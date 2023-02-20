/**
 * 업로드
 */

function formSubmit() {
	var form = document.uploadForm;

	//제목 검사
	if(form.exhibition_name.value==""){
		alert("제목을 입력해주세요.");
		form.exhibition_name.focus();
		return false;
	}
	//전시회 설명 검사
	if(form.exhibition_text.value==""){
		alert("설명을 입력해주세요.");
		form.exhibition_text.focus();
		return false;
	}
	//종료날짜 검사
	if(form.start_date.value >= form.end_date.value){
		alert("날짜를 다시 선택해주세요.");
		form.end_date.focus();
		return false;
	}
	if(form.start_date.value == null||form.end_date.value==null){
		alert("날짜를 선택해주세요.");
		form.start_date.focus();
		return false;
	}
	
/*	console.log(form.exhibition_category_big.value)
	console.log(form.exhibition_category_big[0])*/
	
	//카테고리 검사
	if(form.exhibition_category_big.value==form.exhibition_category_big[0].text){
		alert("대카테고리를 선택해주세요.");
		return false;
	}
	
	
	form.submit();
	
}