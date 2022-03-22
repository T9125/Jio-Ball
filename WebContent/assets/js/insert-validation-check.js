// 유효성 검사
function insertValidationCheck() {
	var regGroundName = /^[a-z|A-Z|0-9|ㄱ-ㅎ|가-힣]/;		// 한글, 영어, 숫자
	
	var groundForm = document.groundForm;
	var groundName = groundForm.groundName.value;
	var groundLocation = groundForm.groundLocation.value;
	var groundSizeWidth = groundForm.groundSizeWidth.value;
	var groundSizeHeight = groundForm.groundSizeHeight.value;
	var groundFee = groundForm.groundFee.value;
	var groundNotice = groundForm.groundNotice.value;
	
	// 이름 유효성 검사
	if (groundName == "") {
		alert("이름을 입력해주세요.");
		groundForm.groundName.focus();
		return false;
	} else if (!regGroundName.test(groundName)) {
		alert("이름은 한글, 영어, 숫자만 입력이 가능합니다.456")
		groundForm.groundName.focus();
		return false;
	}
	
	// 주소 유효성 검사
	if (groundLocation == "") {
		alert("주소를 입력해주세요")
		groundForm.groundLocationSearch.focus();
		return false;
	}
	
	// 크기 유효성 검사
	if (groundSizeWidth == "" || groundSizeHeight == "") {
		alert("구장 크기를 입력해주세요.")
		return false;
	}
	
	// 이용 금액 유효성 검사
	if (groundFee == "") {
		alert("금액을 입력해주세요.")
		groundForm.groundFee.focus();
		return false;
	}
	
	// 특이 사항 유효성 검사
	if (groundNotice == "") {
		alert("특이사항 입력해주세요.")
		groundForm.groundNotice.focus();
		return false;
	}
	
	alert("등록 완료")
	return true;
};