// 구장 수정 팝업 버튼
$(".btn-ground-update").on("click", function popup() {
	
	// groundNo 가져오기
	
	var row = $(this).closest('tr'); 
	var groundNo = row.find('td:eq(0)').text();
	
	var popUrl = "/manager/update?groundNo=" + groundNo;
	var popOption = "width=595, height=1170";
	
	window.open(popUrl, "_blank", popOption);
});