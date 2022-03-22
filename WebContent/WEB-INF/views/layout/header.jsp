<%-- <%@page import="dto.UserInfo"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="UTF-8">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>JIO BAll</title>
    
    <link rel="stylesheet" href="/assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="/assets/vendors/css/vendor.bundle.base.css">
    
    <link rel="stylesheet" href="/assets/vendors/select2/select2.min.css">
    <link rel="stylesheet" href="/assets/vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
    
    <!--  -->
    <link rel="stylesheet" href="/assets/vendors/jvectormap/jquery-jvectormap.css">
    <link rel="stylesheet" href="/assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="/assets/vendors/owl-carousel-2/owl.carousel.min.css">
    <link rel="stylesheet" href="/assets/vendors/owl-carousel-2/owl.theme.default.min.css">
  	<!--  -->
  
    <link rel="stylesheet" href="/assets/css/style.css">
    <link rel="shortcut icon" href="/assets/images/favicon.png">
    
    <!-- script  -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="/assets/js/file-upload.js"></script>
</head>
<body>	

<div class="container-scroller">
     <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <div class="sidebar-brand-wrapper d-none d-lg-flex align-items-center justify-content-center fixed-top">
          <h1>J I O B A L L</h1>
        </div>
        <ul class="nav">
         <li class="nav-item nav-category">
            <span class="nav-link">매치</span>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="">
              <span class="menu-icon">
                <i class="mdi mdi-dribbble text-primary"></i>
              </span>
              <span class="menu-title">Mactching</span>
            </a>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="/ground/groundList">
              <span class="menu-icon">
                <i class="mdi mdi-home-variant text-danger"></i>
              </span>
              <span class="menu-title">Ground</span>
            </a>
          </li>
          <li class="nav-item menu-items">
           <a class="nav-link" href="">
              <span class="menu-icon">
                <i class="mdi mdi-account-multiple text-warning"></i>
              </span>
              <span class="menu-title">My team</span>
            </a>
          </li>
           <li class="nav-item menu-items">
           <a class="nav-link" href="">
              <span class="menu-icon">
                <i class="mdi mdi-account-circle text-info"></i>
              </span>
              <span class="menu-title">My page</span>
            </a>
          </li>
          <li class="nav-item nav-category">
            <span class="nav-link"></span>
          </li>
          <li class="nav-item nav-category">
            <span class="nav-link">고객지원</span>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-icon">
                <i class="mdi mdi-comment-processing-outline text-secondary"></i>
              </span>
              <span class="menu-title">Jio service</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="">소개</a></li>
                <li class="nav-item"> <a class="nav-link" href="">공지사항</a></li>
                <li class="nav-item"> <a class="nav-link" href="">고객센터</a></li>
              </ul>
            </div>
          </li>
        </ul>
      </nav>
      <div class="container-fluid page-body-wrapper">
      <nav class="navbar p-0 fixed-top d-flex flex-row">
          <div class="navbar-menu-wrapper flex-grow d-flex align-items-stretch">
            <ul class="navbar-nav navbar-nav-right">
              <li class="nav-item dropdown d-none d-lg-block">
                <a class="nav-link btn btn-primary create-new-button" id="createbuttonDropdown" data-toggle="dropdown" aria-expanded="false" href="#">매칭 모집 하기</a>
              </li>
             <% if(session.getAttribute("teamno") != null) { %>
             <li class="nav-item nav-settings d-none d-lg-block">
                  <i class="mdi mdi-checkbox-blank-circle text-success"></i>
             </li>
              <li class="nav-item dropdown">
                  <div class="navbar-profile">
                    <p class="mb-0 d-none d-sm-block navbar-profile-name">&nbsp;<%= session.getAttribute("username") %></p>
                  </div>
              </li>
              <li class="nav-item nav-settings d-none d-lg-block">
                <a class="nav-link" href="">
                  <i class="mdi mdi-logout text-danger"> Logout</i>
                </a>
              </li>
              <% } else {%>
              <li class="nav-item nav-settings d-none d-lg-block">
                <a class="nav-link" href="">
                  <i class="mdi mdi-login text-success"> Login</i>
                </a>
              </li>
              <% } %>
            </ul>
          </div>
        </nav>
        <div class="main-panel">
        <div class="content-wrapper">
