// 구장 등록 팝업 버튼
$("#btn-ground-insert").on("click", function popup() {
	
	var popUrl = "/manager/insert";
	var popOption = "width=595, height=1170";
	
	window.open(popUrl, "_blank", popOption);
});