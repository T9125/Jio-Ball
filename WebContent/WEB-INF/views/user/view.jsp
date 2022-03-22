<%@page import="dto.GroundInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% GroundInfo groundInfo = (GroundInfo)request.getAttribute("groundInfo"); %>

<%@ include file="../layout/header.jsp" %>

<div class="page-header">
	<h3 class="page-title">구장 상세보기</h3>
</div>
<div class="row">
	<div class="col-lg-12 grid-margin">
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-md-6 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<img class="ground-img" src="${groundInfo.getGroundImgPath()}/${groundInfo.getGroundImgName()}.jpg" alt="구장 사진">
							</div>
						</div>
					</div>
					
					<div class="col-md-6 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<div id="map" class="ground-location-api" ></div>
							</div>
						</div>
					</div>				
				</div>

				<div class="row">
					<div class="col-md-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<div class="ground-name">
									<p>구장명</p>
									<p>${groundInfo.getGroundName()}</p>
								</div>
								
								<div class="ground-location">
									<p>구장 주소</p>
									<p>${groundInfo.getGroundLocation()}</p>
								</div>
								
								<div class="ground-time">
									<p>이용가능 시간</p>
									<p>
										<c:set var="groundOpenTime">${groundInfo.getGroundOpenTime()}</c:set>
										<c:out value="${fn:substring(groundOpenTime, 10, 19)}"/>
										<label>~</label>
										<c:set var="groundCloseTime">${groundInfo.getGroundCloseTime()}</c:set>
										<c:out value="${fn:substring(groundCloseTime, 10, 19)}"/>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
							
							
				<div class="row ground-facility-information">
					<div class="col-md-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<p>시설 정보</p>
									
								<div class="row">
									<div class="col-md-2 col-xl-4 grid-margin stretch-card">
										<div class="card">
											<div class="card-body">
												<div class="ground-size">
													<p>구장 크기</p>
													<p>${groundInfo.getGroundSize()}</p>
												</div>
											</div>
										</div>
									</div>
									
									<div class="col-md-2 col-xl-4 grid-margin stretch-card">
										<div class="card">
											<div class="card-body">
												<div class="ground-shower">
													<p>샤워장</p>
													<p>
														<c:set var="groundShower">${groundInfo.getGroundShower()}</c:set>
														<c:choose>
															<c:when test="${groundShower eq '1'}">
																<label>사용 가능</label>
															</c:when>
															
															<c:otherwise>
																<label>사용 불가</label>
															</c:otherwise>
														</c:choose>
													</p>
												</div>
											</div>
										</div>
									</div>
									
									<div class="col-md-2 col-xl-4 grid-margin stretch-card">
										<div class="card">
											<div class="card-body">
												<div class="ground-parking">
													<p>주차장</p>
													<p>
														<c:set var="groundParking">${groundInfo.getGroundParking()}</c:set>
														<c:choose>
															<c:when test="${groundParking eq '1'}">
																<label>사용 가능</label>
															</c:when>
															
															<c:otherwise>
																<label>사용 불가</label>
															</c:otherwise>
														</c:choose>
													</p>
												</div>
											</div>
										</div>
									</div>
									
									<div class="col-md-2 col-xl-4 grid-margin stretch-card">
										<div class="card">
											<div class="card-body">
												<div class="ground-shoes">
													<p>신발</p>
													<p>
														<c:set var="groundShoes">${groundInfo.getGroundShoes()}</c:set>
														<c:choose>
															<c:when test="${groundShoes eq '1'}">
																<label>사용 가능</label>
															</c:when>
															
															<c:otherwise>
																<label>사용 불가</label>
															</c:otherwise>
														</c:choose>
													</p>
												</div>
											</div>
										</div>
									</div>
									
									<div class="col-md-2 col-xl-4 grid-margin stretch-card">
										<div class="card">
											<div class="card-body">
												<div class="ground-bib">
													<p>조끼</p>
													<p>
														<c:set var="groundBib">${groundInfo.getGroundBib()}</c:set>
														<c:choose>
															<c:when test="${groundBib eq '1'}">
																<label>사용 가능</label>
															</c:when>
															
															<c:otherwise>
																<label>사용 불가</label>
															</c:otherwise>
														</c:choose>
													</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<div class="ground-notice">
									<p>특이사항</p>
									<p>${groundInfo.getGroundNotice()}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	0e3144b3924eaadf50f935512c5d1ba4&libraries=services"></script>
<script type="text/javascript">let groundLocation = "${groundInfo.getGroundLocation()}"</script>
<script src="/assets/js/kakao-map.js"></script>

<%@ include file="../layout/footer.jsp" %>