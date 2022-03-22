<%@page import="dto.GroundInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../layout/headerManager.jsp" %>

<% List<GroundInfo> groundInfo = (List)request.getAttribute("groundBoardList"); %>

<div class="page-header">
	<h3 class="page-title">JIO BALL</h3>
</div>
<div class="row">
	<div class="col-lg-12 grid-margin">
		<div class="card">
			<div class="card-body">
				<form action="/manager/groundlistboard" method="get" class="forms-sample form-ground-top">
					<input type="text" class="form-control form-input input-ground-search" name="searchValue" placeholder="내용을 입력해주세요">
					<button type="button" id="btn-ground-search" class="btn btn-sm btn-primary btn-ground-search">검색</button>
					
					<button type="button" id="btn-ground-insert" class="btn btn-sm btn-primary btn-ground-insert">구장 등록</button>
				</form>
				
				<form action="/manager/update" method="get">
				<table class="table">	
					<thead>
						<tr>
							<th>No</th>
							<th>이름</th>
							<th>위치</th>
							<th>이용금액</th>
							<th>종목</th>
							<th>지역</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					
					<tbody>
						<% for(int i=0; i < groundInfo.size(); i++) { %>
						<tr>
							<td><%=groundInfo.get(i).getGroundNo() %></td>
							<td><%=groundInfo.get(i).getGroundName() %></td>
							<td><%=groundInfo.get(i).getGroundLocation() %></td>
							<td><%=groundInfo.get(i).getGroundFee() %></td>
							<td>
								<c:set var="playTypeNo"><%=groundInfo.get(i).getPlayTypeNo() %></c:set>
								<c:choose>
									<c:when test="${playTypeNo eq '1'}">
										풋살
									</c:when>
									<c:when test="${playTypeNo eq '2'}">
										축구
									</c:when>
								</c:choose>
							</td>
							<td>
								<c:set var="playLocalNo"><%=groundInfo.get(i).getPlayLocalNo() %></c:set>
								<c:choose>
									<c:when test="${playLocalNo eq '1'}">
										김해
									</c:when>
									<c:when test="${playLocalNo eq '2'}">
										부산
									</c:when>
									<c:when test="${playLocalNo eq '3'}">
										양산
									</c:when>
									<c:when test="${playLocalNo eq '4'}">
										진주
									</c:when>
									<c:when test="${playLocalNo eq '5'}">
										창원
									</c:when>
								</c:choose>
							</td>
							
							<td>
								<button type="button" class="btn btn-sm btn-primary btn-ground-update">수정</button>
							</td>
							<td>
								<a href="/manager/delete?groundNo=<%=groundInfo.get(i).getGroundNo() %>">삭제</a>
							</td>
						</tr>
						<% } %>
					</tbody>
				</table>
				</form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="/assets/js/btn-ground-search.js"></script>
<script src="/assets/js/btn-ground-insert.js"></script>
<script src="/assets/js/btn-ground-update.js"></script>

<%@ include file="../manager/paging.jsp" %>
<%@ include file="../layout/footerManager.jsp" %>