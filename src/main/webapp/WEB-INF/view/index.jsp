<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>

	<head>
		<meta charset="UTF-8">
		<title>이지부산</title>
		<%@ include file="/WEB-INF/view/layout/header.jsp" %>
			<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
					crossorigin="anonymous">
				<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
					integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
					crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
					integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
					crossorigin="anonymous"></script>
	</head>
	<section class="first-background">
		<img class="pattern-group" src="/images/img_pattern.png" />




		</div>
		<div class="city-box">
			<div class="city-text">당신을 위한 도시</div>
			<div class="city-name">부산</div>
		</div>
		<div class="site-text">당신을 위한 개인맞춤 컨설터</div>

		<img class="img_main" src="/images/img_main.png" />
		<a href="/question" class="no-underline">
			<div class="bt-play">
				<span class="play-text">지금 체험하기</span>
				<img src="/images/icon_arrow.png">
			</div>
		</a>
		<div class="qna-btn">
			<a href="/question"> <img alt="qna" src="/images/btn2.png">
				<div class="tooltip">나에게 맞는 부산 찾기</div>
			</a>

	</section>

	<section class="second-background section">
		<div class="second-container">
			<div class="a-1">부산, 새로운 시작을 꿈꾸는 당신에게 열려있는 도시입니다.</div>
			<div class="a-2"> 새로운 커리어를 시작하고, 가족과 함께 건강하고 행복한 삶을 누리세요.</div>
		</div>


		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
				aria-current="true" aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
				aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
				aria-label="Slide 3"></button>
		</div>
	</section>
	<section class="third-background section">
		<div class="third-container">
			<div class="b-1">당신을 위한 이주 컨설터 이지부산!</div>
			<div class="b-2">개인 유형별 맞춤형 컨설팅 웹사이트 이지부산 </div>
			<div class="content-group">
				<div class="third-box-blue">
					<div class="inner-content">
						<span class="white-title">신뢰성</span>
						<span class="white-main">공공기관에서 제공하는 최신화된 데이터에 기반한 정보 제공 </span>
					</div>
				</div>
				<div class="third-box-white">
					<div class="inner-content">
						<span class="content-title">맞춤형</span>
						<span class="content-main">MBTI 와 같은 질의 방식으로 개개인의 성향을 분석하여 사용자의 특성에 맞는 이주지역 추천</span>

					</div>
				</div>
				<div class="third-box-blue">
					<div class="inner-content">
						<span class="white-title">이주컨설팅</span>
						<span class="white-main">질의 결과에 따라 사용자의 특성에 맞는 타이틀과 함께 알맞은 지역 관련 소개 </span>
					</div>
				</div>
				<div class="third-box-white">
					<div class="inner-content">
						<span class="content-title">정보제공</span>
						<span class="content-main">부산 거주시 유용한 복지나 청년혜택 등 다양한 정보 제공</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript" src="/js/index.js" defer></script>
	<script type="text/javascript" src="/js/image.js" defer></script>

	<%@ include file="/WEB-INF/view/layout/footer.jsp" %>