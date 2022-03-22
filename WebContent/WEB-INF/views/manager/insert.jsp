<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>JIO BAll</title>

<link rel="stylesheet" href="/assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="/assets/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" href="/assets/vendors/select2/select2.min.css">
<link rel="stylesheet" href="/assets/vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
<link rel="stylesheet" href="/assets/vendors/jvectormap/jquery-jvectormap.css">
<link rel="stylesheet" href="/assets/vendors/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" href="/assets/vendors/owl-carousel-2/owl.carousel.min.css">
<link rel="stylesheet" href="/assets/vendors/owl-carousel-2/owl.theme.default.min.css">
<link rel="stylesheet" href="/assets/css/style.css">
<link rel="shortcut icon" href="/assets/images/favicon.png">
</head>

<body>	
<div class="content-wrapper">
	<div class="page-header">
		<h3 class="page-title">구장 등록</h3>
	</div>
	<div class="row">
		<div class="col-lg-12 grid-margin">
			<div class="card">
				<div class="card-body">
					<form action="/manager/insert" method="post" onsubmit="return insertValidationCheck();" class="forms-sample" name="groundForm">
						<table class="table">
							<tr>
								<th>이름</th>
								<td><input type="text" class="form-control form-input" name="groundName" placeholder="내용을 입력해주세요"></td>
							</tr>
							<tr>
					            <th>주소</th>
					            <td>
					            	<input type="text" id="groundLocation" class="form-control form-input input-location-search" name="groundLocation" readonly="readonly">
					            	<button type="button" id="groundLocationSearch" class="btn btn-sm btn-primary btn-location-search" name="groundLocationSearch">검색</button>
					            </td>
					        </tr>
							<tr>
								<th>종목</th>
								<td>
									<div class="form-check">
										<label for="futsal" class="form-check-label form-radio-label">
										<input type="radio" id="futsal" class="form-radio-input" name="playTypeNo" value="1" checked>풋살</label>
									</div>
									
									<div class="form-check">
										<label for="football" class="form-check-label form-radio-label">
										<input type="radio" id="football" class="form-radio-input form-check-primary" name="playTypeNo" value="2">축구</label>
									</div>	
								</td>
							</tr>
							<tr>
								<th>구장 크기</th>
								<td>
									<input type="number" id="groundSizeWidth" class="form-control ground-size-width" name="groundSizeWidth" placeholder="가로">
									<input type="number" id="groundSizeHeight" class="form-control ground-size-height" name="groundSizeHeight" placeholder="세로">
								</td>
							</tr>
							<tr>
								<th>시설 정보</th>
								<td>
									<div class="form-check">
										<label for="groundShower" class="form-check-label form-check-label">
										<input type="checkbox" id="groundShower" class="form-check-input" name="groundShower" value="1">샤워장</label>
									</div>
									
									<div class="form-check">
										<label for="groundParking" class="form-check-label form-check-label">
										<input type="checkbox" id="groundParking" class="form-check-input" name="groundParking" value="1">무료 주차장</label>
									</div>
									
									<div class="form-check">
										<label for="groundShoes" class="form-check-label form-check-label">
										<input type="checkbox" id="groundShoes" class="form-check-input" name="groundShoes" value="1">풋살 대여</label>
									</div>
									
									<div class="form-check">
										<label for="groundBib" class="form-check-label form-check-label">
										<input type="checkbox" id="groundBib" class="form-check-input" name="groundBib" value="1">조끼 대여</label>
									</div>
								</td>
							</tr>
							<tr>
								<th>오픈 시간</th>
								<td>
									<select class="form-control form-select" name="groundOpenTime">
										<option value="00:00:00">00:00</option>
										<option value="01:00:00">01:00</option>
										<option value="02:00:00">02:00</option>
										<option value="03:00:00">03:00</option>
										<option value="04:00:00">04:00</option>
										<option value="05:00:00">05:00</option>
										<option value="06:00:00">06:00</option>
										<option value="07:00:00">07:00</option>
										<option value="08:00:00">08:00</option>
										<option value="09:00:00">09:00</option>
										<option value="10:00:00">10:00</option>
										<option value="11:00:00">11:00</option>
										<option value="12:00:00">12:00</option>
										<option value="13:00:00">13:00</option>
										<option value="14:00:00">14:00</option>
										<option value="15:00:00">15:00</option>
										<option value="16:00:00">16:00</option>
										<option value="17:00:00">17:00</option>
										<option value="18:00:00">18:00</option>
										<option value="19:00:00">19:00</option>
										<option value="20:00:00">20:00</option>
										<option value="21:00:00">21:00</option>
										<option value="22:00:00">22:00</option>
										<option value="23:00:00">23:00</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<th>마감 시간</th>
								<td>
									<select class="form-control form-select" name="groundCloseTime">
										<option value="00:00:00">00:00</option>
										<option value="01:00:00">01:00</option>
										<option value="02:00:00">02:00</option>
										<option value="03:00:00">03:00</option>
										<option value="04:00:00">04:00</option>
										<option value="05:00:00">05:00</option>
										<option value="06:00:00">06:00</option>
										<option value="07:00:00">07:00</option>
										<option value="08:00:00">08:00</option>
										<option value="09:00:00">09:00</option>
										<option value="10:00:00">10:00</option>
										<option value="11:00:00">11:00</option>
										<option value="12:00:00">12:00</option>
										<option value="13:00:00">13:00</option>
										<option value="14:00:00">14:00</option>
										<option value="15:00:00">15:00</option>
										<option value="16:00:00">16:00</option>
										<option value="17:00:00">17:00</option>
										<option value="18:00:00">18:00</option>
										<option value="19:00:00">19:00</option>
										<option value="20:00:00">20:00</option>
										<option value="21:00:00">21:00</option>
										<option value="22:00:00">22:00</option>
										<option value="23:00:00">23:00</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>이용 금액</th>
								<td>
									<input type="number" class="form-control form-input" name="groundFee">
								</td>
							</tr>
							<tr>
								<th>특이 사항</th>
								<td><textarea class="form-control textarea-input" name="groundNotice" placeholder="내용을 입력해주세요"></textarea></td>
							</tr>
							<tr>
								<th>구장 사진</th>
								<td>
									<input type="file" name="img[]" class="file-upload-default">
					               	<input type="text" class="form-control file-upload-info input-fileupload" readonly="readonly">
					               	<button class="file-upload-browse btn btn-primary btn-fileupload" type="button">파일</button>
								</td>
							</tr>
							
							<tr>
								<th></th>
								<td></td>
							</tr>
						</table>
							<button type="submit" id="btnInsert" class="btn btn-primary btn-icon-text btn-ground-insert-submit">구장 등록</button>
							<button type="button" id="btnCancel" class="btn btn-secondary btn-fw btn-cancle">닫기</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/assets/js/kakao-location-search.js"></script>
<script src="/assets/js/file-upload.js"></script>
<script src="/assets/js/btn-cancle.js"></script>
<script src="/assets/vendors/js/vendor.bundle.base.js"></script>
<script src="/assets/vendors/chart.js/Chart.min.js"></script>
<script src="/assets/vendors/progressbar.js/progressbar.min.js"></script>
<script src="/assets/vendors/jvectormap/jquery-jvectormap.min.js"></script>
<script src="/assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/assets/vendors/owl-carousel-2/owl.carousel.min.js"></script>
<script src="/assets/js/off-canvas.js"></script>
<script src="/assets/js/hoverable-collapse.js"></script>
<script src="/assets/js/misc.js"></script>
<script src="/assets/js/settings.js"></script>
<script src="/assets/js/todolist.js"></script>
<script src="/assets/js/dashboard.js"></script>
</body>
</html>