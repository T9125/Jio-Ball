// 카카오 주소 찾기
document.getElementById("groundLocationSearch").addEventListener("click", function(){
	new daum.Postcode({
		oncomplete: function(data) {
		document.getElementById("groundLocation").value = data.address;
		}
	}).open();
});