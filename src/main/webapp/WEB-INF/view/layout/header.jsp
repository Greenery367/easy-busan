<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/layout/header.css">
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/layout/footer.css">
<link rel="stylesheet" href="/css/layout/index.css">
<link rel="stylesheet" href="/css/font.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<header>
		<section class="black-box">
		<c:choose>
			<c:when test="${princaipal} !=null">
			<div class="login-btn">로그아웃</div>
			</c:when>
			<c:otherwise>
					<div class="busan-logo"><img  src=""></div>
				<a href="">
					<div class="login-btn">로그인</div>
				</a>

			</c:otherwise>
		</c:choose>
		</section>
	</header>

	<section class="top-content">
		<section class="top-box">
				
			<div class="cloud"></div>
			<div class="cloud"></div>
			<div class="cloud"></div>

			<div class="container">
				<div class="logo">
					<a href="#"><img src="/images/buki.png"></a>
				</div>
				<div class="header-nav-box">


					<a href="#">소개</a>
					<a href="#">서비스</a> 
					<a href="#">문의</a> 
					<a href="#">커뮤니티</a>



				</div>
			</div>
		</section>
	</section>

	<script type="text/javascript" src="/js/header.js"></script>