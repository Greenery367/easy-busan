<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"
>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"
></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"
></script>
</head>
<section class="first-background">
	<div class="first-container">
		<div class="city-text"></div>
		<div class="city-name"></div>
		<div class="site-text"></div>
		<div class="site-name"></div>
	</div>
	<div class="qna-btn">
		<a href=""> <img alt="qna" src="/images/btn2.png">
			<div class="tooltip">나에게 맞는 부산 찾기</div>
		</a>
	</div>
</section>

<section class="second-background section">
	<div class="second-container">
		<h1>부산, 새로운 시작을 꿈꾸는 당신에게 열려있는 도시입니다.</h1>
		<p> 새로운 커리어를 시작하고, 가족과 함께 건강하고 행복한 삶을 누리세요.</p>
	</div>


	<div class="carousel-indicators">
		<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
		<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
		<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
	</div>
</section>
<section class="third-background section">
	<div class="third-container">
		<h1>당신을 위한 이주 컨설터 이지부산!</h1>
		<p>개인 유형별 맞춤형 컨설팅 웹사이트 이지부산 </p>
		<div class="offer-grid">
			
		</div>
	</div>
</section>

<script type="text/javascript" src="/js/index.js" defer></script>
<script type="text/javascript" src="/js/image.js" defer></script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

