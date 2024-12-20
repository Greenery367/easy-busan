<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>이지부산</title>
		<link rel="stylesheet" href="/css/layout/header.css">
		<link rel="stylesheet" href="/css/common.css">
		<link rel="stylesheet" href="/css/layout/footer.css">
		<link rel="stylesheet" href="/css/layout/index.css">
		<link rel="stylesheet" href="/css/font.css">
		<link rel="stylesheet" href="/css/result.css">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	</head>

	<body>
		<header>
			<section class="topbar">
				<c:choose>
					<c:when test="${sessionUser != null}">
					<div class="my-name"><img src="/images/icon/icon_login_white.png" ><span>${sessionUser.userName}</span> 
					<div class="hello">님 안녕하세요</div></div>
						<a href="/user/logout" class="no-underline">
							<span class="bt-logout">로그아웃</span>
						</a>
					</c:when>
					<c:otherwise>

						<a href="/user/login" class="no-underline">
							<span class="bt-login">
								<img class="icon-login" src="/images/icon_login.png" /> 로그인
							</span>
						</a>

					</c:otherwise>
				</c:choose>
			</section>

			<section class="top-content">
				<section class="top-box">


					<div class="container">


						<div class="header-nav-box">

							<a href="/"><img src="/images/img_logo_white.png"></a>
							<div class="nav-group">
								<a href="/">
									<div class="text-wrapper">소개</div>
								</a>
								<a href="/question">
									<div class="text-wrapper">서비스</div>
								</a>
								<a href="info">
									<div class="text-wrapper">정책</div>
								</a>
								<a href="#">
									<div class="text-wrapper">커뮤니티</div>
								</a>
							</div>



						</div>
					</div>
				</section>
			</section>
		</header>

		<script type="text/javascript" src="/js/header.js"></script>