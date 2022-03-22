<%@page import="dto.GroundInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% List<GroundInfo> groundInfo = (List)request.getAttribute("groundList"); %>

<%@ include file="../layout/header.jsp" %>

<div class="page-header">
	<h3 class="page-title">JIO BALL</h3>
</div>
<div class="row">
	<div class="col-lg-12 grid-margin">
		<div class="card">
			<div class="card-body">
				<div class="form">
					<form action="/ground/groundlist" method="get" class="form-wrap">
						<select class="form-control form-select form-select-playLocal" name="playlocalNo">
							<option value="0" selected>지역</option>
							<option value="1">김해</option>
							<option value="2">부산</option>
							<option value="3">양산</option>
							<option value="4">진주</option>
							<option value="5">창원</option>
						</select>
						<input class="form-control form-input form-input-search" type="text" name="searchValue" placeholder="검색">
						<button type="button" id="btn-ground-search" class="btn btn-sm btn-primary btn-ground-search">검색</button>
					</form>
				</div>
				
				<div class="ground-list-wrap">
				<% for(int i=0; i< groundInfo.size(); i++) { %>
				<div class="col-xl-auto col-sm-8 grid-margin stretch-card">
					<div class="ground-list">
						<a href="/ground/view?groundNo=${groundInfo.getGroundNo}"><img class="ground-list-img" alt="" src="<%=groundInfo.get(i).getGroundImgPath() %>/<%=groundInfo.get(i).getGroundImgName() %>.jpg"></a>
						<div class="ground-list-content">
							<a class="ground-list-name" href="/ground/view?groundNo=<%=groundInfo.get(i).getGroundNo() %>"><%=groundInfo.get(i).getGroundName() %></a>
							<a class="ground-list-location" href="/ground/view?groundNo=<%=groundInfo.get(i).getGroundNo() %>"><%=groundInfo.get(i).getGroundLocation() %></a>
						</div>
					</div>
				</div>
				<% } %>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="paging.jsp" %>
<%@ include file="../layout/footer.jsp" %>

<script src="/assets/js/btn-ground-search.js"></script>
})