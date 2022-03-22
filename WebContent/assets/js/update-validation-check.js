// 유효성 검사
function updateValidationCheck() {
	var regGroundName = /^[a-z|A-Z|0-9|ㄱ-ㅎ|가-힣]/;		// 한글, 영어, 숫자
	
	var groundForm = document.groundForm;
	var groundName = groundForm.groundName.value;
	
	// 이름 유효성 검사
	if (!regGroundName.test(groundName)) {
		alert("이름은 한글, 영어, 숫자만 입력이 가능합니다.")
		groundForm.groundName.focus();
		return false;
	} else {
		alert("수정 완료")
		return true;
	}
};