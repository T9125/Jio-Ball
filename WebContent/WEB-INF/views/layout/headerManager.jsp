<%-- <%@page import="dto.UserInfo"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="en">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>JB manager</title>
    <link rel="stylesheet" href="../../assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../assets/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="../../assets/vendors/jvectormap/jquery-jvectormap.css">
    <link rel="stylesheet" href="../../assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="../../assets/vendors/owl-carousel-2/owl.carousel.min.css">
    <link rel="stylesheet" href="../../assets/vendors/owl-carousel-2/owl.theme.default.min.css">
    <link rel="stylesheet" href="../../assets/css/style.css">
    <link rel="shortcut icon" href="../../assets/images/favicon.png">
    
</head>
<body>	

<div class="container-scroller">
     <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <div class="sidebar-brand-wrapper d-none d-lg-flex align-items-center justify-content-center fixed-top">
          <h1>J B Manager</h1>
        </div>
        <ul class="nav">
         <li class="nav-item nav-category">
            <span class="nav-link">관리</span>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="/manager/userlist">
              <span class="menu-icon">
                <i class="mdi mdi-account-search text-light"></i>
              </span>
              <span class="menu-title text-light">유저 관리</span>
            </a>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="">
              <span class="menu-icon">
                <i class="mdi mdi-dribbble text-light"></i>
              </span>
              <span class="menu-title text-light">매칭 관리</span>
            </a>
          </li>
          <li class="nav-item menu-items">
           <a class="nav-link" href="">
              <span class="menu-icon">
                <i class="mdi mdi-cart-outline text-light"></i>
              </span>
              <span class="menu-title text-light">결제 관리</span>
            </a>
          </li>
           <li class="nav-item menu-items">
           <a class="nav-link" href="/manager/ground/groundlistboard">
              <span class="menu-icon">
                <i class="mdi mdi-home-variant text-light"></i>
              </span>
              <span class="menu-title text-light">구장 관리</span>
            </a>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-icon">
                <i class="mdi mdi-comment-question-outline text-light"></i>
              </span>
              <span class="menu-title text-light">고객센터</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="">공지사항</a></li>
                <li class="nav-item"> <a class="nav-link" href="">문의게시판</a></li>
              </ul>
            </div>
          </li>
        </ul>
      </nav>
      <div class="container-fluid page-body-wrapper">
      <nav class="navbar p-0 fixed-top d-flex flex-row">
          <div class="navbar-menu-wrapper flex-grow d-flex align-items-stretch">
            <ul class="navbar-nav navbar-nav-right">
             <% if(session.getAttribute("managerno") != null) { %>
             <li class="nav-item nav-settings d-none d-lg-block">
                  <i class="mdi mdi-checkbox-blank-circle text-success"></i>
             </li>
              <li class="nav-item dropdown">
                  <div class="navbar-profile">
                    <p class="mb-0 d-none d-sm-block navbar-profile-name">&nbsp;Manager : <%= session.getAttribute("managerno") %></p>
                  </div>
              </li>
              <li class="nav-item nav-settings d-none d-lg-block">
                <a class="nav-link" href="/manager/logout">
                  <i class="mdi mdi-logout text-danger"> Logout</i>
                </a>
              </li>
              <% } else {%>
              <li class="nav-item nav-settings d-none d-lg-block">
                <a class="nav-link" href="/manager/login">
                  <i class="mdi mdi-login text-success"> Login</i>
                </a>
              </li>
              <% } %>
            </ul>
          </div>
        </nav>
        <div class="main-panel">
          <div class="content-wrapper">